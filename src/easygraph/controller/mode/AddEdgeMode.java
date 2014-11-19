package easygraph.controller.mode;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class AddEdgeMode extends Mode {

	Vertex fromVertex = null;

	public AddEdgeMode(Editor editor) {
		super(editor);
		System.out.println("change to: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		// do nothing
	}

	@Override
	public void vertexClicked(Vertex<?> vertex) {

		if (fromVertex == null) {
			this.fromVertex = vertex;
		}else{
			editor.addEdge(fromVertex, vertex);
			this.fromVertex = null;
		}

	}

	@Override
	public void edgeClicked(Edge<?> edge) {
		// do nothing
	}

}
