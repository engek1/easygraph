package easygraph.controller;

import graphlib.Vertex;
import javafx.scene.input.MouseEvent;

/**
 * 
 * @author engek1
 *
 */
public interface RootController {

	void handleDrawViewLeftClick(MouseEvent event);

	void handleAddVertexMode();

	void handleSelectMode();

	void addVertex(double x, double y);

	void handleAddEdgeUnweigUndirMode();

	void handleAddEdgeWeigUndirMode();

	void handleAddEdgeUnweigDirMode();

	void handleAddEdgeWeigDirMode();

	void handleVertexClick(Vertex vertex);

	void addEdge(Vertex fromVertex, Vertex toVertex);

	
	
}
