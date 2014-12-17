package easygraph.state;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.scene.layout.Pane;
import easygraph.annotations.AlgorithmMethod;
import easygraph.application.Editor;
import easygraph.events.PlayEvent;
import easygraph.events.ResetEvent;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Vertex;

public class PlayState extends State {
	
	private Pane pane;
	private String algorithm;
	private boolean autoPlay = true;

	public PlayState(Editor editor, Pane pane, String algorithm) {
		super(editor);
		this.pane = pane;
		this.algorithm = algorithm;
		this.call();
	}
	
	
	@Override
	public void handle(PlayEvent event) {
		System.out.println("PlayEvent fired.");

		try {
			/*
			do {
				System.out.println("sdfgn");
				if (this.editor.hasForwardSteps()) {
					this.editor.forward();
					Thread.sleep(1000);
				}
			} while (this.autoPlay && this.editor.hasForwardSteps());
			*/
			
			// make a forward step if there is at least one.
			if (this.editor.hasForwardSteps()) {
				if (!Thread.interrupted()) {
					//Platform.runLater(() -> this.editor.forward());
					this.editor.forward();
				}
			}
			
			// if we are in autoplay and there are more forward steps,
			// wait for some time, then fire the next event.
			if (this.editor.hasForwardSteps() && this.autoPlay) {
				Thread.sleep(1000);
				Platform.runLater(() -> Event.fireEvent(PlayState.this.pane, new PlayEvent()));
				//Event.fireEvent(this.pane, new PlayEvent());
				//this.handle(event);
			}
			
		} catch (InterruptedException e) {
			System.out.println("WARNING: InterruptedException catched in PlayState.");
		}
	}
	
	
	@Override
	public void handle(ResetEvent event) {
		this.autoPlay = false;
		Thread.currentThread().interrupt();
		this.editor.unmarkVertices();
		this.editor.unmarkEdges();
	}
	
	
	
	private void call() {
		try {
			// load instance of AlgorithmsCollection and try to reference the Method with by its name
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(Config.getLookupAlgorithmClassName());
			
			List<Object> params = new ArrayList<Object>();
			Method method = null;
			AlgorithmMethod annotation = null;
			
			for (Method m : clazz.getDeclaredMethods()) {
				if (m.isAnnotationPresent(AlgorithmMethod.class)) {
					if (m.getName().equals(this.algorithm)) {
						annotation = m.getDeclaredAnnotation(AlgorithmMethod.class);
						method = m;
					}
				}
			}
			
			if (method == null) {
				System.out.println("no method found!");
				// TODO error handling
				return;
			}
			
			// create a parameters object array for the method call
			params.add(this.editor.getGraph());
			
			// thanks to the annotation, we chan easily check whether the method needs a start vertex
			if (annotation.needsStartVertex()) {
				int nr = this.editor.getNumberOfStartVertices();
				
				// for test reasons, just use dijkstra algorithm
				nr = 1;
				
				if (nr == 1) {
					//params.add(this.editor.getStartVertex());
					params.add(this.editor.getGraph().vertices().next());
				}
				else {
					String text = "";
					if (nr == 0) {
						text = "The selected algorithm needs to have a starting Vertex. " + 
						  "Please define one by right-clicking on a Vertex, then selecting on 'mark as Start Vertex'.";
					} else {
						text = "The selected algorithm needs to have exactly one starting Vertex.";
					}
					this.showErrorDialog(text);
					this.changeState(new SelectState(this.editor));
					return;
				}
			}
			
			// checks if the annotation needs another parameter or not
			if (annotation.needsDijkstraFlag()) {
				params.add(false);
			}
			
			// invoke the method on the clazz instance and deliver the necessary params to it
			method.invoke(clazz.newInstance(), params.toArray());
			
			System.out.println("Invoking of '" + this.algorithm + "' finished, let the step-by-step mode begin ...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
