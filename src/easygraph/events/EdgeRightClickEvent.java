package easygraph.events;

import graphlib.Edge;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class EdgeRightClickEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	private Edge<?> edge;
	private MouseEvent event;
	
	public static final EventType<EdgeRightClickEvent> EDGE_RIGHT_CLICK = new EventType<EdgeRightClickEvent>(ANY, "EDGE_RIGHT_CLICK");
	
	public EdgeRightClickEvent(Edge<?> e, MouseEvent event) {
		super(EDGE_RIGHT_CLICK);
		this.edge = e;
		this.event = event;
	}
	
	public Edge<?> getEdge() {
		return this.edge;
	}

	public MouseEvent getEvent() {
		return event;
	}

}
