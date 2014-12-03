package easygraph.events;

import graphlib.Edge;
import javafx.event.Event;
import javafx.event.EventType;

public class EdgeLeftClickEvent extends Event {

	private static final long serialVersionUID = 1L;

	private Edge<?> edge;
	
	public static final EventType<EdgeLeftClickEvent> EDGE_LEFT_CLICK = new EventType<EdgeLeftClickEvent>(ANY, "EDGE_LEFT_CLICK");
	
	public EdgeLeftClickEvent(Edge<?> e) {
		super(EDGE_LEFT_CLICK);
		this.edge = e;
	}
	
	public Edge<?> getEdge() {
		return this.edge;
	}
	
}
