package graphlib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import javax.management.RuntimeErrorException;



public class GraphExamples<V,E> {

	final int kruskal(Graph<V,E> g){
		if (g.isDirected()) throw new RuntimeException("We need an undirected graph!");
		// Returns the number of connected components
		// Finds the minimum spanning forrest:
		// each edge belonging to the minimum spanning forrest gets 
		// an attribute MSF. The value of MSF is an integer 
		// indicating the number of the connected component 
		// it belongs to. The attribute 
		// MSF is also assigned to the vertices.
		int n = g.numberOfVertices();
		final Object CLUSTER = new Object();		
		ArrayList<Vertex<V>> [] clusters = new ArrayList[n];
		Iterator<Vertex<V>> it = g.vertices();
		int num = g.numberOfVertices();
		while(it.hasNext()){
			// all vertices are in their own cluster
			Vertex<V> v = it.next();
			clusters[num].add(v);
			v.set(CLUSTER,clusters[num++]);
			v.set(Property.MSF,null); // show to which component v belongs
		}	
		HeapPriorityQueue<Double,Edge<E>> pq = new HeapPriorityQueue<>();
		Iterator<Edge<E>> eit= g.edges();
		while(eit.hasNext()){
			double w = 1.0;
			Edge<E> e = eit.next();
			if (e.has(Property.WEIGHT)) w = (Double)e.get(Property.WEIGHT);
			pq.insert(w, e);
		}
		while ( ! pq.isEmpty()){
			// take the shortest edge from hq:
			Edge<E> e = pq.removeMin().element();
			// get the endPoints:
			Vertex<V> [] endV = g.endVertices(e);
			ArrayList<Vertex<V>> c0 = (ArrayList<Vertex<V>> )endV[0].get(CLUSTER);
			ArrayList<Vertex<V>> c1 = (ArrayList<Vertex<V>> )endV[1].get(CLUSTER);
			if (c0 != c1){
				if (c1.size()<c0.size()) {
					ArrayList<Vertex<V>> tmp = c0;
					c0=c1;
					c1=tmp;
				}
				e.set(Property.MSF,c0);
				num--;
				// now copy all elements from c1 to c0 and change the attribute
				for (Vertex<V> v:c1){
					c0.add(v);
					v.set(CLUSTER, c0);
				}
				c1.clear();
			}
		}		
		return num;
	}
	
	

	public void findGateways(Graph<V,E> g, boolean dijkstra){
		// if 'v' and 'w' are vertices of 'g' then 
		// 'v' has a attribute 'w'. The the value of 
		// this attribute is (say) 'u'. Then 'u' has 
		// the following meaning: if there is no path 
		// from 'v' to 'w',  'u' is null. Otherwise
		// 'u' is the first vertex (after 'v') on a shortest path
		// fromn 'v' to 'w'. 
		// (where the lenght of a path is 
		// the number of vertices on the path->hopping distance)
		// if dijkstra is set to true we take into acount
		// the weights of the edges (instead of the hopping distance)
		
		Iterator<Vertex<V>> it = g.vertices();
		while (it.hasNext()){
			Vertex<V> v = it.next();
			// clear the attribute v for all vertices
			Iterator<Vertex<V>> it2 = g.vertices();
			while (it2.hasNext()){
				Vertex<V> w = it2.next();
				if (v.has(w)) w.destroy(v);
				v.set(w,null);
			}
			// now find the shortest pathes to all u and
			// set the attribute v
			if ( dijkstra) dijkstra(g,v);
			else bfs(g,v);
		}
	}
	

	public void dijkstra(Graph<V,E> g, Vertex<V> s){
		HeapPriorityQueue<Double,Vertex<V>> hq = new HeapPriorityQueue<>();
		Iterator<Vertex<V>> it = g.vertices();
		while (it.hasNext()){
			Vertex<V> v = it.next();
			v.set(Property.DISTANCE,Double.POSITIVE_INFINITY);
			Locator<Double,Vertex<V>> loc = hq.insert((Double)v.get(Property.DISTANCE),v);
			v.set(Property.PQLOCATOR, loc);
			s.set(v,null);
		}
		hq.replaceKey((Locator<Double,Vertex<V>>)s.get(Property.PQLOCATOR),0.0);
		s.set(s,s);
		while ( ! hq.isEmpty()){
			Locator<Double,Vertex<V>> loc = hq.removeMin();
			Vertex<V> v = loc.element();
			// no modify the distance of all neighbours
			Iterator<Edge<E>> eit;
			if (g.isDirected()) eit = g.incidentOutEdges(v);  
			else eit  = g.incidentEdges(v);
			while(eit.hasNext()){
				Edge<E> e  = eit.next();
				double weight =1.0; // if no weight is entered
				if (e.has(Property.WEIGHT)) weight = (Double)e.get(Property.WEIGHT);
				Vertex<V> u = g.opposite(e, v);
				double newDist = (Double)u.get(Property.DISTANCE)+weight;
				if (newDist < (Double)u.get(Property.DISTANCE)){
					u.set(Property.DISTANCE,newDist);
					hq.replaceKey((Locator<Double,Vertex<V>>)u.get(Property.PQLOCATOR), newDist);
					// now set as best gateway (until now) v
					// i.e v is the gateway from u to s.
					if(v==s) s.set(u,u);
					else s.set(u,s.get(v));				
				}
			}
			
		}
		
	}
	
	
	public void setTopologicalNumbers(Graph<V,E> g){
		if ( ! g.isDirected()) throw new RuntimeException("Not directed!");
		LinkedList<Vertex<V>> li = new LinkedList<>();
		Iterator<Vertex<V>> it = g.vertices();
		while(it.hasNext()){
			Vertex<V> v=it.next();
			int cnt = g.inDegree(v);
			v.set(Property.INCOUNT,cnt);
			if (cnt == 0) li.add(v);

		}
		int num = 0;
		while ( ! li.isEmpty()){
			Vertex<V> v = li.remove();
			v.set(Property.NUMBER,num++);
			Iterator<Edge<E>> eit = g.incidentOutEdges(v);
			while(eit.hasNext()){
				Vertex<V> w = g.destination(eit.next());
				int newCnt = (Integer)w.get(Property.INCOUNT)-1;
				w.set(Property.INCOUNT, newCnt);
				if (newCnt==0) li.add(w);
			}
		}
		if (num != g.numberOfVertices()) throw new RuntimeException("not a DAG!");
	}
	

	public void bfs(Graph<V,E> g, Vertex<V> v){
		// add the attribute v to all vertices w
		// the value of this attribute is the first
		// vertex on a shortest path from w to v
		LinkedList<Vertex<V>> li = new LinkedList<Vertex<V>>();
		v.set(v,v);
		li.addFirst(v);
		while (li.size() > 0){
			Vertex<V> w = li.removeLast();
			Iterator<Edge<E>> eit;
			if (g.isDirected()) eit = g.incidentOutEdges(w);  
			else eit  = g.incidentEdges(w);
			while(eit.hasNext()){
				Edge<E> e = eit.next();
				Vertex<V> u = g.opposite(e, w);
				if (  v.get(u) == null) {// u not yet visited
					if(w==v)v.set(u,u);
					else v.set(u,v.get(w));
					li.addFirst(u);			
				}
			}
			
		}
	}
	
	public  LinkedList<Vertex<V>> findPath(
			Graph<V,E> g, Vertex<V> v, Vertex<V> w){
		LinkedList<Vertex<V>> li = new  LinkedList<>();
		if  ((Vertex<V>)v.get(w)==null) return li;
		Vertex<V> next = v; 
		while (next != null ){
			li.add(next);
			if (next==w) break;
			next=(Vertex<V>)next.get(w);
		}
		return li;	
	}
	

	public boolean isConnected(Graph<V,E> g){
		Vertex<V> v = g.aVertex();
		traverse(g,v);
		Iterator<Vertex<V>> it = g.vertices();
		int n=0;
		while (it.hasNext()){
			Vertex<V> w = it.next();
			if (w.has(Property.VISITED)){
				w.destroy(Property.VISITED);
				n++;
			}
		}
		return n==g.numberOfVertices();
	}
	
	/**
	 * @param g
	 * @param v
	 */
	private void traverse(Graph<V,E> g, Vertex<V> v) {
		v.set(Property.VISITED,null);
		// System.out.println(v);
		// now start the traversal at 
		// all neighbours which are 
		// not allready visited
		Iterator<Edge<E>> it = g.incidentEdges(v);
		while (it.hasNext()){
			Vertex<V> w = g.opposite(it.next(),v);
			if ( ! w.has(Property.VISITED)){
				traverse(g, w);
			}
		}
		
	}

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		IncidenceListGraph<String,String> g = 
			new IncidenceListGraph<String,String> (true);
		GraphExamples<String,String> ge = new GraphExamples<>(); 
		// add an example graph:
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

//		final int N = 1000;
//		Random rand = new Random(322873);
//		Vertex<String> [] vs = new Vertex[N];
//		for (int i = 0;i<N;i++){
//			vs[i] = g.insertVertex("v"+i);
//		}
//		for (int i=0;i<N;i++)
//			for (int k=i+1;k<N;k++)
//				if (rand.nextDouble()< 0.005) 
//						g.insertEdge(vs[i],vs[k], i+":"+k);
//		findGateways(g);
//		System.out.println("path "+findPath(g, vs[0], vs[N-1]));
//		System.out.println("connected? "+isConnected(g));
		System.out.println(g);
		ge.setTopologicalNumbers(g);
//		LinkedList<Vertex<String>> vList = new LinkedList<Vertex<String>>();
//		dfSearch(g, vA,vList);
//		System.out.println(vList);
//		Iterator<Edge<String>> eit = g.edges();
//		while(eit.hasNext()){
//			Edge<String> e = eit.next();
//			if (e.has(DISCOVERY_EDGE)) System.out.println(e);
//		}
	}
}

