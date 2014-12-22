package easygraph.guielements;

import easygraph.model.EGProperty;
import easygraph.utils.ClassChecker;
import graphlib.Vertex;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


@SuppressWarnings("rawtypes")
public class VertexDialog extends Dialog {
	private Vertex<?> vertex;
	private final ButtonType buttonSave = new ButtonType("Ok", ButtonData.OK_DONE);
	private final ButtonType buttonCancle = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	private final TextField name = new TextField();
	private GridPane grid = new GridPane();
	
	public VertexDialog(Vertex<?> vertex) {
		this.vertex = vertex;
		this.setTitle("Edit");
		this.setHeaderText("Edit vertex attributes");
		this.setGraphic(new ImageView(new Image("file:resources/images/settings.png")));
		
		// Set Dialog field background texts
		name.setPromptText("vertex name");
		
		if (vertex.has(EGProperty.EG_NAME)) {
			name.setText((String)vertex.get(EGProperty.EG_NAME));
		} else {
			name.setText("");
		}
		
		// Create a custom dialog
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));
		
		// Add and position text fields to the grid
		grid.add(new Label("Name:"), 0 , 0);
		grid.add(name, 1, 0);
		
		// Add grid to dialog
		this.getDialogPane().setContent(grid);
		
		// Set the button types
		this.getDialogPane().getButtonTypes().addAll(buttonSave, buttonCancle);		
	}

	
	@SuppressWarnings("unchecked")
	public void showIt() {
		Optional<ButtonType> result = this.showAndWait();
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// to do update vertex value
			
			// Check if user changed attribute
			if(!this.name.getText().equals("")) {
				System.out.println("Changed vertex name to: " + this.name.getText());
				this.vertex.set(EGProperty.EG_NAME, this.name.getText());
			}
		}
	}
}
