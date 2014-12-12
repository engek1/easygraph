package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;

public class BackwardEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<BackwardEvent> BACKWARD_CLICK = new EventType<BackwardEvent>(ANY, "BACKWARD_CLICK");

	public BackwardEvent() {
		super(BACKWARD_CLICK);
	}

}
