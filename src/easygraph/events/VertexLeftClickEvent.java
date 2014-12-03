package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import easygraph.guielements.GuiVertex;

public class VertexLeftClickEvent extends Event {

	private GuiVertex guiVertex;
	
	private static final long serialVersionUID = 1L;

	public static final EventType<VertexLeftClickEvent> VERTEX_LEFT_CLICK = new EventType<VertexLeftClickEvent>(ANY, "VERTEX_LEFT_CLICK");

	public VertexLeftClickEvent(GuiVertex guiVertex) {
		super(VERTEX_LEFT_CLICK);
		this.guiVertex = guiVertex;
	}
	
	public GuiVertex getGuiVertex() {
		return this.guiVertex;
	}
}
