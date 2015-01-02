package easygraph.guielements;

import easygraph.model.EGProperty;
import graphlib.Edge;

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
public class EdgeDialog extends Dialog {
	private Edge<?> edge;
	final ButtonType buttonSave = new ButtonType("OK", ButtonData.OK_DONE);
	final ButtonType buttonCancle = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
	final TextField weight = new TextField();
	private GridPane grid = new GridPane();

	public EdgeDialog(Edge<?> edge) {
		this.edge = edge;
		
		this.setTitle("Edit");
		this.setHeaderText("Edit edge attributs");
		this.setGraphic(new ImageView(new Image("file:resources/images/settings.png")));

		// Set Dialog field background texts 
		weight.setPromptText("weight");
		
		// anzeige wert der original edge
		if (edge.has(EGProperty.WEIGHT)) {
			weight.setText("" + edge.get(EGProperty.WEIGHT));
		}
				
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

	
	@SuppressWarnings("unchecked")
	public void showIt() {
		weight.requestFocus();
		Optional<ButtonType> result = this.showAndWait();
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// Check if user changed attribute
			if(!this.weight.getText().equals("")) {
				
				try {
					double input = Double.valueOf(this.weight.getText());
					this.edge.set(EGProperty.WEIGHT, input);
					((GuiEdge) this.edge.get(EGProperty.EG_GUI_REFERENCE)).repaint();
					System.out.println("Changed edge weight to: " + this.weight.getText());
				} catch (NumberFormatException nfe) {}
			}
		}
	}
}
