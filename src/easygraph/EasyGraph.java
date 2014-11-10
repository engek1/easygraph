package easygraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import easygraph.application.Editor;
import easygraph.model.EGProperty;
import easygraph.model.EStep;
import easygraph.model.Step;
import easygraph.model.VStep;
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
	
	private static int FORWARD_STEP_INDEX = 0;
	private static final List<Step> FORWARD_STEPS = new ArrayList<Step>();
	private static final Stack<Step> BACKWARD_STEPS = new Stack<Step>();
	private static final Editor GUI = new Editor();

	/* default values */
	private static final Object DEFAULT_COLOR_DISCOVERED = "BLUE";
	private static final Object DEFAULT_COLOR_SELECTED = "RED";
	private static final Object DEFAULT_COLOR_DISABLED = "GREY";

	/**
	 * Mark an edge as discovered.
	 * @param edge
	 */
	public static void setDiscovered(Edge<?> edge){
		FORWARD_STEPS.add(new EStep(edge, EGProperty.EG_COLOR, DEFAULT_COLOR_DISCOVERED));
		// add others...
	}
	
	/**
	 * Mark a vertex as discovered.
	 * @param vertex
	 */
	public static void setDiscovered(Vertex<?> vertex){
		FORWARD_STEPS.add(new VStep(vertex, EGProperty.EG_COLOR, DEFAULT_COLOR_DISCOVERED));
		// add others...
	}
	
	/**
	 * Mark an edge as selected.
	 * @param edge
	 */
	public static void setSelected(Edge<?> edge){
		FORWARD_STEPS.add(new EStep(edge, EGProperty.EG_COLOR, DEFAULT_COLOR_SELECTED));
	}
	
	/**
	 * Mark a vertex as selected.
	 * @param vertex
	 */
	public static void setSelected(Vertex<?> vertex){
		FORWARD_STEPS.add(new VStep(vertex, EGProperty.EG_COLOR, DEFAULT_COLOR_SELECTED));
	}
	
	/**
	 * Mark an edge as disabled.
	 * @param edge
	 */
	public static void setDisabled(Edge<?> edge) {
		FORWARD_STEPS.add(new EStep(edge, EGProperty.EG_COLOR, DEFAULT_COLOR_DISABLED));
	}
	
	/**
	 * Mark a vertex as disabled.
	 * @param vertex
	 */
	public static void setDisabled(Vertex<?> vertex) {
		FORWARD_STEPS.add(new VStep(vertex, EGProperty.EG_COLOR, DEFAULT_COLOR_DISABLED));
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
	public static void launchGui(Graph<?, ?> graph) {
		EasyGraph.graph = graph;
		GUI.launchGui(EasyGraph.graph);
	}
	
	/**
	 * Make a forward-step. Take the next forward-step. Save the backward-step.
	 * Save the property-changes to the model and make them on the UI.
	 * Increase the step-index.
	 */
	public static void forward(){
		// get next step
		Step step = FORWARD_STEPS.get(FORWARD_STEP_INDEX);
		// add backward step to history
		BACKWARD_STEPS.push(step.getBackwardStep());
		
		// make changes on model
		step.execute();
		// TODO make changes on UI as well 
		
		// finally increase the index
		FORWARD_STEP_INDEX++;
	}
	
	/**
	 * Make a backward-step. Take the last backward-step and execute the property changes on model and UI.
	 * Decrease the step-index.
	 */
	public static void backward(){
		Step step = BACKWARD_STEPS.pop();
		step.execute();
		// TODO make changes on UI as well 
		
		FORWARD_STEP_INDEX--;
	}
	
	/*
	 * hide constructor, prevent instantiation.
	 */
	private EasyGraph() {
		// empty
	}
}
