package easygraph.controller.mode;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class AddVertexMode extends Mode {

	public AddVertexMode(Editor editor) {
		super(editor);
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		editor.addVertex(x, y);
	}

	@Override
	public void vertexClicked(Vertex<?> vertex) {
		// do nothing
	}

	@Override
	public void edgeClicked(Edge<?> edge) {
		// do nothing
	}

}
