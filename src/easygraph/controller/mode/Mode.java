package easygraph.controller.mode;

import easygraph.controller.RootController;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public abstract class Mode {

	RootController rootController;

	public Mode(RootController rootController) {
		this.rootController = rootController;
	}
	
	public abstract void drawViewLeftClick(double x, double y);

	public abstract void vertexClicked(Vertex vertex);

}
