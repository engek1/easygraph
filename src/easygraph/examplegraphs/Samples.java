package easygraph.examplegraphs;

import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

public class Samples {

	/*
	 * Graph example 1
	 * 
	 * A --- B | \ | | C | | \ | D --- E
	 */
	public IncidenceListGraph<?, ?> getExampleOne() {

		IncidenceListGraph<String, String> graph = new IncidenceListGraph<String, String>(
				false);
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
	 * Graph example 2
	 * 
	 * A -- B -- C | | | D -- E -- F | | | G -- H -- I
	 */
	public IncidenceListGraph<?, ?> getExampleTwo() {

		IncidenceListGraph<String, String> graph = new IncidenceListGraph<String, String>(
				false);
		Vertex<String> vA = graph.insertVertex("A");
		Vertex<String> vB = graph.insertVertex("B");
		Vertex<String> vC = graph.insertVertex("C");
		Vertex<String> vD = graph.insertVertex("D");
		Vertex<String> vE = graph.insertVertex("E");
		Vertex<String> vF = graph.insertVertex("F");
		Vertex<String> vG = graph.insertVertex("G");
		Vertex<String> vH = graph.insertVertex("H");
		Vertex<String> vI = graph.insertVertex("I");

		graph.insertEdge(vA, vB, "A-B");
		graph.insertEdge(vA, vD, "A-D");
		graph.insertEdge(vB, vC, "B-C");
		graph.insertEdge(vB, vE, "B-E");
		graph.insertEdge(vC, vF, "C-F");
		graph.insertEdge(vD, vE, "D-E");
		graph.insertEdge(vD, vG, "D-G");
		graph.insertEdge(vE, vF, "E-F");
		graph.insertEdge(vE, vH, "E-H");
		graph.insertEdge(vF, vI, "F-I");
		graph.insertEdge(vG, vH, "G-H");
		graph.insertEdge(vH, vI, "H-I");

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
	 * Graph Example 3
	 * 
	 * A-->B------>C | | \ | v | v v E-->D | F-->J | \ | / ^ v vvv | G-->H-->I
	 */
	public IncidenceListGraph<?, ?> getExampleThree() {

		IncidenceListGraph<String, String> graph = new IncidenceListGraph<String, String>(
				false);

		Vertex<String> vA = graph.insertVertex("A");
		Vertex<String> vB = graph.insertVertex("B");
		Vertex<String> vC = graph.insertVertex("C");
		Vertex<String> vD = graph.insertVertex("D");
		Vertex<String> vE = graph.insertVertex("E");
		Vertex<String> vF = graph.insertVertex("F");
		Vertex<String> vG = graph.insertVertex("G");
		Vertex<String> vH = graph.insertVertex("H");
		Vertex<String> vI = graph.insertVertex("I");
		Vertex<String> vJ = graph.insertVertex("J");

		graph.insertEdge(vA, vB, "A-B");
		graph.insertEdge(vA, vD, "A-D");
		graph.insertEdge(vB, vC, "B-C");
		graph.insertEdge(vB, vH, "B-H");
		graph.insertEdge(vB, vF, "B-F");
		graph.insertEdge(vC, vJ, "C-J");
		graph.insertEdge(vD, vG, "D-G");
		graph.insertEdge(vD, vH, "D-H");
		graph.insertEdge(vE, vD, "E-D");
		graph.insertEdge(vF, vJ, "F-J");
		graph.insertEdge(vF, vH, "F-H");
		graph.insertEdge(vG, vH, "G-H");
		graph.insertEdge(vH, vI, "H-I");
		graph.insertEdge(vI, vF, "I-F");

		vA.set(EGProperty.EG_COORDINATE_X, 150.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vB.set(EGProperty.EG_COORDINATE_X, 250.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vC.set(EGProperty.EG_COORDINATE_X, 450.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vD.set(EGProperty.EG_COORDINATE_X, 150.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vE.set(EGProperty.EG_COORDINATE_X, 50.0);
		vE.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vF.set(EGProperty.EG_COORDINATE_X, 350.0);
		vF.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vG.set(EGProperty.EG_COORDINATE_X, 150.0);
		vG.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vH.set(EGProperty.EG_COORDINATE_X, 250.0);
		vH.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vI.set(EGProperty.EG_COORDINATE_X, 350.0);
		vI.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vJ.set(EGProperty.EG_COORDINATE_X, 450.0);
		vJ.set(EGProperty.EG_COORDINATE_Y, 150.0);

		return graph;
	}

	/*
	 * Graph example 4
	 * 
	 * A-->B-->C-->D |\ | | /| | \ | | / | v vv vv v E-->F G-->H | / /|\ | | / /
	 * | \ | vv v v vv I-->J-->K L |\ /| | | \ / | | v v v v v M-->N-->O-->P
	 */
	public IncidenceListGraph<?, ?> getExampleFour() {

		IncidenceListGraph<String, String> graph = new IncidenceListGraph<String, String>(
				false);

		Vertex<String> vA = graph.insertVertex("A");
		Vertex<String> vB = graph.insertVertex("B");
		Vertex<String> vC = graph.insertVertex("C");
		Vertex<String> vD = graph.insertVertex("D");
		Vertex<String> vE = graph.insertVertex("E");
		Vertex<String> vF = graph.insertVertex("F");
		Vertex<String> vG = graph.insertVertex("G");
		Vertex<String> vH = graph.insertVertex("H");
		Vertex<String> vI = graph.insertVertex("I");
		Vertex<String> vJ = graph.insertVertex("J");
		Vertex<String> vK = graph.insertVertex("K");
		Vertex<String> vL = graph.insertVertex("L");
		Vertex<String> vM = graph.insertVertex("M");
		Vertex<String> vN = graph.insertVertex("N");
		Vertex<String> vO = graph.insertVertex("O");
		Vertex<String> vP = graph.insertVertex("P");

		graph.insertEdge(vA, vB, "A-B").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vA, vE, "A-E").set(EGProperty.WEIGHT, 1.0);
		graph.insertEdge(vA, vF, "A-F").set(EGProperty.WEIGHT, 7.0);
		graph.insertEdge(vB, vC, "B-C").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vB, vF, "B-F").set(EGProperty.WEIGHT, 6.0);
		graph.insertEdge(vC, vD, "C-D").set(EGProperty.WEIGHT, 5.0);
		graph.insertEdge(vC, vG, "C-G").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vD, vG, "D-G").set(EGProperty.WEIGHT, 2.0);
		graph.insertEdge(vD, vH, "D-H").set(EGProperty.WEIGHT, 8.0);
		graph.insertEdge(vE, vF, "E-F").set(EGProperty.WEIGHT, 1.0);
		graph.insertEdge(vE, vI, "E-I").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vF, vI, "F-I").set(EGProperty.WEIGHT, 6.0);
		graph.insertEdge(vG, vH, "G-H").set(EGProperty.WEIGHT, 5.0);
		graph.insertEdge(vG, vJ, "G-J").set(EGProperty.WEIGHT, 1.0);
		graph.insertEdge(vG, vK, "G-K").set(EGProperty.WEIGHT, 2.0);
		graph.insertEdge(vG, vL, "G-L").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vH, vL, "H-L").set(EGProperty.WEIGHT, 6.0);
		graph.insertEdge(vI, vM, "I-M").set(EGProperty.WEIGHT, 9.0);
		graph.insertEdge(vI, vN, "I-N").set(EGProperty.WEIGHT, 10.0);
		graph.insertEdge(vI, vJ, "I-J").set(EGProperty.WEIGHT, 22.0);
		graph.insertEdge(vJ, vK, "J-K").set(EGProperty.WEIGHT, 2.0);
		graph.insertEdge(vK, vN, "K-N").set(EGProperty.WEIGHT, 3.0);
		graph.insertEdge(vK, vO, "K-O").set(EGProperty.WEIGHT, 5.0);
		graph.insertEdge(vL, vP, "L-P").set(EGProperty.WEIGHT, 2.0);
		graph.insertEdge(vM, vN, "M-N").set(EGProperty.WEIGHT, 4.0);
		graph.insertEdge(vN, vO, "N-O").set(EGProperty.WEIGHT, 6.0);
		graph.insertEdge(vO, vP, "O-P").set(EGProperty.WEIGHT, 1.0);

		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vB.set(EGProperty.EG_COORDINATE_X, 150.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vC.set(EGProperty.EG_COORDINATE_X, 250.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vD.set(EGProperty.EG_COORDINATE_X, 350.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vE.set(EGProperty.EG_COORDINATE_X, 50.0);
		vE.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vF.set(EGProperty.EG_COORDINATE_X, 150.0);
		vF.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vG.set(EGProperty.EG_COORDINATE_X, 250.0);
		vG.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vH.set(EGProperty.EG_COORDINATE_X, 350.0);
		vH.set(EGProperty.EG_COORDINATE_Y, 150.0);

		vI.set(EGProperty.EG_COORDINATE_X, 50.0);
		vI.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vJ.set(EGProperty.EG_COORDINATE_X, 150.0);
		vJ.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vK.set(EGProperty.EG_COORDINATE_X, 250.0);
		vK.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vL.set(EGProperty.EG_COORDINATE_X, 350.0);
		vL.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vM.set(EGProperty.EG_COORDINATE_X, 50.0);
		vM.set(EGProperty.EG_COORDINATE_Y, 350.0);

		vN.set(EGProperty.EG_COORDINATE_X, 150.0);
		vN.set(EGProperty.EG_COORDINATE_Y, 350.0);

		vO.set(EGProperty.EG_COORDINATE_X, 250.0);
		vO.set(EGProperty.EG_COORDINATE_Y, 350.0);

		vP.set(EGProperty.EG_COORDINATE_X, 350.0);
		vP.set(EGProperty.EG_COORDINATE_Y, 350.0);

		return graph;
	}

}
