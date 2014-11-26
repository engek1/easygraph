package easygraph.eventhandlers;

import javafx.event.EventHandler;
import easygraph.application.Editor;
import easygraph.events.DrawViewClickEvent;

/**
 * 
 * @author Kaspar
 *
 */
public class DrawViewClickEventHandler extends AbstractEventHandler implements
		EventHandler<DrawViewClickEvent> {

	public DrawViewClickEventHandler(Editor editor) {
		super(editor);
	}

	@Override
	public void handle(DrawViewClickEvent event) {
		getEditor().getMode().drawViewLeftClick(event.getEvent().getX(), event
				.getEvent().getY());
		System.out.println("Pane coordinates: X = " + event.getEvent().getX()
				+ ", Y = " + event.getEvent().getY());
	}

}
