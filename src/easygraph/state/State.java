package easygraph.state;

import java.util.Optional;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import easygraph.application.Editor;
import easygraph.events.EdgeLeftClickEvent;
import easygraph.events.EdgeRightClickEvent;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.events.PaneLeftClickEvent;
import easygraph.events.StateChangeEvent;
import easygraph.events.VertexLeftClickEvent;
import easygraph.events.VertexLeftPressedEvent;
import easygraph.events.VertexRightClickEvent;

public abstract class State implements EventHandler<Event> {
	
	protected Editor editor;

	public State(Editor editor) {
		this.editor = editor;
	}
	
	
	public final void changeState(State newState) {
		this.leave();
		this.editor.setState(newState);
		newState.enter();
	}
	

	public final void enter() {
		System.out.println("entering new State '" + this.getClass().getSimpleName() + "' ...");
		this.editor.getPrimaryStage().getScene().addEventHandler(Event.ANY, this);
	}
	
	

	public final void leave() {
		System.out.println("leaving old State '" + this.getClass().getSimpleName() + "' ...");
		this.editor.getPrimaryStage().getScene().removeEventHandler(Event.ANY, this);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void showPropertiesDialog() {
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
	
	
	@Override
	public void handle(Event event) {
		if (event instanceof StateChangeEvent) {
			this.changeState(((StateChangeEvent) event).getState());
		}
		
		// we have to use such an ugly construction because the eventhandler
		// interface cannot be implemented several times.
		else if (event instanceof PaneLeftClickEvent) {
			this.handle((PaneLeftClickEvent)event);
		} else if (event instanceof VertexLeftClickEvent) {
			this.handle((VertexLeftClickEvent)event);
		} else if (event instanceof VertexRightClickEvent) {
			this.handle((VertexRightClickEvent)event);
		} else if (event instanceof VertexLeftPressedEvent) {
			this.handle((VertexLeftPressedEvent)event);
		} else if (event instanceof EdgeLeftClickEvent) {
			this.handle((EdgeLeftClickEvent)event);
		} else if (event instanceof EdgeRightClickEvent) {
			this.handle((EdgeRightClickEvent)event);
		} else if (event instanceof PaneMouseReleasedEvent) {
			this.handle((PaneMouseReleasedEvent)event);
		} else {
			// fallback is quite difficult because of each mouse-move events, etc.
		}
	}
	
	
	public void handle(PaneLeftClickEvent event) {
		System.out.println("State does nothing with PaneLeftClickEvent.");
	}
	
	public void handle(VertexRightClickEvent event) {
		System.out.println("State does nothing with VertexRightClickEvent.");
	}
	
	public void handle(VertexLeftClickEvent event) {
		System.out.println("State does nothing with VertexLeftClickEvent.");
	}
	
	public void handle(VertexLeftPressedEvent event) {
		System.out.println("State does nothing with VertexLeftPressedEvent.");
	}
	
	public void handle(EdgeLeftClickEvent event) {
		System.out.println("State does nothing with EdgeLeftClickEvent.");
	}
	
	public void handle(EdgeRightClickEvent event) {
		System.out.println("State does nothing with EdgeRightClickEvent.");
	}
	
	public void handle(PaneMouseReleasedEvent event) {
		System.out.println("State does nothing with PaneMouseReleasedEvent.");
	}
	
}
