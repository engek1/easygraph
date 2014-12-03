package easygraph.controller;

import easygraph.annotations.AlgorithmClazz;
import easygraph.annotations.AlgorithmMethod;
import easygraph.events.StateChangeEvent;
import easygraph.state.AddEdgeState;
import easygraph.state.AddVertexState;
import easygraph.state.SelectState;
import graphlib.GraphExamples;

import java.lang.reflect.Method;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController extends BaseController {

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
		Event.fireEvent(toolboxPane, new StateChangeEvent(new AddVertexState(this.getEditor())));
	}


	@FXML
	private void handleSelectMode() {
		Event.fireEvent(toolboxPane, new StateChangeEvent(new SelectState(this.getEditor())));
	}

	
	@FXML
	private void handleAddEdge() {
		Event.fireEvent(toolboxPane, new StateChangeEvent(new AddEdgeState(this.getEditor())));
	}
	
}