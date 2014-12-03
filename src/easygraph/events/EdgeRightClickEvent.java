package easygraph.events;

import graphlib.Edge;
import javafx.event.Event;
import javafx.event.EventType;

public class EdgeRightClickEvent extends Event {

	private static final long serialVersionUID = 1L;
	
	private Edge<?> edge;
	
	public static final EventType<EdgeRightClickEvent> EDGE_RIGHT_CLICK = new EventType<EdgeRightClickEvent>(ANY, "EDGE_RIGHT_CLICK");
	
	public EdgeRightClickEvent(Edge<?> e) {
		super(EDGE_RIGHT_CLICK);
		this.edge = e;
	}
	
	public Edge<?> getEdge() {
		return this.edge;
	}
	
}
