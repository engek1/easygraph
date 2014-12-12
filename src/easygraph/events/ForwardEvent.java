package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;

public class ForwardEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<ForwardEvent> FORWARD_CLICK = new EventType<ForwardEvent>(ANY, "FORWARD_CLICK");

	public ForwardEvent() {
		super(FORWARD_CLICK);
	}

}
