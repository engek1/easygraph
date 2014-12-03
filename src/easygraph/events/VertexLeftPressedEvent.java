package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import easygraph.guielements.GuiVertex;

public class VertexLeftPressedEvent extends Event {

	private static final long serialVersionUID = 1L;

	private GuiVertex guiVertex;
	
	public static final EventType<VertexLeftPressedEvent> VERTEX_LEFT_PRESSED = new EventType<VertexLeftPressedEvent>(ANY, "VERTEX_LEFT_PRESSED");
	
	public VertexLeftPressedEvent(GuiVertex guiVertex) {
		this(VERTEX_LEFT_PRESSED);
		this.guiVertex = guiVertex;
	}
	
	public VertexLeftPressedEvent(EventType<? extends Event> eventType) {
		super(eventType);
	}
	
	public GuiVertex getGuiVertex() {
		return this.guiVertex;
	}
	
}