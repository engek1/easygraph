package easygraph.controller.mode;

import java.util.Optional;

import javafx.scene.Cursor;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import easygraph.application.Editor;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * Select Elements Mode
 * 
 * @author engek1
 *
 */
public class SelectMode extends Mode {

	public SelectMode(Editor editor) {
		super(editor);
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void editVertex(Vertex<?> vertex) {
		showPropertiesDialog();
	}

	@Override
	public void editEdge(Edge<?> edge) {
		showPropertiesDialog();
	}

	@Override
	public void vertexPressed(GuiVertex gVertex) {

		gVertex.setCursor(Cursor.HAND);
		
		editor.setMode(new MoveMode(editor, gVertex));
	}

	/* do nothing */
	@Override
	public void drawViewLeftClick(double x, double y) {}

	@Override
	public void vertexClicked(Vertex<?> vertex) {}

	@Override
	public void drawViewMouseReleased(double x, double y) {}

	private void showPropertiesDialog() {
	
		Dialog dialog = new Dialog();
		dialog.setTitle("dialog title");
		dialog.setHeaderText("header text");
	
		dialog.setGraphic(new ImageView(new Image("file:resources/images/settings.png")));
		
		// Set the button types.
		ButtonType buttonSave = new ButtonType("Speichern", ButtonData.OK_DONE);
		ButtonType buttonCancle = new ButtonType("Abbrechen",
				ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes()
				.addAll(buttonSave, buttonCancle);
	
		// dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL,
		// ButtonType.APPLY);
	
		Optional<ButtonType> result = dialog.showAndWait();
		System.out.println(result.toString());
	
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// update
		}
	}

}
