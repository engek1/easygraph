package easygraph.eventhandling;

import javafx.event.EventHandler;
import easygraph.application.Editor;
import easygraph.controller.mode.AddEdgeMode;
import easygraph.controller.mode.AddVertexMode;
import easygraph.controller.mode.SelectMode;

public class ChangeModeEventHandler extends AbstractEventHandler implements EventHandler<ChangeModeEvent> {

	public ChangeModeEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(ChangeModeEvent event) {
		
		switch (event.getMode()) {
		case SELECT:
			getEditor().setMode(new SelectMode(getEditor()));
			break;
		case ADD_VERTEX:
			getEditor().setMode(new AddVertexMode(getEditor()));
			break;
		case ADD_EDGE:
			getEditor().setMode(new AddEdgeMode(getEditor()));
			break;
		default:
			System.out.println("ERROR: tried to change Mode to unknown state.");
			break;
		}
	}
}
