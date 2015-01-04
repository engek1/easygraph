package easygraph.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import easygraph.application.Editor;
import easygraph.examplegraphs.Samples;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import easygraph.guielements.Texts;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Decorable;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.IncidenceListGraph;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class EditorLayoutController extends BaseController {
	
	private Samples samples = new Samples();
	
	@FXML
	private ToolboxViewController toolboxViewController;
	
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

	public void addEdge(Edge<?> edge, Vertex<?> fromVertex, Vertex<?> toVertex, boolean isDirected) {
		drawViewController.addEdge(edge, fromVertex, toVertex, isDirected);
	}
	
	public void distributeEditor(Editor editor) {
		this.setEditor(editor);
		this.toolboxViewController.setEditor(editor);
		this.drawViewController.setEditor(editor);
	}
	
	public DrawViewController getDrawViewController() {
		return this.drawViewController;
	}
	
	@FXML
	private void newGraph() {
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (false);
		this.getEditor().loadGraph(graph);
	}
	
	@FXML
	private void newGraphDirected(){
		IncidenceListGraph<String,String> graph = new IncidenceListGraph<String,String> (true);
		this.getEditor().loadGraph(graph);
	}
	
	@FXML
	private void save() {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save IncidenceListGraph Resource File");
			fileChooser.setInitialFileName("edited-graph.graph");
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Graph", "*.graph"));		
			
			File file = fileChooser.showSaveDialog(this.getEditor().getPrimaryStage());
			fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(this.prepareGraphForSave());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
				oos.close();
			} catch (IOException e) {}
		}
	}

	
	@FXML
	private void open() {
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		
		try {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open IncidenceListGraph Resource File");
			fileChooser.getExtensionFilters().add(new ExtensionFilter("Graph", "*.graph"));
			
			File file = fileChooser.showOpenDialog(this.getEditor().getPrimaryStage());
			
			fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			
			this.getEditor().loadGraph((IncidenceListGraph<?, ?>) ois.readObject());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
				ois.close();
			} catch (Exception e) {}
		}
	}
	

	@FXML
	private void quit() {
		try {
			Platform.exit();
			this.getEditor().stop();
		} catch (Exception e) {
			System.out.println(Texts.ERROR_STOP_APPLICATION);
			e.printStackTrace();
		}
	}
	
	@FXML
	private void exampleOne() {
		this.getEditor().loadGraph(this.samples.getExampleOne());
	}
	
	@FXML
	private void exampleTwo() {
		this.getEditor().loadGraph(this.samples.getExampleTwo());
	}
	
	@FXML
	private void exampleThree() {
		this.getEditor().loadGraph(this.samples.getExampleThree());
	}
	
	@FXML
	private void exampleFour() {
		this.getEditor().loadGraph(this.samples.getExampleFour());
	}
	
	@FXML
	private void aboutUs() {
		System.out.println("-- ABOUT clicked.");
	}
	
	@FXML
	private void arrangeInCircle() {
		double width = drawViewController.getWidth() - 2 * Config.VERTEX_RADIUS;
		double height = drawViewController.getHeight() - 2 * Config.VERTEX_RADIUS;
		this.getEditor().adjustVerticesToCircle(width, height);
		this.showGraph(this.getEditor().getGraph());
	}

	public void removeEdge(GuiEdge guiEdge) {
		drawViewController.removeEdge(guiEdge);
	}


	public void removeVertex(GuiVertex guiVertex) {
		drawViewController.removeVertex(guiVertex);
	}
	
	
	private Graph<?, ?> prepareGraphForSave() {
		Graph<?, ?> graph = this.getEditor().getGraph();
		
		Iterator<?> itV = graph.vertices();
		while (itV.hasNext()) {
			Decorable elem = (Decorable) itV.next();
			if (elem.has(EGProperty.EG_GUI_REFERENCE)) {
				elem.destroy(EGProperty.EG_GUI_REFERENCE);
			}
		}
		
		Iterator<?> itE = graph.edges();
		while (itE.hasNext()) {
			Decorable elem = (Decorable) itE.next();
			if (elem.has(EGProperty.EG_GUI_REFERENCE)) {
				elem.destroy(EGProperty.EG_GUI_REFERENCE);
			}
		}
		return graph;
	}

}
