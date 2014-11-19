package easygraph.application;

import graphlib.Vertex;

public interface GraphController {

	void addVertex(double x, double y);

	void addEdge(Vertex fromVertex, Vertex toVertex);
}
