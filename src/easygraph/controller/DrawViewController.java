package easygraph.controller;

import java.util.Iterator;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import easygraph.events.PaneLeftClickEvent;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class DrawViewController extends BaseController {

	@FXML
	private Pane drawPane;
	
	
	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public DrawViewController() {
	}

	
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
		// add a MouseClicked EventHandler to the draw pane.
		this.drawPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					Event.fireEvent(drawPane, new PaneLeftClickEvent(event));
					event.consume();
				}
			}
		});
		
		// add a MouseReleased EventHandler to the draw pane.
		this.drawPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Event.fireEvent(drawPane, new PaneMouseReleasedEvent(event));
			}
		});
		
		// TODO set default width and heigth to draw pane		
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	void showGraph(Graph<?, ?> graph) {
		
		// first, remove all previous gui children
		drawPane.getChildren().clear();
		
		// add vertices to the gui
		Iterator<?> vIt = graph.vertices();
		while (vIt.hasNext()) {
			Vertex<?> vertex = (Vertex<?>) vIt.next();
			addVertex(vertex);
		}
		
		// add edges to the gui
		Iterator<?> eIt = graph.edges();
		while (eIt.hasNext()) {
			Edge e = (Edge) eIt.next();
			Vertex<?>[] endVertices = graph.endVertices(e);
			addEdge(e,endVertices[0], endVertices[1], graph.isDirected());
		}
	}

	
	void addVertex(Vertex<?> newVertex) {
		GuiVertex newGVertex = new GuiVertex(newVertex);
		Platform.runLater(() -> drawPane.getChildren().add(newGVertex));
	}

	
	void addEdge(Edge<?> newEdge, Vertex<?> fromVertex, Vertex<?> toVertex, boolean isDirected) {
		GuiEdge guiEdge = new GuiEdge(newEdge, fromVertex, toVertex, isDirected);
		Platform.runLater(new Runnable() {
			public void run() {
				drawPane.getChildren().add(guiEdge.getArrow());
				drawPane.getChildren().add(guiEdge.getText());
				drawPane.getChildren().add(guiEdge);
				guiEdge.toBack();
			}
		});
	}

	public void removeEdge(GuiEdge guiEdge) {
		drawPane.getChildren().remove(guiEdge.getArrow());
		drawPane.getChildren().remove(guiEdge.getText());
		drawPane.getChildren().remove(guiEdge);
	}

	public void removeVertex(GuiVertex guiVertex) {
		drawPane.getChildren().remove(guiVertex);
	}
	
	public double getWidth() {
		return drawPane.getWidth();
	}
	
	public double getHeight() {
		return drawPane.getHeight();
	}
	
}