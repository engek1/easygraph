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
		 *
		
		Graph<String, String> g = new IncidenceListGraph<String, String>(false);
		Vertex<String> vA = g.insertVertex("A");
		Vertex<String> vB = g.insertVertex("B");
		Vertex<String> vC = g.insertVertex("C");
		Vertex<String> vD = g.insertVertex("D");

		/*
		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vB.set(EGProperty.EG_COORDINATE_X, 250.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vC.set(EGProperty.EG_COORDINATE_X, 50.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vD.set(EGProperty.EG_COORDINATE_X, 250.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 250.0);
		*
		
		Edge<String> eAB = g.insertEdge(vA, vB, "A-B");
		Edge<String> eAC = g.insertEdge(vA, vC, "A-C");
		Edge<String> eAD = g.insertEdge(vA, vD, "A-D");
		Edge<String> eBD = g.insertEdge(vB, vD, "B-D");
		Edge<String> eCD = g.insertEdge(vC, vD, "C-D");
		*/
		
		
		// example graph from graphlib:
		//
		// A-->B-->C-->D
		// |\  |   |  /|
		// | \ |   | / |
		// v  vv   vv  v
		// E-->F   G-->H
		// |  /   /|\  |
		// | /   / | \ |
		// vv   v  v  vv
		// I-->J-->K   L
        // |\     /|   |
		// | \   / |   |
		// v  v v  v   v
		// M-->N-->O-->P
		
		
		IncidenceListGraph<String,String> g = new IncidenceListGraph<String,String> (true);
		// vertices
		Vertex<String> vA = g.insertVertex("A");
		Vertex<String> vB = g.insertVertex("B");
		Vertex<String> vC = g.insertVertex("C");
		Vertex<String> vD = g.insertVertex("D");
		Vertex<String> vE = g.insertVertex("E");
		Vertex<String> vF = g.insertVertex("F");
		Vertex<String> vG = g.insertVertex("G");
		Vertex<String> vH = g.insertVertex("H");
		Vertex<String> vI = g.insertVertex("I");
		Vertex<String> vJ = g.insertVertex("J");
		Vertex<String> vK = g.insertVertex("K");
		Vertex<String> vL = g.insertVertex("L");
		Vertex<String> vM = g.insertVertex("M");
		Vertex<String> vN = g.insertVertex("N");
		Vertex<String> vO = g.insertVertex("O");
		Vertex<String> vP = g.insertVertex("P");
		// edges:
		Edge<String> eAB = g.insertEdge(vA, vB, "AB"); 
		Edge<String> eBC = g.insertEdge(vB, vC, "BC"); 
		Edge<String> eCD = g.insertEdge(vC, vD, "CD"); 
		Edge<String> eAE = g.insertEdge(vA, vE, "AE"); 
		Edge<String> eAF = g.insertEdge(vA, vF, "AF"); 
		Edge<String> eBF = g.insertEdge(vB, vF, "BF"); 
		Edge<String> eCG = g.insertEdge(vC, vG, "CG"); 
		Edge<String> eDG = g.insertEdge(vD, vG, "DG"); 
		Edge<String> eDH = g.insertEdge(vD, vH, "DH"); 
		Edge<String> eEF = g.insertEdge(vE, vF, "EF"); 
		Edge<String> eGH = g.insertEdge(vG, vH, "GH"); 
		Edge<String> eEI = g.insertEdge(vE, vI, "EI"); 
		Edge<String> eFI = g.insertEdge(vF, vI, "FI"); 
		Edge<String> eGJ = g.insertEdge(vG, vJ, "GJ"); 
		Edge<String> eGK = g.insertEdge(vG, vK, "GK"); 
		Edge<String> eGL = g.insertEdge(vG, vL, "GL"); 
		Edge<String> eHL = g.insertEdge(vH, vL, "HL"); 
		Edge<String> eIJ = g.insertEdge(vI, vJ, "IJ"); 
		Edge<String> eJK = g.insertEdge(vJ, vK, "JK"); 
		Edge<String> eIM = g.insertEdge(vI, vM, "IM"); 
		Edge<String> eIN = g.insertEdge(vI, vN, "IN"); 
		Edge<String> eKN = g.insertEdge(vK, vN, "KN"); 
		Edge<String> eKO = g.insertEdge(vK, vO, "KO"); 
		Edge<String> eLP = g.insertEdge(vL, vP, "LP"); 
		Edge<String> eMN = g.insertEdge(vM, vN, "MN"); 
		Edge<String> eNO = g.insertEdge(vN, vO, "NO"); 
		Edge<String> eOP = g.insertEdge(vO, vP, "OP"); 	
		
		EasyGraph.launchGui(g);
	}

}
