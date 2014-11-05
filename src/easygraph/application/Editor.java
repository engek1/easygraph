package easygraph.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 
 * @author engek1,...
 *
 */
public class Editor extends Application {
	
	private static final String TITLE = "EasyGraph Editor GUI";
	
	private static final String EDITOR_LAYOUT = "EditorLayout.fxml";
	private static final String DEBUG_LAYOUT = "DebugLayout.fxml";
	private static final String TOOLBOX_VIEW = "../view/ToolboxView.fxml";
	private static final String DRAW_VIEW = "../view/DrawView.fxml";
	private static final String PROPERTIES_VIEW = "../view/PropertiesView.fxml";
	
	private Stage stage;    
    private Scene editorScene;
    private Scene debugScene;
    
	
	private enum Mode {
		EDIT, RUN
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
    
    public void launchGui() {
    	super.launch();
    }
    
    
    private void initEditorLayout() {
    	FXMLLoader editorLoader = new FXMLLoader(Editor.class.getResource(Editor.EDITOR_LAYOUT));
    	try {
    		BorderPane borderPane = (BorderPane) editorLoader.load();
			
    		// add toolbox to the left of the pane
    		FXMLLoader leftLoader = new FXMLLoader(Editor.class.getResource(Editor.TOOLBOX_VIEW));
    		AnchorPane toolboxView = (AnchorPane) leftLoader.load();
    		borderPane.setLeft(toolboxView);
    		
    		// add draw view to the center of the pane
    		
    		// DrawViewController dvc = new DrawViewController(params?);
    		// let the controller handle drawing the given graph, etc ...
    		// dvPane = dvc.getPane();
    		
    		FXMLLoader centerLoader = new FXMLLoader(Editor.class.getResource(Editor.DRAW_VIEW));
            AnchorPane drawView = (AnchorPane) centerLoader.load();
            borderPane.setCenter(drawView);
            
            // add properties view to the right of the pane
            FXMLLoader rightLoader = new FXMLLoader(Editor.class.getResource(Editor.PROPERTIES_VIEW));
            AnchorPane propertiesView = (AnchorPane) rightLoader.load();
            borderPane.setRight(propertiesView);
    		
    		
			
            drawView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("Pane coordinates: X = " + event.getX() + ", Y = " + event.getY());
				}
            });
            
            /*****
               MouseListener ml = new MouseAdapter() {
			     public void mouseClicked(java.awt.event.MouseEvent evt) {
			        chatInputMouseClicked(evt);
			      }
			   };
			   chatInput.addMouseListener (ml);
			   chatInput.removeMouseListener (ml);
             *****/
            
            Rectangle r = new Rectangle(20, 20, 50, 50);
            r.setFill(Color.NAVY);
            r.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("RECTANGLE clicked.");
					//event.getButton() == MouseButton.SECONDARY;
					event.consume();
				}
            });
            drawView.getChildren().add(r);

            // finally, make a new scene with the border pane.
            editorScene = new Scene(borderPane);            
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return stage;
    }

}
