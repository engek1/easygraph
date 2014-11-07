package easygraph.test;

import easygraph.EasyGraph;
import easygraph.model.Coordinate;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

public class TestLauncher {
	
	public static void main(String[] args) {
		
		/*
			A --- B
			| \   |
			|  \  |
			|   \ |
			C --- D
		 */
		
		Graph<String, String> g = new IncidenceListGraph<String, String>(false);
		Vertex<String> vA = g.insertVertex("A");
		Vertex<String> vB = g.insertVertex("B");
		Vertex<String> vC = g.insertVertex("C");
		Vertex<String> vD = g.insertVertex("D");

		vA.set(EGProperty.EG_COORDINATES, new Coordinate(50, 50));
		vB.set(EGProperty.EG_COORDINATES, new Coordinate(250, 50));
		vC.set(EGProperty.EG_COORDINATES, new Coordinate(50, 250));
		vD.set(EGProperty.EG_COORDINATES, new Coordinate(250, 250));
		
		Edge<String> eAB = g.insertEdge(vA, vB, "A-B");
		Edge<String> eAC = g.insertEdge(vA, vC, "A-C");
		Edge<String> eAD = g.insertEdge(vA, vD, "A-D");
		Edge<String> eBD = g.insertEdge(vB, vD, "B-D");
		Edge<String> eCD = g.insertEdge(vC, vD, "C-D");

		EasyGraph.launchGui(g);
	}

}
