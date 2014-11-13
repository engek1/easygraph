package easygraph.controller.mode;

import easygraph.controller.RootController;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class AddVertexMode extends Mode {

	public AddVertexMode(RootController rootController) {
		super(rootController);
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		rootController.addVertex(x, y);
	}

	@Override
	public void vertexClicked(Vertex vertex) {
		// do nothing
	}

}
