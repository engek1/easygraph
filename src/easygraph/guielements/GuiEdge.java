package easygraph.guielements;

import easygraph.model.Coordinate;
import easygraph.model.EGProperty;
import graphlib.Edge;
import javafx.scene.shape.Line;

public class GuiEdge extends Line {
	
	private Edge<?> edge;
	
	public GuiEdge(Edge<?> edge) {
		super();
		this.edge = edge;
		init();
	}
	
	private void init() {
		Coordinate coords = (Coordinate) this.edge.get(EGProperty.EG_COORDINATES);
		//this.setStartX(......);
		//this.setStartY(......);
		//this.setEndX(......);
		//this.setEndY(......);
		
		//this.setFill(Color.NAVY);
		
		// and so on .....
	}

}
