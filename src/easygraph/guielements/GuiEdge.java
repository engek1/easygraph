package easygraph.guielements;

import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Vertex;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GuiEdge extends Line {
	
	private Edge<?> edge;
	private Vertex<?> origin;
	private Vertex<?> destination;
	
	public GuiEdge(Edge<?> edge, Vertex<?> origin, Vertex<?> destination) {
		super();
		this.edge = edge;
		this.origin = origin;
		this.destination = destination;
		init();
	}
	
	private void init() {
		this.setStartX((double)this.origin.get(EGProperty.EG_COORDINATE_X));
		this.setStartY((double)this.origin.get(EGProperty.EG_COORDINATE_Y));
		
		this.setEndX((double)this.destination.get(EGProperty.EG_COORDINATE_X));
		this.setEndY((double)this.destination.get(EGProperty.EG_COORDINATE_Y));
		
		this.setStrokeWidth(2.0);
		this.setStroke(Color.NAVY);
	}

}
