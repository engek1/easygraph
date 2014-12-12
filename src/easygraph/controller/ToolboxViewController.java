package easygraph.controller;

import easygraph.annotations.AlgorithmClazz;
import easygraph.annotations.AlgorithmMethod;
import easygraph.events.PlayEvent;
import easygraph.events.StateChangeEvent;
import easygraph.state.AddEdgeState;
import easygraph.state.AddVertexState;
import easygraph.state.PlayState;
import easygraph.state.SelectState;
import easygraph.utils.Config;
import graphlib.AlgorithmsCollection;

import java.lang.reflect.Method;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController extends BaseController {

	@FXML
	private Pane toolboxPane;
	
	@FXML
	private VBox vbox;

	@FXML
	private ComboBox<String> methodsBox = new ComboBox<String>();

	@FXML
	private Button playButton = new Button();
		
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		lookupMethods();
	}
	
	
	private void lookupMethods() {
		try {
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(Config.getLookupAlgorithmClassName());

			if (clazz.isAnnotationPresent(AlgorithmClazz.class)) {
				for (Method method : clazz.getDeclaredMethods()) {
					if (method.isAnnotationPresent(AlgorithmMethod.class)) {
						this.methodsBox.getItems().add(method.getName());
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	


	@FXML
	private void handleAddVertexClick() {
		Event.fireEvent(toolboxPane, new StateChangeEvent(new AddVertexState(this.getEditor())));
	}


	@FXML
	private void handleSelectClick() {
		Event.fireEvent(toolboxPane, new StateChangeEvent(new SelectState(this.getEditor())));
	}

	
	@FXML
	private void handleAddEdgeClick() {
		Event.fireEvent(toolboxPane, new StateChangeEvent(new AddEdgeState(this.getEditor())));
	}
	
	
	@FXML
	private void handlePlayClick() {
		System.out.println("-- PLAY clicked -> disable Buttons");
		this.disableButtons(true);
		if (this.methodsBox.getValue() != null && !this.methodsBox.getValue().equals("")) {
			Event.fireEvent(toolboxPane, new StateChangeEvent(new PlayState(this.getEditor(), this.methodsBox.getValue())));
			Event.fireEvent(toolboxPane, new PlayEvent());
		}
		// TODO : error hint when no algo is selected.
	}
	
	
	@FXML
	private void handlePauseClick() {
		System.out.println("-- PAUSE clicked.");
	}
	
	
	@FXML
	private void handleForwardClick() {
		System.out.println("-- FORWARD clicked.");
	}
	
	
	@FXML
	private void handleBackwardClick() {
		System.out.println("-- BACKWARD clicked.");
	}
	
	
	@FXML
	private void handleResetClick() {
		System.out.println("-- RESET clicked -> enable Buttons");
		this.disableButtons(false);
	}
	
	
	private void disableButtons(boolean disabled) {
		this.vbox.setDisable(disabled);
		this.methodsBox.setDisable(disabled);
	}
	
}