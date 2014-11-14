package easygraph.controller;

import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;

import java.util.Iterator;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * 
 * @author engek1
 *
 */
public class DrawViewController extends BaseViewController implements VertexClickHandler {

	@FXML
	private Pane drawPane;
	
	private EventHandler<MouseEvent> drawViewClickedHandler;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public DrawViewController() {
		// init click handler
		drawViewClickedHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// forward only right clicks to rootController
				if(event.getButton()==MouseButton.PRIMARY){
					getRootController().handleDrawViewLeftClick(event);
					event.consume();
				}
			}
		};
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		
		drawPane.setOnMouseClicked(drawViewClickedHandler);
		// TODO set default width and heigth to draw pane
//		drawPane.setPrefSize(SIZE_X, SIZE_Y);
		System.out.println(drawPane);

	}

	
	void showGraph(Graph<?, ?> graph) {

		Iterator<?> vIt = graph.vertices();

		while (vIt.hasNext()) {
			Vertex<?> v = (Vertex<?>) vIt.next();
			GuiVertex elem = new GuiVertex(v, this);
			drawPane.getChildren().add(elem);
		}

		Iterator<?> eIt = graph.edges();
		while (eIt.hasNext()) {
			Edge e = (Edge) eIt.next();
			Vertex<?>[] endVertices = graph.endVertices(e);
			GuiEdge elem = new GuiEdge(e, endVertices[0], endVertices[1]);
			drawPane.getChildren().add(elem);
		}
	}

	void addVertex(Vertex newVertex) {
		GuiVertex newGVertex = new GuiVertex(newVertex, this);
		Platform.runLater(() -> drawPane.getChildren().add(newGVertex));
	}

	@Override
	public void handleClick(Vertex vertex) {
		getRootController().handleVertexClick(vertex);
	}

	void addEdge(Edge newEdge, Vertex<?> fromVertex, Vertex<?> toVertex) {
		GuiEdge guiEdge = new GuiEdge(newEdge, fromVertex, toVertex);
		Platform.runLater(() -> drawPane.getChildren().add(guiEdge));
	}

}