package easygraph.eventhandling;

import javafx.event.EventHandler;
import javafx.stage.Stage;

public class EdgeEventHandler extends AbstractEventHandler implements EventHandler<EdgeEvent> {

	private static final String TITLE = "I'm the EdgeEventHandler title";
	
	public EdgeEventHandler(Stage stage) {
		super(stage, EdgeEventHandler.TITLE);
	}
	
	@Override
	public void handle(EdgeEvent event) {
		// do some crazy stuff ...
		System.out.println("stored value in this VERTEX: " + event.getEdge().element().toString());
		showPropertiesDialog();
	}

}
