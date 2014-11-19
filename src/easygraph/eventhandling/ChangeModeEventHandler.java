package easygraph.eventhandling;

import javafx.event.EventHandler;
import easygraph.application.Editor;
import easygraph.controller.mode.AddEdgeMode;
import easygraph.controller.mode.AddVertexMode;
import easygraph.controller.mode.SelectMode;
import easygraph.eventhandling.ChangeModeEvent.Mode;

public class ChangeModeEventHandler extends AbstractEventHandler implements EventHandler<ChangeModeEvent> {

	public ChangeModeEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(ChangeModeEvent event) {
		
		if(event.getMode()==Mode.SELECT){
			getEditor().setMode(new SelectMode(getEditor()));
		}else if(event.getMode()==Mode.ADD_VERTEX){
			getEditor().setMode(new AddVertexMode(getEditor()));
		}else if(event.getMode()==Mode.ADD_EDGE){
			getEditor().setMode(new AddEdgeMode(getEditor()));
		}else{
			System.out.println("ERROR: tried to change Mode to unknown state.");
		}
		
		
	}

}
