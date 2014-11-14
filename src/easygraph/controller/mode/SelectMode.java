package easygraph.controller.mode;

import easygraph.controller.RootController;
import graphlib.Vertex;

/**
 * Drag-n-drop mode.
 * 
 * @author engek1
 *
 */
public class SelectMode extends Mode {

	public SelectMode(RootController rootController) {
		super(rootController);
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		// do nothing
	}

	@Override
	public void vertexClicked(Vertex vertex) {
		// show vertex details
	}

}