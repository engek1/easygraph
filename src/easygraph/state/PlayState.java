package easygraph.state;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.application.Platform;
import easygraph.annotations.AlgorithmMethod;
import easygraph.application.Editor;
import easygraph.events.BackwardEvent;
import easygraph.events.ForwardEvent;
import easygraph.events.PauseEvent;
import easygraph.events.PlayEvent;
import easygraph.events.ResetEvent;
import easygraph.guielements.Texts;
import easygraph.utils.Config;

public class PlayState extends State {
		
	private String algorithm;
	private AtomicBoolean autoPlay;

	public PlayState(Editor editor, String algorithm) {
		super(editor);
		this.algorithm = algorithm;
		this.autoPlay = new AtomicBoolean(true);
		//this.call();
	}
	
	
	@Override
	public void handle(PlayEvent event) {

		// only start TimerTask if method invoking was ok.
		if (this.call()) {
		
			TimerTask action = new TimerTask() {
				@Override
				public void run() {
					System.out.println("TimerTask running...");
					if (!PlayState.this.autoPlay.get() || !PlayState.this.editor.hasForwardSteps()) {
						Platform.runLater(() -> this.cancel());
						System.out.println("No AutoPlay or No ForwardSteps found, cancelling...");
					} else {
						Platform.runLater(() -> PlayState.this.editor.forward());
					}
				}
			};
			
			new Timer().schedule(action, Config.getDelay(), this.editor.getSpeed());
		}
		else {
			this.changeState(new SelectState(this.editor));
		}
	}
	
	
	@Override
	public void handle(ResetEvent event) {
		this.autoPlay.set(false);
		this.editor.reset();
		this.changeState(new SelectState(this.editor));
	}
	
	@Override
	public void handle(PauseEvent event) {
		this.autoPlay.set(false);
	}
	
	@Override
	public void handle(ForwardEvent event) {
		Platform.runLater(() -> PlayState.this.editor.forward());
	}
	
	@Override
	public void handle(BackwardEvent event) {
		Platform.runLater(() -> PlayState.this.editor.backward());
	}
	

	private boolean call() {
		try {
			// load instance of AlgorithmsCollection and try to reference the Method with by its name
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(Config.getLookupAlgorithmClassName());
			
			// create a parameters object array for the method call
			List<Object> params = new ArrayList<Object>();
			params.add(this.editor.getGraph());
			
			// find out which method was selected and load its annotation
			Method selectedMethod = this.getMethod(clazz.getDeclaredMethods());;
			AlgorithmMethod annotation = selectedMethod.getDeclaredAnnotation(AlgorithmMethod.class);
			

			// thanks to the annotation, we chan easily check whether the method needs a start vertex
			if (annotation.needsStartVertex()) {
				int nr = this.editor.getNumberOfStartVertices();
				
				if (nr == 1) {
					params.add(this.editor.getStartVertex());
				} else {
					this.showErrorDialog(Texts.ERROR_WRONG_STARTVERTEX_NUMBER);
					return false;
				}
			}
			
			// checks if the annotation needs another parameter or not
			if (annotation.needsDijkstraFlag()) {
				params.add(false);
			}
			
			// invoke the method on the clazz instance and deliver the necessary params to it
			selectedMethod.invoke(clazz.newInstance(), params.toArray());
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	private Method getMethod(Method[] methods) {
		for (Method method : methods) {
			if (method.isAnnotationPresent(AlgorithmMethod.class)) {
				if (method.getName().equals(this.algorithm)) {
					return method;
				}
			}
		}
		return null;
	}
}
