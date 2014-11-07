package easygraph.guielements;

import easygraph.model.Coordinate;
import easygraph.model.EGProperty;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GuiVertex extends Circle {
	
	private static final int RADIUS = 15;
	private Vertex<?> vertex;
	
	public GuiVertex(Vertex<?> vertex) {
		super(RADIUS);
		this.vertex = vertex;
		init();
	}
	
	private void init() {
		Coordinate coords = (Coordinate) vertex.get(EGProperty.EG_COORDINATES);
		this.setCenterX(coords.getX());
		this.setCenterY(coords.getY());
		
		this.setFill(Color.NAVY);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("RECTANGLE clicked.");
				//event.getButton() == MouseButton.SECONDARY;
				event.consume();
			}
        });
		
	}


}
