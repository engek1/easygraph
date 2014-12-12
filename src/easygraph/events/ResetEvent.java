package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;

public class ResetEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<ResetEvent> RESET_CLICK = new EventType<ResetEvent>(ANY, "RESET_CLICK");

	public ResetEvent() {
		super(RESET_CLICK);
	}

}
