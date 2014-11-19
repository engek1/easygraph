package easygraph.eventhandling;

import graphlib.Vertex;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;


/**
 * Event class for events fired by a Vertex.
 * 
 * @author webel3
 */
public class VertexEvent extends Event {
	private static final long serialVersionUID = 1L;
	
	private Vertex<?> vertex;
	private MouseEvent event;
	
	public static final EventType<VertexEvent> VERTEX_CLICKED = new EventType<VertexEvent>(ANY, "VERTEX_CLICKED");

	public VertexEvent(Vertex<?> v, MouseEvent event) {
		this(VERTEX_CLICKED);
		this.vertex = v;
		this.event = event;
	}
	
	public VertexEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public Vertex<?> getVertex() {
		return this.vertex;
	}

	public MouseEvent getEvent() {
		return event;
	}
	
}
