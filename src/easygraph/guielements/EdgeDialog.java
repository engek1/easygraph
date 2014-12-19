package easygraph.guielements;

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

public class EdgeDialog extends Dialog {

	final ButtonType buttonSave = new ButtonType("OK", ButtonData.OK_DONE);
	final ButtonType buttonCancle = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	final TextField weight = new TextField();
	private GridPane grid = new GridPane();

	public EdgeDialog() {
		this.setTitle("Edit");
		this.setHeaderText("Edit edge attributs");
		this.setGraphic(new ImageView(new Image("file:resources/images/settings.png")));

		// Set Dialog field background texts 
		weight.setPromptText("weight");
		// anzeige wert der original edge weight.setText(""); 
				
		// Create a custom dialog
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(0, 10, 0, 10));
		
		// Add and position text fields to the grid
		grid.add(new Label("Weight:"), 0 , 0);
		grid.add(weight, 1, 0);
		
		// Add grid to dialog
		this.getDialogPane().setContent(grid);
		
		// Set the button types
		this.getDialogPane().getButtonTypes().addAll(buttonSave, buttonCancle);	
	}

	public void showIt() {
		Optional<ButtonType> result = this.showAndWait();
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// to do update edge value 
			
			// Check if user changed attribute
			if(!this.weight.getText().equals("")) {
				System.out.println("Changed edge weight to: " + this.weight.getText());
			}
		}
	}
}
