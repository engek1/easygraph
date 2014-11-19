package easygraph.controller;

import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;
import javafx.fxml.FXML;

/**
 * 
 * @author engek1
 *
 */
public class EditorLayoutController {

	@FXML
	private ToolboxViewController toolboxViewController;
	@FXML
	private PropertiesViewController propertiesViewController;
	@FXML
	private DrawViewController drawViewController;
	
	public EditorLayoutController() {
		
	}

	public void initialize() {

	}

	/**
	 * draw Graph to DrawView
	 * @param graph
	 */
	public void showGraph(Graph<?, ?> graph) {
		drawViewController.showGraph(graph);
	}
	
	public void addVertex(Vertex<?> vertex) {
		drawViewController.addVertex(vertex);
	}

	public void addEdge(Edge<?> edge, Vertex<?> fromVertex, Vertex<?> toVertex) {
		drawViewController.addEdge(edge, fromVertex, toVertex);
	}

}
