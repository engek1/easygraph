package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class PaneLeftClickEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	private MouseEvent mouseEvent;
	
	public static final EventType<PaneLeftClickEvent> PANE_LEFT_CLICK = new EventType<PaneLeftClickEvent>(ANY, "PANE_LEFT_CLICK");

	public PaneLeftClickEvent(MouseEvent me) {
		super(PANE_LEFT_CLICK);
		this.mouseEvent = me;
	}

	
	public MouseEvent getMouseEvent() {
		return this.mouseEvent;
	}
	
}
