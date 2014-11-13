package easygraph.controller.mode;

import easygraph.controller.RootController;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class AddEdgeMode extends Mode {

	Vertex fromVertex = null;

	public AddEdgeMode(RootController rootController) {
		super(rootController);
		System.out.println("change to: " + getClass().getName());
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
		// do nothing
	}

	@Override
	public void vertexClicked(Vertex vertex) {

		if (fromVertex == null) {
			this.fromVertex = vertex;
		}else{
			rootController.addEdge(fromVertex, vertex);
			this.fromVertex = null;
		}

	}

}
