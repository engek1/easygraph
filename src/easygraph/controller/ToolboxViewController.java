package easygraph.controller;

import java.lang.reflect.Method;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import easygraph.annotations.AlgorithmClazz;
import easygraph.annotations.AlgorithmMethod;
import easygraph.events.BackwardEvent;
import easygraph.events.ForwardEvent;
import easygraph.events.PauseEvent;
import easygraph.events.PlayEvent;
import easygraph.events.ResetEvent;
import easygraph.events.StateChangeEvent;
import easygraph.guielements.Texts;
import easygraph.state.AddEdgeState;
import easygraph.state.AddVertexState;
import easygraph.state.PlayState;
import easygraph.state.SelectState;
import easygraph.utils.Config;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController extends BaseController {

	@FXML
	private Pane toolboxPane;
	
	@FXML
	private VBox editBox;

	@FXML
	private ComboBox<String> methodsBox = new ComboBox<String>();

	@FXML
	private VBox playBox;
	
	@FXML
	private VBox pauseBox;
	
	@FXML
	private VBox resetBox;
	
	@FXML
	private VBox forwardBox;
	
	@FXML
	private VBox backwardBox;
	
	@FXML
	private VBox speedBox;

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
		System.out.println("PLAY clicked.");
		
		if (this.methodsBox.getValue() == null || this.methodsBox.getValue().equals("")) {
			this.getEditor().getState().showErrorDialog(Texts.ERROR_NO_METHOD_SELECTED);
			return;
		}
		
		// quite ugly, but works : the 2nd child of the speedbox is the speed slider.
		Slider s = (Slider)this.speedBox.getChildren().get(1);
		this.getEditor().setSpeed((long)s.getValue());
		
		this.editBox.setDisable(true);
		this.methodsBox.setDisable(true);
		
		this.playBox.setDisable(true);
		this.forwardBox.setDisable(true);
		this.backwardBox.setDisable(true);
		this.pauseBox.setDisable(false);
		this.resetBox.setDisable(false);
		this.speedBox.setDisable(true);
		
		Event.fireEvent(toolboxPane, new StateChangeEvent(new PlayState(this.getEditor(), this.methodsBox.getValue())));
		Event.fireEvent(toolboxPane, new PlayEvent());
	}
	
	
	@FXML
	private void handlePauseClick() {
		this.playBox.setDisable(false);
		this.forwardBox.setDisable(false);
		this.backwardBox.setDisable(false);
		this.pauseBox.setDisable(true);
		this.resetBox.setDisable(false);
		this.speedBox.setDisable(false);
		Event.fireEvent(toolboxPane, new PauseEvent());
	}
	
	
	@FXML
	private void handleForwardClick() {
		Event.fireEvent(toolboxPane, new ForwardEvent());
	}
	
	
	@FXML
	private void handleBackwardClick() {
		Event.fireEvent(toolboxPane, new BackwardEvent());
	}
	
	
	@FXML
	private void handleResetClick() {
		this.playBox.setDisable(false);
		this.forwardBox.setDisable(true);
		this.backwardBox.setDisable(true);
		this.pauseBox.setDisable(true);
		this.resetBox.setDisable(true);
		this.speedBox.setDisable(false);
		
		this.editBox.setDisable(false);
		this.methodsBox.setDisable(false);
		
		Event.fireEvent(toolboxPane, new ResetEvent());
	}

}