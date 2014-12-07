package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;

public class PlayEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<PlayEvent> PLAY_CLICK = new EventType<PlayEvent>(ANY, "PLAY_CLICK");

	public PlayEvent() {
		super(PLAY_CLICK);
	}

}
