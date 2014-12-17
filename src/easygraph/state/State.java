package easygraph.state;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import easygraph.application.Editor;
import easygraph.events.BackwardEvent;
import easygraph.events.EdgeLeftClickEvent;
import easygraph.events.EdgeRightClickEvent;
import easygraph.events.ForwardEvent;
import easygraph.events.PaneLeftClickEvent;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.events.PauseEvent;
import easygraph.events.PlayEvent;
import easygraph.events.ResetEvent;
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
	
	public void enter() {
		System.out.println("entering new State '" + this.getClass().getSimpleName() + "' ...");
		this.editor.getPrimaryStage().getScene().addEventHandler(Event.ANY, this);
	}

	public void leave() {
		System.out.println("leaving old State '" + this.getClass().getSimpleName() + "' ...");
		this.editor.getPrimaryStage().getScene().removeEventHandler(Event.ANY, this);
	}
	
	public void showErrorDialog(String text) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("oops, something went wrong ...");
		alert.setContentText(text);
		alert.showAndWait();
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
		} else if (event instanceof PlayEvent) {
			this.handle((PlayEvent)event);
		} else if(event instanceof PauseEvent){
			this.handle((PauseEvent)event);
		} else if(event instanceof ForwardEvent){
			this.handle((ForwardEvent)event);
		} else if(event instanceof BackwardEvent){
			this.handle((BackwardEvent)event);
		} else if(event instanceof ResetEvent){
			this.handle((ResetEvent)event);
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
	
	public void handle(PlayEvent event) {
		System.out.println("State does nothing with PlayEvent.");
	}
	
	public void handle(PauseEvent event) {
		System.out.println("State does nothing with PauseEvent.");
	}
	
	public void handle(ForwardEvent event) {
		System.out.println("State does nothing with ForwardEvent.");
	}
	
	public void handle(BackwardEvent event) {
		System.out.println("State does nothing with BackwardEvent.");
	}
	
	public void handle(ResetEvent event) {
		System.out.println("State does nothing with ResetEvent.");
	}
	
}
