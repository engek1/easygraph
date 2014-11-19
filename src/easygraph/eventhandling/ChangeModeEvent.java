package easygraph.eventhandling;

import javafx.event.Event;
import javafx.event.EventType;

public class ChangeModeEvent extends Event {

	private static final long serialVersionUID = -7755034971916883619L;

	public static final EventType<ChangeModeEvent> CHANGE_MODE = new EventType<ChangeModeEvent>(ANY, "CHANGE_MODE");
	
	public static enum Mode{
		SELECT, ADD_VERTEX, ADD_EDGE
	}

	private Mode mode;
	
	public ChangeModeEvent(Mode mode) {
		super(CHANGE_MODE);
		this.mode = mode;
	}

	public Mode getMode() {
		return mode;
	}
	
}
