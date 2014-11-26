package easygraph.eventhandling;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import easygraph.application.Editor;
import easygraph.model.EGProperty;

public class VertexEventHandler extends AbstractEventHandler implements EventHandler<VertexEvent>  {

	public VertexEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(VertexEvent event) {		
		/*
		 *  pass only primary mouse button clicks to the vertex clicked action
		 *  and pass others to edit vertex action
		 */
		if(event.getEvent().getButton() == MouseButton.PRIMARY){
			getEditor().getMode().vertexClicked(event.getVertex());
		}else {
			getEditor().getMode().editVertex(event.getVertex());
		}
	}
	
}
