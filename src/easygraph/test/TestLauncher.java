package easygraph.test;

import easygraph.EasyGraph;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

public class TestLauncher {
	
	public static void main(String[] args) {
		
		IncidenceListGraph<String,String> egGraph = new IncidenceListGraph<String,String> (false);
		
		
//				A --- B
//				| \   |
//				|  \  |
//				|   \ |
//				C --- D
//
		Vertex<String> vA = egGraph.insertVertex("A");
		Vertex<String> vB = egGraph.insertVertex("B");
		Vertex<String> vC = egGraph.insertVertex("C");
		Vertex<String> vD = egGraph.insertVertex("D");

		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vB.set(EGProperty.EG_COORDINATE_X, 250.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);
		
		vC.set(EGProperty.EG_COORDINATE_X, 50.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		vD.set(EGProperty.EG_COORDINATE_X, 250.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 250.0);
		
		Edge<String> eAB = egGraph.insertEdge(vA, vB, "A-B");
		Edge<String> eAC = egGraph.insertEdge(vA, vC, "A-C");
		Edge<String> eAD = egGraph.insertEdge(vA, vD, "A-D");
		Edge<String> eBD = egGraph.insertEdge(vB, vD, "B-D");
		Edge<String> eCD = egGraph.insertEdge(vC, vD, "C-D");
		
		
		
		
		
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
		
		IncidenceListGraph<String,String> schwabGraph = new IncidenceListGraph<String,String> (false);
		
		Vertex<String> A = schwabGraph.insertVertex("A");
		Vertex<String> B = schwabGraph.insertVertex("B");
		Vertex<String> C = schwabGraph.insertVertex("C");
		Vertex<String> D = schwabGraph.insertVertex("D");
		Vertex<String> E = schwabGraph.insertVertex("E");
		Vertex<String> F = schwabGraph.insertVertex("F");
		Vertex<String> G = schwabGraph.insertVertex("G");
		Vertex<String> H = schwabGraph.insertVertex("H");
		Vertex<String> I = schwabGraph.insertVertex("I");
		Vertex<String> J = schwabGraph.insertVertex("J");
		Vertex<String> K = schwabGraph.insertVertex("K");
		Vertex<String> L = schwabGraph.insertVertex("L");
		Vertex<String> M = schwabGraph.insertVertex("M");
		Vertex<String> N = schwabGraph.insertVertex("N");
		Vertex<String> O = schwabGraph.insertVertex("O");
		Vertex<String> P = schwabGraph.insertVertex("P");
		
		Edge<String> AB = schwabGraph.insertEdge(A, B, "AB"); 
		Edge<String> BC = schwabGraph.insertEdge(B, C, "BC"); 
		Edge<String> CD = schwabGraph.insertEdge(C, D, "CD"); 
		Edge<String> AE = schwabGraph.insertEdge(A, E, "AE"); 
		Edge<String> AF = schwabGraph.insertEdge(A, F, "AF"); 
		Edge<String> BF = schwabGraph.insertEdge(B, F, "BF"); 
		Edge<String> CG = schwabGraph.insertEdge(C, G, "CG"); 
		Edge<String> DG = schwabGraph.insertEdge(D, G, "DG"); 
		Edge<String> DH = schwabGraph.insertEdge(D, H, "DH"); 
		Edge<String> EF = schwabGraph.insertEdge(E, F, "EF"); 
		Edge<String> GH = schwabGraph.insertEdge(G, H, "GH"); 
		Edge<String> EI = schwabGraph.insertEdge(E, I, "EI"); 
		Edge<String> FI = schwabGraph.insertEdge(F, I, "FI"); 
		Edge<String> GJ = schwabGraph.insertEdge(G, J, "GJ"); 
		Edge<String> GK = schwabGraph.insertEdge(G, K, "GK"); 
		Edge<String> GL = schwabGraph.insertEdge(G, L, "GL"); 
		Edge<String> HL = schwabGraph.insertEdge(H, L, "HL"); 
		Edge<String> IJ = schwabGraph.insertEdge(I, J, "IJ"); 
		Edge<String> JK = schwabGraph.insertEdge(J, K, "JK"); 
		Edge<String> IM = schwabGraph.insertEdge(I, M, "IM"); 
		Edge<String> IN = schwabGraph.insertEdge(I, N, "IN"); 
		Edge<String> KN = schwabGraph.insertEdge(K, N, "KN"); 
		Edge<String> KO = schwabGraph.insertEdge(K, O, "KO"); 
		Edge<String> LP = schwabGraph.insertEdge(L, P, "LP"); 
		Edge<String> MN = schwabGraph.insertEdge(M, N, "MN"); 
		Edge<String> NO = schwabGraph.insertEdge(N, O, "NO"); 
		Edge<String> OP = schwabGraph.insertEdge(O, P, "OP");
		

		EasyGraph.launchGui(egGraph);
	}

}
