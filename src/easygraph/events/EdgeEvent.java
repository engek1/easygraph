package easygraph.events;

import graphlib.Edge;
import javafx.event.Event;
import javafx.event.EventType;


/**
 * Event class for events fired by an Edge.
 * 
 * @author webel3
 */
public class EdgeEvent extends Event {
	private static final long serialVersionUID = 1L;
	
	private Edge<?> edge;
	
	public static final EventType<EdgeEvent> EDGE_CLICKED = new EventType<EdgeEvent>(ANY, "EDGE_CLICKED");

	public EdgeEvent(Edge<?> e) {
		this(EDGE_CLICKED);
		this.edge = e;
	}
	
	public EdgeEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public Edge<?> getEdge() {
		return this.edge;
	}
	
}
