package easygraph.guielements;

import easygraph.controller.VertexClickHandler;
import easygraph.model.EGProperty;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class GuiVertex extends Circle {
	
	private static final int RADIUS = 15;
	private Vertex<?> vertex;
	private VertexClickHandler clickHandler;
	
	public GuiVertex(Vertex<?> vertex, VertexClickHandler clickHandler) {
		super(RADIUS);
		this.vertex = vertex;
		this.clickHandler = clickHandler;
		init();
	}
	
	private void init() {
		this.setCenterX((double)vertex.get(EGProperty.EG_COORDINATE_X));
		this.setCenterY((double)vertex.get(EGProperty.EG_COORDINATE_Y));
		
		this.setFill(Color.NAVY);
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("vertex clicked");
				clickHandler.handleClick(vertex);
				event.consume();
			}
        });
		
	}

}
