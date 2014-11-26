package easygraph.events;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;

/**
 * 
 * @author Kaspar
 *
 */
public class DrawViewClickEvent extends Event {

	private static final long serialVersionUID = -7755034971916883619L;

	public static final EventType<DrawViewClickEvent> DRAW_VIEW_CLICKED = new EventType<DrawViewClickEvent>(ANY, "DRAW_VIEW_CLICKED");
	

	private MouseEvent event;
	
	public DrawViewClickEvent(MouseEvent event) {
		super(DRAW_VIEW_CLICKED);
		this.event = event;
	}

	public MouseEvent getEvent() {
		return event;
	}
	
}
