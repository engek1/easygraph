package easygraph.events;

import graphlib.Vertex;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

public class VertexRightClickEvent extends Event {

	private Vertex<?> vertex;
	private MouseEvent event;
	
	private static final long serialVersionUID = 1L;

	public static final EventType<VertexRightClickEvent> VERTEX_RIGHT_CLICK = new EventType<VertexRightClickEvent>(ANY, "VERTEX_RIGHT_CLICK");

	public VertexRightClickEvent(Vertex<?> vertex, MouseEvent event) {
		super(VERTEX_RIGHT_CLICK);
		this.vertex = vertex;
		this.event = event;
	}
	
	public Vertex<?> getVertex() {
		return this.vertex;
	}

	public MouseEvent getEvent() {
		return event;
	}
	
}
