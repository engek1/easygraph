package easygraph;

import easygraph.application.Editor;
import easygraph.model.EGProperty;
import easygraph.model.Step;
import graphlib.Decorable;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javafx.scene.paint.Color;

/**
 * 
 * @author engek1
 *
 */
public class EasyGraph {

	private static Graph<?, ?> graph = null;
	
	private static int FORWARD_STEP_INDEX = 0;
	private static final List<Step<? extends Decorable>> FORWARD_STEPS = new ArrayList<Step<? extends Decorable>>();
	private static final Stack<Step<? extends Decorable>> BACKWARD_STEPS = new Stack<Step<? extends Decorable>>();
	private static final Editor GUI = new Editor();

	/* default values */
	private static final Color DEFAULT_COLOR_DISCOVERED = Color.BLUE;
	private static final Color DEFAULT_COLOR_SELECTED = Color.RED;
	private static final Color DEFAULT_COLOR_DISABLED = Color.GRAY;


	public static void setDiscovered(Edge<?> edge) {
		setDiscovered(edge, DEFAULT_COLOR_DISCOVERED);
	}
	
	public static void setDiscovered(Edge<?> edge, Color color) {
		FORWARD_STEPS.add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}

	
	public static void setDiscovered(Vertex<?> vertex) {
		setDiscovered(vertex, DEFAULT_COLOR_DISCOVERED);
	}
	
	public static void setDiscovered(Vertex<?> vertex, Color color) {
		FORWARD_STEPS.add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setSelected(Edge<?> edge) {
		setSelected(edge, DEFAULT_COLOR_SELECTED);
	}

	public static void setSelected(Edge<?> edge, Color color) {
		FORWARD_STEPS.add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}
	

	public static void setSelected(Vertex<?> vertex) {
		setSelected(vertex, DEFAULT_COLOR_SELECTED);
	}
	
	public static void setSelected(Vertex<?> vertex, Color color) {
		FORWARD_STEPS.add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setDisabled(Edge<?> edge) {
		setDisabled(edge, DEFAULT_COLOR_DISABLED);
	}

	public static void setDisabled(Edge<?> edge, Color color) {
		FORWARD_STEPS.add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setDisabled(Vertex<?> vertex) {
		setDisabled(vertex, DEFAULT_COLOR_DISABLED);
	}

	public static void setDisabled(Vertex<?> vertex, Color color) {
		FORWARD_STEPS.add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
	}
	
	
	/**
	 * Launch the easyGraph visualization software. A new graph instance will be provided.
	 */
	public static void launchGui() {
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
	public static void forward() {
		// get next step
		Step<? extends Decorable> step = FORWARD_STEPS.get(FORWARD_STEP_INDEX);
		
		// add backward step to history
		BACKWARD_STEPS.push(step.origin());
		
		// make changes on model
		step.apply();
		
		// TODO make changes on UI as well
		
		// finally increase the index
		FORWARD_STEP_INDEX++;
	}
	
	/**
	 * Make a backward-step. Take the last backward-step and execute the property changes on model and UI.
	 * Decrease the step-index.
	 */
	public static void backward() {
		Step<? extends Decorable> step = BACKWARD_STEPS.pop();
		step.apply();
		
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
