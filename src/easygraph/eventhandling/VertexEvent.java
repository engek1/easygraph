package easygraph.eventhandling;

import graphlib.Vertex;
import javafx.event.Event;
import javafx.event.EventType;


/**
 * Event class for events fired by a Vertex.
 * 
 * @author webel3
 */
public class VertexEvent extends Event {
	private static final long serialVersionUID = 1L;
	
	private Vertex<?> vertex;
	
	public static final EventType<VertexEvent> VERTEX_CLICKED = new EventType<VertexEvent>(ANY, "VERTEX_CLICKED");

	public VertexEvent(Vertex<?> v) {
		this(VERTEX_CLICKED);
		this.vertex = v;
	}
	
	public VertexEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public Vertex<?> getVertex() {
		return this.vertex;
	}
	
}
