package easygraph.eventhandling;

import javafx.event.EventHandler;

public class VertexEventHandler implements EventHandler<VertexEvent> {

	@Override
	public void handle(VertexEvent event) {
		// do some crazy stuff ...
		System.out.println("stored value in this VERTEX: " + event.getVertex().element().toString());	
	}

}
