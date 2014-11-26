package easygraph.events;

import graphlib.Vertex;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;


/**
 * Event class for events fired by a Vertex.
 * 
 * @author webel3
 */
public class VertexClickedEvent extends Event {
	private static final long serialVersionUID = 1L;
	
	private Vertex<?> vertex;
	private MouseEvent event;
	
	public static final EventType<VertexClickedEvent> VERTEX_CLICKED = new EventType<VertexClickedEvent>(ANY, "VERTEX_CLICKED");

	public VertexClickedEvent(Vertex<?> v, MouseEvent event) {
		this(VERTEX_CLICKED);
		this.vertex = v;
		this.event = event;
	}
	
	public VertexClickedEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public Vertex<?> getVertex() {
		return this.vertex;
	}

	public MouseEvent getEvent() {
		return event;
	}
	
}
