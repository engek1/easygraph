package easygraph.controller;

import easygraph.application.Editor;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Graph;
import graphlib.Vertex;
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
		this.drawViewController.setEditor(editor);
	}
	
	
	@FXML
	private void save() {
		System.out.println("-- SAVE clicked.");
		
		/*
		System.out.println("number of vertices in graph before 'save': " + this.getEditor().getGraph().numberOfVertices());
		
		try {			
			File file = new File("C:\\Development\\graph.gr");			
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(this.getEditor().getGraph());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

	}
	
	
	@FXML
	private void open() {
		System.out.println("-- OPEN clicked.");
		
		/*
		try {
			FileInputStream fin = new FileInputStream("C:\\Development\\graph.gr");
			ObjectInputStream ois = new ObjectInputStream(fin);
			IncidenceListGraph<?, ?> graph = (IncidenceListGraph<?, ?>) ois.readObject();
			
			System.out.println("number of vertices in graph after 'open': " + graph.numberOfVertices());
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}
	
	@FXML
	private void quit() {
		// TODO : how to exit and finish a FX application?
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

	public void removeEdge(GuiEdge guiEdge) {
		drawViewController.removeEdge(guiEdge);
	}


	public void removeVertex(GuiVertex guiVertex) {
		drawViewController.removeVertex(guiVertex);
		
	}

}
