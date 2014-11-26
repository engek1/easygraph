package easygraph.controller.mode;

import easygraph.application.Editor;
import easygraph.guielements.GuiVertex;
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

	/* do nothing */

	@Override
	public void vertexClicked(Vertex<?> vertex) {}

	@Override
	public void editEdge(Edge<?> edge) {}

	@Override
	public void editVertex(Vertex<?> vertex) {}

	@Override
	public void vertexPressed(GuiVertex guiVertex) {}

	@Override
	public void drawViewMouseReleased(double x, double y) {}


}
