package easygraph.controller;

import java.util.Iterator;

import easygraph.guielements.GuiVertex;
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
      Iterator<?> it = graph.vertices();
      
      while (it.hasNext()) {
      	Vertex<?> v = (Vertex<?>) it.next();
      	GuiVertex elem = new GuiVertex(v);
          drawView.getChildren().add(elem);
      }
	}

}
