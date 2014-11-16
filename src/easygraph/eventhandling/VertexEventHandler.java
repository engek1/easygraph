package easygraph.eventhandling;

import org.controlsfx.dialog.Dialogs;

import javafx.event.EventHandler;
import javafx.stage.Stage;

public class VertexEventHandler extends AbstractEventHandler implements EventHandler<VertexEvent>  {

	private static final String TITLE = "I'm the VertexEventHandler title";
	
	public VertexEventHandler(Stage stage) {
		super(stage, VertexEventHandler.TITLE);
	}
	
	@Override
	public void handle(VertexEvent event) {
		// do some crazy stuff ...
		System.out.println("stored value in this VERTEX: " + event.getVertex().element().toString());
		showPropertiesDialog();
	}

}
