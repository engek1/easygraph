package easygraph.eventhandlers;

import javafx.event.EventHandler;
import easygraph.application.Editor;
import easygraph.events.EdgeEvent;
import easygraph.model.EGProperty;

public class EdgeEventHandler extends AbstractEventHandler implements EventHandler<EdgeEvent> {

	public EdgeEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(EdgeEvent event) {
		// do some crazy stuff ...
		System.out.println("EDGE clicked, name: " + event.getEdge().get(EGProperty.EG_NAME));
		getEditor().getMode().editEdge(event.getEdge());
	}

}
