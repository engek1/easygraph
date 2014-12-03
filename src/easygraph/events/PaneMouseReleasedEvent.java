package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class PaneMouseReleasedEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	public static final EventType<PaneMouseReleasedEvent> PANE_MOUSE_RELEASED = new EventType<PaneMouseReleasedEvent>(ANY, "PANE_MOUSE_RELEASED");
	
	private MouseEvent mouseEvent;
	
	public PaneMouseReleasedEvent(MouseEvent me) {
		super(PANE_MOUSE_RELEASED);
		this.mouseEvent = me;
	}
	
	public MouseEvent getMouseEvent() {
		return this.mouseEvent;
	}
	
}