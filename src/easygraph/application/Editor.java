package easygraph.application;

import easygraph.controller.EditorLayoutController;
import easygraph.controller.mode.Mode;
import easygraph.controller.mode.SelectMode;
import easygraph.eventhandlers.ChangeModeEventHandler;
import easygraph.eventhandlers.DrawViewClickEventHandler;
import easygraph.eventhandlers.DrawViewMouseReleasedEventHandler;
import easygraph.eventhandlers.EdgeEventHandler;
import easygraph.eventhandlers.VertexClickedEventHandler;
import easygraph.eventhandlers.VertexPressedEventHandler;
import easygraph.events.ChangeModeEvent;
import easygraph.events.DrawViewClickEvent;
import easygraph.events.DrawViewMouseReleasedEvent;
import easygraph.events.EdgeEvent;
import easygraph.events.VertexClickedEvent;
import easygraph.events.VertexPressedEvent;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author engek1, webel3, wenger
 *
 */
public class Editor extends Application implements GraphController {

	private static final String TITLE = "EasyGraph Editor GUI";
	private static final String EDITOR_LAYOUT = "../view/EditorLayout.fxml";

	private static Graph<?, ?> graph;

	private static Integer VertexNumber = 0;

	// current editor mode
	private Mode mode;

	private Stage stage;
	private Scene editorScene;
	private EditorLayoutController editorController;

	public static final double SIZE_X = 600;
	public static final double SIZE_Y = 400;

	public Editor() {
		this.mode = new SelectMode(this);
	}

	/**
	 * Set the graph reference and launch the GUI.
	 * 
	 * @param graph
	 */
	public void launchGui(Graph<?, ?> graph) {
		Editor.graph = graph;
		if (!checkCoordinatesSanity()) {
			adjustVerticesToCircle();
		}
		launch();
	}
	

	/**
	 * Check if each vertex has X/Y coordinates so that it can be painted on the
	 * GUI.
	 * 
	 * @return true if each vertex has X/Y coordinates, else false
	 */
	private boolean checkCoordinatesSanity() {
		Iterator<?> it = Editor.graph.vertices();
		while (it.hasNext()) {
			Vertex<?> v = (Vertex<?>) it.next();
			if (!v.has(EGProperty.EG_COORDINATE_X)
					|| !v.has(EGProperty.EG_COORDINATE_Y)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Put all vertices in place of a circle by using some Math.<br>
	 * <br>
	 * 
	 * Given a radius length r and an angle t in radians and a circle's center
	 * (middleX, middleY), you can calculate the coordinates of a point on the
	 * circumference as follows:<br>
	 * <br>
	 * float posX = r * cos(t) + middleX;<br>
	 * float posY = r * sin(t) + middleY;
	 * 
	 * @param x
	 *            size in x-dimension of the available space
	 * @param y
	 *            size of y-dimension of the available space
	 */
	public void adjustVerticesToCircle(double x, double y) {
		// calculate the maximum possible gui square
		// minus 2 * the predefined padding for optical reasons
		double maxSize = x > y ? y : x;
		maxSize -= (2 * Config.getPadding());

		// calculate the angle of each vertex
		double offset = 360.0 / Editor.graph.numberOfVertices();
		double radius = maxSize / 2;
		double middleX = x / 2;
		double middleY = y / 2;
		int factor = 0;

		Iterator<?> it = Editor.graph.vertices();
		while (it.hasNext()) {
			double angle = factor++ * offset;
			double posX = radius * Math.cos(Math.toRadians(angle)) + middleX;
			double posY = radius * Math.sin(Math.toRadians(angle)) + middleY;
			Vertex<?> v = (Vertex<?>) it.next();
			v.set(EGProperty.EG_COORDINATE_X, posX);
			v.set(EGProperty.EG_COORDINATE_Y, posY);
		}
	}

	/**
	 * Call the vertices adjustment method with pre-defined size parameters.
	 */
	public void adjustVerticesToCircle() {
		this.adjustVerticesToCircle(SIZE_X, SIZE_Y);
	}

	@Override
	public void start(Stage primaryStage) {
		this.stage = primaryStage;
		this.stage.setTitle(Editor.TITLE);

		// Set the application icon.
		this.stage.getIcons().add(new Image("file:resources/images/logo.png"));

		initEditorLayout();

		stage.setScene(editorScene);
		stage.show();
	}

	private void initEditorLayout() {
		FXMLLoader editorLoader = new FXMLLoader(
				Editor.class.getResource(Editor.EDITOR_LAYOUT));
		try {
			BorderPane borderPane = (BorderPane) editorLoader.load();
			editorScene = new Scene(borderPane);

			editorScene.addEventHandler(EdgeEvent.EDGE_CLICKED,
					new EdgeEventHandler(this));
			editorScene.addEventHandler(VertexClickedEvent.VERTEX_CLICKED,
					new VertexClickedEventHandler(this));
			editorScene.addEventHandler(ChangeModeEvent.CHANGE_MODE,
					new ChangeModeEventHandler(this));
			editorScene.addEventHandler(DrawViewClickEvent.DRAW_VIEW_CLICKED,
					new DrawViewClickEventHandler(this));
            editorScene.addEventHandler(VertexPressedEvent.VERTEX_PRESSED, new VertexPressedEventHandler(this));
            editorScene.addEventHandler(DrawViewMouseReleasedEvent.DRAW_VIEW_MOUSE_RELEASED, new DrawViewMouseReleasedEventHandler(this));
            
		} catch (IOException e) {
			e.printStackTrace();
		}

		editorController = editorLoader.getController();
		editorController.showGraph(Editor.graph);
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return stage;
	}

	@Override
	public void addVertex(double x, double y) {
		Vertex<?> newVertex = Editor.graph.insertVertex(null);
		newVertex.set(EGProperty.EG_COORDINATE_X, x);
		newVertex.set(EGProperty.EG_COORDINATE_Y, y);
		newVertex.set(EGProperty.EG_NAME, Editor.getIdentifier());
		editorController.addVertex(newVertex);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void addEdge(Vertex fromVertex, Vertex toVertex) {

		// TODO catch exception when try to insert parallel edge.
		Edge<?> newEdge = Editor.graph.insertEdge(fromVertex, toVertex, null);
		newEdge.set(EGProperty.EG_NAME, "none");

		editorController.addEdge(newEdge, fromVertex, toVertex);
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Mode getMode() {
		return this.mode;
	}

	public static String getIdentifier() {
		return "v-" + ++Editor.VertexNumber;
	}

}
