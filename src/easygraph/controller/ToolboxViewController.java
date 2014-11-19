package easygraph.controller;

import easygraph.eventhandling.ChangeModeEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController {

	@FXML
	private Pane toolboxPane;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public ToolboxViewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * handle user action
	 */
	@FXML
	private void handleAddVertexMode() {
		Event.fireEvent(toolboxPane, new ChangeModeEvent(
				ChangeModeEvent.Mode.ADD_VERTEX));
	}

	/**
	 * handle user action
	 */
	@FXML
	private void handleSelectMode() {
		Event.fireEvent(toolboxPane, new ChangeModeEvent(
				ChangeModeEvent.Mode.SELECT));
	}

	@FXML
	private void handleAddEdge() {
		Event.fireEvent(toolboxPane, new ChangeModeEvent(
				ChangeModeEvent.Mode.ADD_EDGE));
	}

}