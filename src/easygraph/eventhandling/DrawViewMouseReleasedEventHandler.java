package easygraph.eventhandling;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import easygraph.application.Editor;

/**
 * 
 * @author Kaspar
 *
 */
public class DrawViewMouseReleasedEventHandler extends AbstractEventHandler
		implements EventHandler<DrawViewMouseReleasedEvent> {

	public DrawViewMouseReleasedEventHandler(Editor editor) {
		super(editor);
	}

	@Override
	public void handle(DrawViewMouseReleasedEvent event) {
		if (event.getEvent().getButton() == MouseButton.PRIMARY) {
			getEditor().getMode().drawViewMouseReleased(
					event.getEvent().getX(), event.getEvent().getY());
		}
	}

}
