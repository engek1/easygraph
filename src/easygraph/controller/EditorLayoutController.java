package easygraph.controller;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;

import java.awt.Dialog;

import javafx.application.Platform;
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
	
	
	@FXML
	private void save() {
		System.out.println("-- SAVE clicked.");
	}
	
	@FXML
	private void open() {
		System.out.println("-- OPEN clicked.");
	}
	
	@FXML
	private void quit() {
		Platform.exit();
	}
	
	@FXML
	private void exampleOne() {
		System.out.println("-- EXAMPLE-1 clicked.");
	}
	
	@FXML
	private void exampleTwo() {
		System.out.println("-- EXAMPLE-2 clicked.");
	}
	
	@FXML
	private void exampleThree() {
		System.out.println("-- EXAMPLE-3 clicked.");
	}
	
	@FXML
	private void exampleFour() {
		System.out.println("-- EXAMPLE-4 clicked.");
	}
	
	@FXML
	private void aboutUs() {
		System.out.println("-- ABOUT clicked.");
	}

}
