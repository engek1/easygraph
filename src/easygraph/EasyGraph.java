package easygraph;

import easygraph.application.Editor;
import easygraph.model.EGProperty;
import easygraph.model.Step;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;
import javafx.scene.paint.Color;

/**
 * 
 * @author engek1
 *
 */
public class EasyGraph {

	private static Graph<?, ?> graph = null;
	
	private static final Editor GUI = new Editor();

	/* default values */
	private static final Color DEFAULT_COLOR_DISCOVERED = Color.BLACK;
	private static final Color DEFAULT_COLOR_SELECTED = Color.ORANGE;
	private static final Color DEFAULT_COLOR_DISABLED = Color.GRAY;


	public static void setDiscovered(Edge<?> edge) {
		setDiscovered(edge, DEFAULT_COLOR_DISCOVERED);
	}
	
	public static void setDiscovered(Edge<?> edge, Color color) {
		GUI.getForwardSteps().add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}

	
	public static void setDiscovered(Vertex<?> vertex) {
		setDiscovered(vertex, DEFAULT_COLOR_DISCOVERED);
	}
	
	public static void setDiscovered(Vertex<?> vertex, Color color) {
		GUI.getForwardSteps().add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setSelected(Edge<?> edge) {
		setSelected(edge, DEFAULT_COLOR_SELECTED);
	}

	public static void setSelected(Edge<?> edge, Color color) {
		GUI.getForwardSteps().add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}
	

	public static void setSelected(Vertex<?> vertex) {
		setSelected(vertex, DEFAULT_COLOR_SELECTED);
	}
	
	public static void setSelected(Vertex<?> vertex, Color color) {
		GUI.getForwardSteps().add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setDisabled(Edge<?> edge) {
		setDisabled(edge, DEFAULT_COLOR_DISABLED);
	}

	public static void setDisabled(Edge<?> edge, Color color) {
		GUI.getForwardSteps().add(new Step<Edge<?>>(edge, EGProperty.EG_COLOR, color));
	}
	
	
	public static void setDisabled(Vertex<?> vertex) {
		setDisabled(vertex, DEFAULT_COLOR_DISABLED);
	}

	public static void setDisabled(Vertex<?> vertex, Color color) {
		GUI.getForwardSteps().add(new Step<Vertex<?>>(vertex, EGProperty.EG_COLOR, color));
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
	
	
	/*
	 * hide constructor, prevent instantiation.
	 */
	private EasyGraph() {
		// empty
	}
}
