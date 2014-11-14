package easygraph.controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import easygraph.controller.mode.AddEdgeMode;
import easygraph.controller.mode.AddVertexMode;
import easygraph.controller.mode.Mode;
import easygraph.controller.mode.SelectMode;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class EditorLayoutController implements RootController {

	@FXML
	private ToolboxViewController toolboxViewController;
	@FXML
	private PropertiesViewController propertiesViewController;
	@FXML
	private DrawViewController drawViewController;
	
//	@FXML
//	private AnchorPane drawPane;
	
	// current editor mode
	private Mode mode;
	
	private Graph<?, ?> graph;
	
	public EditorLayoutController() {
		this.mode = new SelectMode(this);
	}

	public void initialize() {
		drawViewController.setRootController(this);
		toolboxViewController.setRootController(this);
		propertiesViewController.setRootController(this);
	}

	/**
	 * draw Graph to DrawView
	 * @param graph
	 */
	public void showGraph(Graph<?, ?> graph) {
		this.graph = graph;
		drawViewController.showGraph(graph);
	}

	@Override
	public void addVertex(double x, double y) {
		Vertex<?> newVertex = this.graph.insertVertex(null);
		newVertex.set(EGProperty.EG_COORDINATE_X, x);
		newVertex.set(EGProperty.EG_COORDINATE_Y, y);
		drawViewController.addVertex(newVertex);
	}

	@Override
	public void handleDrawViewLeftClick(MouseEvent event) {
		System.out.println("Pane coordinates: X = " + event.getX()
		+ ", Y = " + event.getY());
		
		this.mode.drawViewLeftClick(event.getX(), event.getY());
	}

	@Override
	public void handleAddVertexMode() {
		this.mode = new AddVertexMode(this);
	}

	@Override
	public void handleSelectMode() {
		this.mode = new SelectMode(this);
	}

	@Override
	public void handleAddEdgeUnweigUndirMode() {
		this.mode = new AddEdgeMode(this);
	}

	@Override
	public void handleAddEdgeWeigUndirMode() {
		// TODO Auto-generated method stub
		this.mode = new AddEdgeMode(this);
	}

	@Override
	public void handleAddEdgeUnweigDirMode() {
		// TODO Auto-generated method stub
		this.mode = new AddEdgeMode(this);
	}

	@Override
	public void handleAddEdgeWeigDirMode() {
		// TODO Auto-generated method stub
		this.mode = new AddEdgeMode(this);
	}

	@Override
	public void handleVertexClick(Vertex vertex) {
		this.mode.vertexClicked(vertex);
	}

	@Override
	public void addEdge(Vertex fromVertex, Vertex toVertex) {

		// TODO catch exception when try to insert parallel edge.
		Edge newEdge = this.graph.insertEdge(fromVertex, toVertex, null);
		
		drawViewController.addEdge(newEdge, fromVertex, toVertex);
		
	}

}
