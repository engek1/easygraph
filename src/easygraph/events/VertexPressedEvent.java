package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import easygraph.guielements.GuiVertex;

/**
 * 
 * @author Kaspar
 *
 */
public class VertexPressedEvent extends Event {
	private static final long serialVersionUID = -5117234075408684860L;
	
	private GuiVertex gVertex;
	private MouseEvent event;
	
	public static final EventType<VertexPressedEvent> VERTEX_PRESSED = new EventType<VertexPressedEvent>(ANY, "VERTEX_PRESSED");

	public VertexPressedEvent(GuiVertex v, MouseEvent event) {
		this(VERTEX_PRESSED);
		this.gVertex = v;
		this.event = event;
	}
	
	public VertexPressedEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public GuiVertex getGuiVertex() {
		return this.gVertex;
	}

	public MouseEvent getEvent() {
		return event;
	}
	
}
