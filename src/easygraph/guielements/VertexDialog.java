package easygraph.guielements;

import java.util.Optional;

import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VertexDialog extends Dialog {

	ButtonType buttonSave = new ButtonType("Speichern", ButtonData.OK_DONE);
	ButtonType buttonCancle = new ButtonType("Abbrechen",
			ButtonData.CANCEL_CLOSE);

	public VertexDialog() {
		this.setTitle("dialog title");
		this.setHeaderText("header text");

		this.setGraphic(new ImageView(new Image(
				"file:resources/images/settings.png")));

		// Set the button types
		this.getDialogPane().getButtonTypes().addAll(buttonSave, buttonCancle);

		// dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL,
		// ButtonType.APPLY);

	}

	public void showIt() {
		Optional<ButtonType> result = this.showAndWait();
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// update
		}

	}

}
