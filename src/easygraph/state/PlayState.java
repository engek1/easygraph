package easygraph.state;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import easygraph.annotations.AlgorithmMethod;
import easygraph.application.Editor;
import easygraph.events.PlayEvent;
import easygraph.utils.Config;

public class PlayState extends State {
	
	private String algorithm;

	public PlayState(Editor editor, String algorithm) {
		super(editor);
		this.algorithm = algorithm;
	}
	
	@Override
	public void handle(PlayEvent event) {
		System.out.println("start playing now -- selected algorithm = '" + this.algorithm + "' ...");

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
				if (nr == 1) {
					params.add(this.editor.getStartVertex());
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
