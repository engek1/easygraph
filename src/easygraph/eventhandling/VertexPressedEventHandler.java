package easygraph.eventhandling;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import easygraph.application.Editor;
import easygraph.model.EGProperty;

public class VertexPressedEventHandler extends AbstractEventHandler implements EventHandler<VertexPressedEvent>  {

	public VertexPressedEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(VertexPressedEvent event) {		
		/*
		 *  pass only primary mouse button clicks to the vertex clicked action
		 *  and pass others to edit vertex action
		 */
		if(event.getEvent().getButton() == MouseButton.PRIMARY){
			getEditor().getMode().vertexPressed(event.getGuiVertex());
		}
	}
	
}
