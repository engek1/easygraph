package easygraph.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainGUI extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("EasyGraph - Editor View");
        initRootLayout();
        showEditor();
    }
    
    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainGUI.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showEditor() {
        try {
        	FXMLLoader leftLoader = new FXMLLoader();
            leftLoader.setLocation(MainGUI.class.getResource("../view/ToolboxView.fxml"));
            AnchorPane toolboxView = (AnchorPane) leftLoader.load();

            FXMLLoader centerLoader = new FXMLLoader();
            centerLoader.setLocation(MainGUI.class.getResource("../view/DrawView.fxml"));
            AnchorPane drawView = (AnchorPane) centerLoader.load();
            drawView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("Pane coordinates: X = " + event.getX() + ", Y = " + event.getY());
				}
            });
            
            Rectangle r = new Rectangle(10, 20, 50, 100);
            r.setFill(Color.YELLOW);
            r.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println("RECTANGLE clicked.");
					event.consume();
				}
            });
            drawView.getChildren().add(r);

            FXMLLoader rightLoader = new FXMLLoader();
            rightLoader.setLocation(MainGUI.class.getResource("../view/PropertiesView.fxml"));
            AnchorPane propertiesView = (AnchorPane) rightLoader.load();
            
            rootLayout.setLeft(toolboxView);
            rootLayout.setCenter(drawView);
            rootLayout.setRight(propertiesView);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
