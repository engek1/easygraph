package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import easygraph.guielements.GuiVertex;

public class VertexRightClickEvent extends Event {

	private GuiVertex guiVertex;
	
	private static final long serialVersionUID = 1L;

	public static final EventType<VertexRightClickEvent> VERTEX_RIGHT_CLICK = new EventType<VertexRightClickEvent>(ANY, "VERTEX_RIGHT_CLICK");

	public VertexRightClickEvent(GuiVertex guiVertex) {
		super(VERTEX_RIGHT_CLICK);
		this.guiVertex = guiVertex;
	}
	
	public GuiVertex getGuiVertex() {
		return this.guiVertex;
	}
}
