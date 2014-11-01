package easygraph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import graphlib.Edge;
import graphlib.Graph;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class EasyGraph {

	private Graph<Vertex<?>, Edge<?>> graph = null;
	
	private final List<Step> forwardSteps = new ArrayList<Step>();
	private final int forwardStepIndex = 0;
	private final Stack<Step> backwardSteps = new Stack<Step>();
	
	/**
	 * Mark an edge as discovered.
	 * @param edge
	 */
	public void setDiscovered(Edge<?> edge){
		// TODO
	}
	
	/**
	 * Mark a vertex as discovered.
	 * @param vertex
	 */
	public void setDiscovered(Vertex<?> vertex){
		// TODO
	}
	
	/**
	 * Mark an edge as selected.
	 * @param edge
	 */
	public void setSelected(Edge<?> edge){
		// TODO
	}
	
	/**
	 * Mark a vertex as selected.
	 * @param vertex
	 */
	public void setSelected(Vertex<?> vertex){
		// TODO
	}
	
	/**
	 * Mark an edge as disabled.
	 * @param edge
	 */
	public void setDisabled(Edge<?> edge){
		// TODO
	}
	
	/**
	 * Mark a vertex as disabled.
	 * @param vertex
	 */
	public void setDisabled(Vertex<?> vertex){
		// TODO
	}
	
	/**
	 * Launch the easyGraph visualization software. A new graph instance will be provided.
	 */
	public void launchGui(){
		this.graph = new IncidenceListGraph<Vertex<?>, Edge<?>>(false);
		// TODO
	}
	
	/**
	 * Launch the easyGraph visualization software with a prepared graph instance.
	 * @param graph
	 */
	public void launchGui(Graph<Vertex<?>,Edge<?>> graph){
		this.graph = graph;
		// TODO
	}
	
	/**
	 * make a forward step
	 */
	void forward(){
		// TODO
	}
	
	/**
	 * make a backward step
	 */
	void backward(){
		// TODO
	}
	
	/*
	 * hide constructor, prevent instantiation
	 */
	private EasyGraph() {}
}
