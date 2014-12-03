package easygraph.controller;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;
import javafx.fxml.FXML;

/**
 * 
 * @author engek1
 *
 */
public class EditorLayoutController extends BaseController {
		
	@FXML
	private ToolboxViewController toolboxViewController;
	@FXML
	private PropertiesViewController propertiesViewController;
	@FXML
	private DrawViewController drawViewController;
	

	public void initialize() {
	}


	public void showGraph(Graph<?, ?> graph) {
		drawViewController.showGraph(graph);
	}
	
	public void addVertex(Vertex<?> vertex) {
		drawViewController.addVertex(vertex);
	}

	public void addEdge(Edge<?> edge, Vertex<?> fromVertex, Vertex<?> toVertex) {
		drawViewController.addEdge(edge, fromVertex, toVertex);
	}
	
	public void distributeEditor(Editor editor) {
		this.setEditor(editor);
		this.toolboxViewController.setEditor(editor);
		this.propertiesViewController.setEditor(editor);
		this.drawViewController.setEditor(editor);
	}

}
