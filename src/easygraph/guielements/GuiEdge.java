package easygraph.guielements;

import easygraph.events.EdgeLeftClickEvent;
import easygraph.events.EdgeRightClickEvent;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Edge;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
		
		this.setStrokeWidth(5.0);
		this.setStroke(Config.getUnmarkColor());
				
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				MouseButton btn = event.getButton();
				
				if (btn == MouseButton.PRIMARY) {
					GuiEdge.this.fireEvent(new EdgeLeftClickEvent(GuiEdge.this.edge));
				}
				else if (btn == MouseButton.SECONDARY) {
					GuiEdge.this.fireEvent(new EdgeRightClickEvent(GuiEdge.this.edge));
				}

				event.consume();
			}
        });
	}
}
