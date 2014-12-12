package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;

public class PauseEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<PauseEvent> PAUSE_CLICK = new EventType<PauseEvent>(ANY, "PAUSE_CLICK");

	public PauseEvent() {
		super(PAUSE_CLICK);
	}

}
