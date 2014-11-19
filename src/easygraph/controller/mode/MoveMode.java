package easygraph.controller.mode;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class MoveMode extends Mode {

	public MoveMode(Editor editor) {
		super(editor);
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		// do nothing
	}

	@Override
	public void vertexClicked(Vertex<?> vertex) {
		// TODO Auto-generated method stub
		// show vertex details
	}

	@Override
	public void edgeClicked(Edge<?> edge) {
		// do nothing
	}

}
