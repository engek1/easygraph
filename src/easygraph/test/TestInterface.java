package easygraph.test;

import java.util.Iterator;

import javafx.scene.paint.Color;
import easygraph.EasyGraph;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.HeapPriorityQueue;
import graphlib.IncidenceListGraph;
import graphlib.Locator;
import graphlib.Property;
import graphlib.Vertex;

public class TestInterface<V,E> {

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

		vA.set(EGProperty.EG_COORDINATE_X, 50.0);
		vA.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vB.set(EGProperty.EG_COORDINATE_X, 250.0);
		vB.set(EGProperty.EG_COORDINATE_Y, 50.0);

		vC.set(EGProperty.EG_COORDINATE_X, 50.0);
		vC.set(EGProperty.EG_COORDINATE_Y, 250.0);

		vD.set(EGProperty.EG_COORDINATE_X, 250.0);
		vD.set(EGProperty.EG_COORDINATE_Y, 250.0);

		Edge<String> eAB = g.insertEdge(vA, vB, "A-B");
		Edge<String> eAC = g.insertEdge(vA, vC, "A-C");
		Edge<String> eAD = g.insertEdge(vA, vD, "A-D");
		Edge<String> eBD = g.insertEdge(vB, vD, "B-D");
		Edge<String> eCD = g.insertEdge(vC, vD, "C-D");
		
		// init GUI
		Runnable guiThread = new Runnable() {
			
			@Override
			public void run() {
				EasyGraph.launchGui(g);
			}
		};
		new Thread(guiThread).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("##### START ALGORITHM...");
		
		// start Algorithm
//		TestAlgorithms<String, String> algos = new TestAlgorithms<String, String>();
//		algos.dijkstra(g, vA);
		
		EasyGraph.setSelected(vA);
		
		EasyGraph.setDiscovered(vA);
		EasyGraph.setDiscovered(eAB);
		EasyGraph.setDiscovered(vB);
		EasyGraph.setDiscovered(eAC);
		EasyGraph.setDiscovered(vC);
		EasyGraph.setDiscovered(eAD);
		EasyGraph.setDiscovered(vD);
		
		EasyGraph.setSelected(eAC);
		EasyGraph.setSelected(vC);
		
		EasyGraph.setDisabled(vB);
		EasyGraph.setDisabled(eAB);
		EasyGraph.setDisabled(vD);
		EasyGraph.setDisabled(eAD);
		
		// then execute steps
		for (int i = 0; i < 20; i++) {
			EasyGraph.forward();
		}
		
		System.out.println("##### FINISHED");
		
	}


	
	public void dijkstra(Graph<V,E> graph, Vertex<V> startVertex){
		HeapPriorityQueue<Double,Vertex<V>> hq = new HeapPriorityQueue<>();
		Iterator<Vertex<V>> it = graph.vertices();
		while (it.hasNext()){
			Vertex<V> v = it.next();
			v.set(Property.DISTANCE,Double.POSITIVE_INFINITY);
			Locator<Double,Vertex<V>> loc = hq.insert((Double)v.get(Property.DISTANCE),v);
			v.set(Property.PQLOCATOR, loc);
			startVertex.set(v,null);
		}
		hq.replaceKey((Locator<Double,Vertex<V>>)startVertex.get(Property.PQLOCATOR),0.0);
		startVertex.set(startVertex,startVertex);
		while ( ! hq.isEmpty()){
			Locator<Double,Vertex<V>> loc = hq.removeMin();
			Vertex<V> v = loc.element();
			// no modify the distance of all neighbours
			Iterator<Edge<E>> eit;
			if (graph.isDirected()) eit = graph.incidentOutEdges(v);  
			else eit  = graph.incidentEdges(v);
			while(eit.hasNext()){
				Edge<E> e  = eit.next();
				double weight =1.0; // if no weight is entered
				if (e.has(Property.WEIGHT)) weight = (Double)e.get(Property.WEIGHT);
				Vertex<V> u = graph.opposite(e, v);
				double newDist = (Double)u.get(Property.DISTANCE)+weight;
				if (newDist < (Double)u.get(Property.DISTANCE)){
					u.set(Property.DISTANCE,newDist);
					hq.replaceKey((Locator<Double,Vertex<V>>)u.get(Property.PQLOCATOR), newDist);
					// now set as best gateway (until now) v
					// i.e v is the gateway from u to s.
					if(v==startVertex){
						startVertex.set(u,u);
					}
					else{ 
						startVertex.set(u,startVertex.get(v));
					}				
				}
			}
			
		}
		
	}
	
}
