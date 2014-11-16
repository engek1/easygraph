package easygraph.eventhandling;

import java.util.Optional;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class AbstractEventHandler {

	private static final String HEADER_TEXT = "Edit Properties for this Element";
	
	private Stage stage;
	private String title;
	
	public AbstractEventHandler(Stage stage, String title) {
		this.stage = stage;
		this.title = title;
	}
	
	public void showPropertiesDialog() {
		
		Dialog dialog = new Dialog();
		dialog.setTitle(this.title);
		dialog.setHeaderText(AbstractEventHandler.HEADER_TEXT);
		
		String img = ClassLoader.getSystemClassLoader().getResource("easygraph/eventhandling/settings.png").toString();
		dialog.setGraphic(new ImageView(new Image(img)));

		
		// Set the button types.
		ButtonType buttonSave = new ButtonType("Speichern", ButtonData.OK_DONE);
		ButtonType buttonCancle = new ButtonType("Abbrechen", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonSave, buttonCancle);
		
		//dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.APPLY);
		
		Optional<ButtonType> result = dialog.showAndWait();
		System.out.println(result.toString());
		
		if (result.get().getButtonData() == ButtonData.OK_DONE) {
			// update
		}
		
		/*
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Login Dialog");
		dialog.setHeaderText("Look, a Custom Login Dialog");
		dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

		// Set the button types.
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		// Create the username and password labels and fields.
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField username = new TextField();
		username.setPromptText("Username");
		PasswordField password = new PasswordField();
		password.setPromptText("Password");

		grid.add(new Label("Username:"), 0, 0);
		grid.add(username, 1, 0);
		grid.add(new Label("Password:"), 0, 1);
		grid.add(password, 1, 1);

		// Enable/Disable login button depending on whether a username was entered.
		Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
		loginButton.setDisable(true);

		// Do some validation (using the Java 8 lambda syntax).
		username.textProperty().addListener((observable, oldValue, newValue) -> {
		    loginButton.setDisable(newValue.trim().isEmpty());
		});

		dialog.getDialogPane().setContent(grid);

		// Request focus on the username field by default.
		Platform.runLater(() -> username.requestFocus());

		// Convert the result to a username-password-pair when the login button is clicked.
		dialog.setResultConverter(dialogButton -> {
		    if (dialogButton == loginButtonType) {
		        return new Pair<>(username.getText(), password.getText());
		    }
		    return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		result.ifPresent(usernamePassword -> {
		    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
		});
		*/
		
	}

}
