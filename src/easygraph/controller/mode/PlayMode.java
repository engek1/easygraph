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
public class PlayMode extends Mode {

	public PlayMode(Editor editor) {
		super(editor);
		System.out.println("play mode: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {}

	@Override
	public void vertexClicked(Vertex<?> vertex) {}

	@Override
	public void editEdge(Edge<?> edge) {}

	@Override
	public void editVertex(Vertex<?> vertex) {}

	@Override
	public void vertexPressed(GuiVertex guiVertex) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void drawViewMouseReleased(double x, double y) {
		// TODO Auto-generated method stub
	}

}

