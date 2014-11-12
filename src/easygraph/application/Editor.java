package easygraph.application;

import easygraph.controller.EditorLayoutController;
import graphlib.Edge;
import graphlib.Graph;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author engek1,...
 *
 */
public class Editor extends Application {
	
	private static final String TITLE = "EasyGraph Editor GUI";
	
	private static final String EDITOR_LAYOUT = "../view/EditorLayout.fxml";
	
	private static Graph<?, ?> graph;
	
	private Stage stage;
    private Scene editorScene;
    private Scene debugScene;
    private EditorLayoutController editorController;

    /**
     * Set the graph reference and launch the GUI.
     * @param graph
     */
    public void launchGui(Graph<?, ?> graph) {
    	this.graph = graph;
    	launch();
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        this.stage.setTitle(Editor.TITLE);
        
        // for the beginning, just work with the editor scene.
        initEditorLayout();
        
        stage.setScene(editorScene);
        stage.show();
    }

    private void initEditorLayout() {
    	FXMLLoader editorLoader = new FXMLLoader(Editor.class.getResource(Editor.EDITOR_LAYOUT));
    	try {
    		BorderPane borderPane = (BorderPane) editorLoader.load();
            editorScene = new Scene(borderPane);   
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
        editorController = editorLoader.getController();
        editorController.showGraph(this.graph);
    }
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return stage;
    }

}
