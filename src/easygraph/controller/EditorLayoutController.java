package easygraph.controller;

import java.util.Iterator;

import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EditorLayoutController{

	@FXML
	private ToolboxViewController toolboxViewController;
	@FXML
	private PropertiesViewController propertiesViewController;
	@FXML
	private DrawViewController drawViewController;

	@FXML
	private AnchorPane drawView;

	private EventHandler<MouseEvent> addVertexEventHandler;

	private enum Mode {
		EDIT, RUN
	}
	
	public EditorLayoutController() {
		// init Handlers
		addVertexEventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Pane coordinates: X = " + event.getX()
						+ ", Y = " + event.getY());
			}
		};

	}

	public void initialize() {
		System.out.println(drawViewController);
		System.out.println(drawView);
		System.out.println(toolboxViewController);
		System.out.println(propertiesViewController);
		
		drawView.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Pane coordinates: X = " + event.getX()
						+ ", Y = " + event.getY());
			}
		});
		

		
	}

	/**
	 * draw Graph to DrawView
	 * @param graph
	 */
	public void showGraph(Graph<?, ?> graph) {
      Iterator<?> vIt = graph.vertices();
      
      while (vIt.hasNext()) {
      	Vertex<?> v = (Vertex<?>) vIt.next();
      	GuiVertex elem = new GuiVertex(v);
        drawView.getChildren().add(elem);
      }
      
      Iterator<?> eIt = graph.edges();
      while (eIt.hasNext()) {
    	  Edge e = (Edge) eIt.next();
    	  Vertex<?> [] endVertices = graph.endVertices(e);
    	  GuiEdge elem = new GuiEdge(e, endVertices[0], endVertices[1]);
    	  drawView.getChildren().add(elem);
      }
	}

}
