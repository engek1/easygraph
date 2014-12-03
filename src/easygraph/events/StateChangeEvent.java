package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import easygraph.state.State;

public class StateChangeEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<StateChangeEvent> STATE_CHANGE = new EventType<StateChangeEvent>(ANY, "STATE_CHANGE");

	private State state;
	
	public StateChangeEvent(State state) {
		super(STATE_CHANGE);
		this.state = state;
	}
	
	public State getState() {
		return this.state;
	}

}
