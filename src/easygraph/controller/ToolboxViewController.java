package easygraph.controller;

import java.lang.reflect.Method;

import easygraph.annotations.AlgorithmClazz;
import easygraph.annotations.AlgorithmMethod;
import easygraph.events.ChangeModeEvent;
import graphlib.GraphExamples;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController {

	@FXML
	private Pane toolboxPane;

	@FXML
	ComboBox<String> methodsBox = new ComboBox<String>();
	

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
		lookupMethods();
	}
	
	
	private void lookupMethods() {
		try {
			Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(GraphExamples.class.getCanonicalName());

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
	private void handleAddVertexMode() {
		Event.fireEvent(toolboxPane, new ChangeModeEvent(
				ChangeModeEvent.Mode.ADD_VERTEX));
	}


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