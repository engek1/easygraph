package easygraph.eventhandling;

import javafx.event.EventHandler;

public class EdgeEventHandler implements EventHandler<EdgeEvent> {

	@Override
	public void handle(EdgeEvent event) {
		// do some crazy stuff ...
		System.out.println("stored value in this EDGE: " + event.getEdge().element().toString());		
	}

}
