package easygraph.eventhandling;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class DrawViewMouseReleasedEvent extends Event {
	private static final long serialVersionUID = -6650819385410924748L;

	public static final EventType<DrawViewMouseReleasedEvent> DRAW_VIEW_MOUSE_RELEASED = new EventType<DrawViewMouseReleasedEvent>(
			ANY, "DRAW_VIEW_MOUSE_RELEASED");

	private MouseEvent event;

	public DrawViewMouseReleasedEvent(MouseEvent event) {
		super(DRAW_VIEW_MOUSE_RELEASED);
		this.event = event;
	}

	public MouseEvent getEvent() {
		return event;
	}

}
