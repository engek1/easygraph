package easygraph.test;

import easygraph.EasyGraph;
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
		
		vA.set(EGProperty.COORDINATE_X, 10);
		vA.set(EGProperty.COORDINATE_Y, 10);
		
		vB.set(EGProperty.COORDINATE_X, 210);
		vB.set(EGProperty.COORDINATE_Y, 10);
		
		vC.set(EGProperty.COORDINATE_X, 10);
		vC.set(EGProperty.COORDINATE_Y, 210);
		
		vD.set(EGProperty.COORDINATE_X, 210);
		vD.set(EGProperty.COORDINATE_Y, 210);
		
		Edge<String> eAB = g.insertEdge(vA, vB, "A-B");
		Edge<String> eAC = g.insertEdge(vA, vC, "A-C");
		Edge<String> eAD = g.insertEdge(vA, vD, "A-D");
		Edge<String> eBD = g.insertEdge(vB, vD, "B-D");
		Edge<String> eCD = g.insertEdge(vC, vD, "C-D");

		EasyGraph.launchGui(g);
	}

}
