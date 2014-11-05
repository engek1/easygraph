package easygraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import easygraph.application.Editor;
import easygraph.model.Step;
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

	private static Graph<?, ?> graph = null;
	
	private static final int FORWARD_STEP_INDEX = 0;
	private static final List<Step> FORWARD_STEPS = new ArrayList<Step>();
	private static final Stack<Step> BACKWARD_STEPS = new Stack<Step>();
	private static final Editor GUI = new Editor();

	/**
	 * Mark an edge as discovered.
	 * @param edge
	 */
	public static void setDiscovered(Edge<?> edge){
		// TODO
	}
	
	/**
	 * Mark a vertex as discovered.
	 * @param vertex
	 */
	public static void setDiscovered(Vertex<?> vertex){
		// TODO
	}
	
	/**
	 * Mark an edge as selected.
	 * @param edge
	 */
	public static void setSelected(Edge<?> edge){
		// TODO
	}
	
	/**
	 * Mark a vertex as selected.
	 * @param vertex
	 */
	public static void setSelected(Vertex<?> vertex){
		// TODO
	}
	
	/**
	 * Mark an edge as disabled.
	 * @param edge
	 */
	public static void setDisabled(Edge<?> edge) {
		// TODO
	}
	
	/**
	 * Mark a vertex as disabled.
	 * @param vertex
	 */
	public static void setDisabled(Vertex<?> vertex) {
		// TODO
	}
	
	/**
	 * Launch the easyGraph visualization software. A new graph instance will be provided.
	 */
	public static void launchGui(){
		EasyGraph.launchGui(new IncidenceListGraph<Vertex<?>, Edge<?>>(false));
	}
	
	/**
	 * Launch the easyGraph visualization software with a prepared graph instance.
	 * @param graph
	 */
	public static void launchGui(Graph<?, ?> graph){
		EasyGraph.graph = graph;
		GUI.launchGui();
	}
	
	/**
	 * make a forward step
	 */
	public static void forward(){
		// TODO
	}
	
	/**
	 * make a backward step
	 */
	public static void backward(){
		// TODO
	}
	
	private EasyGraph() {
		// hide constructor, prevent instantiation.
	}
}
