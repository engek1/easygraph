package easygraph.examplegraphs;

import easygraph.model.EGProperty;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

public class Samples {
	
	
	/*
	 * 
	 * 	A --- B
	 * 	| \   |
	 *  |  C  |
	 *  |   \ |
	 *  D --- E
	 * 
	 */
	public IncidenceListGraph<?,?> getExampleOne() {
		
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (false);
		Vertex<String> vA = graph.insertVertex("A");
		Vertex<String> vB = graph.insertVertex("B");
		Vertex<String> vC = graph.insertVertex("C");
		Vertex<String> vD = graph.insertVertex("D");
		Vertex<String> vE = graph.insertVertex("E");

		graph.insertEdge(vA, vB, "A-B");
		graph.insertEdge(vA, vC, "A-C");
		graph.insertEdge(vA, vD, "A-D");
		graph.insertEdge(vB, vE, "B-E");
		graph.insertEdge(vC, vE, "C-E");
		graph.insertEdge(vD, vE, "D-E");
		
		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vB.set(EGProperty.EG_COORDINATE_X, 450.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vC.set(EGProperty.EG_COORDINATE_X, 250.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vD.set(EGProperty.EG_COORDINATE_X, 50.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 450.0);
		
		vE.set(EGProperty.EG_COORDINATE_X, 450.0);
		vE.set(EGProperty.EG_COORDINATE_Y, 450.0);
		
		return graph;
	}
	
	
	/*
	 * 	A -- B -- C
	 * 	|    |    |
	 * 	D -- E -- F
	 *  |    |    |
	 * 	G -- H -- I 
	 */
	public IncidenceListGraph<?,?> getExampleTwo() {
		
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (false);
		Vertex<String> vA = graph.insertVertex("A");
		Vertex<String> vB = graph.insertVertex("B");
		Vertex<String> vC = graph.insertVertex("C");
		Vertex<String> vD = graph.insertVertex("D");
		Vertex<String> vE = graph.insertVertex("E");
		Vertex<String> vF = graph.insertVertex("F");
		Vertex<String> vG = graph.insertVertex("G");
		Vertex<String> vH = graph.insertVertex("H");
		Vertex<String> vI = graph.insertVertex("J");

		graph.insertEdge(vA, vB, "A-B");
		graph.insertEdge(vA, vD, "A-D");
		graph.insertEdge(vB, vC, "B-C");
		graph.insertEdge(vB, vE, "B-E");
		graph.insertEdge(vC, vF, "C-F");
		graph.insertEdge(vD, vE, "D-E");
		graph.insertEdge(vD, vG, "D-G");
		graph.insertEdge(vE, vF, "E-F");
		graph.insertEdge(vE, vH, "E-H");
		graph.insertEdge(vF, vI, "F-J");
		graph.insertEdge(vG, vH, "G-H");
		graph.insertEdge(vH, vI, "H-J");
		
		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vB.set(EGProperty.EG_COORDINATE_X, 250.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vC.set(EGProperty.EG_COORDINATE_X, 450.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vD.set(EGProperty.EG_COORDINATE_X, 50.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vE.set(EGProperty.EG_COORDINATE_X, 250.0);
		vE.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vF.set(EGProperty.EG_COORDINATE_X, 450.0);
		vF.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vG.set(EGProperty.EG_COORDINATE_X, 50.0);
		vG.set(EGProperty.EG_COORDINATE_Y, 450.0);
		
		vH.set(EGProperty.EG_COORDINATE_X, 250.0);
		vH.set(EGProperty.EG_COORDINATE_Y, 450.0);
		
		vI.set(EGProperty.EG_COORDINATE_X, 450.0);
		vI.set(EGProperty.EG_COORDINATE_Y, 450.0);
		
		return graph;
	}
	
	
	/*
	 * 
	 */
	public IncidenceListGraph<?,?> getExampleThree() {
		
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (false);
		// ...
		return graph;
	}
	
	
	/*
	 * 
	 */
	public IncidenceListGraph<?,?> getExampleFour() {
		
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (false);
		// ...
		return graph;
	}

}
