package easygraph.eventhandling;

import javafx.event.EventHandler;
import easygraph.application.Editor;
import easygraph.model.EGProperty;

public class VertexEventHandler extends AbstractEventHandler implements EventHandler<VertexEvent>  {

	public VertexEventHandler(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(VertexEvent event) {
		// do some crazy stuff ...
		System.out.println("VERTEX clicked, name: " + event.getVertex().get(EGProperty.EG_NAME));
		getEditor().getMode().vertexClicked(event.getVertex());
		
		//showPropertiesDialog();
	}
	
}
