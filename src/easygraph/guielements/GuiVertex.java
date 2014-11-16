package easygraph.guielements;

import easygraph.eventhandling.VertexEvent;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GuiVertex extends StackPane {

	public static final int RADIUS = 20;
	private Vertex<?> vertex;
	
	public GuiVertex(Vertex<?> v) {
		this.vertex = v;
		this.init();
	}
	
	private void init() {
		
		// use an ellipse to make border visible
		Ellipse ellipse = new Ellipse();
		ellipse.setRadiusX(GuiVertex.RADIUS);
		ellipse.setRadiusY(GuiVertex.RADIUS);
		
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Config.getColor());
		ellipse.setStrokeWidth(2.0);
		
		// use a Text for the string representation of the value stored in vertex
		Text text = new Text(this.vertex.element().toString());
		text.setFont(Font.font(Config.getFontFamily(), FontWeight.BOLD, Config.getFontSize()));
		text.setFill(Config.getColor());
		
		// get the X and Y positions where the centers of the vertex circle have to be
		double coordX = (double)vertex.get(EGProperty.EG_COORDINATE_X);
		double coordY = (double)vertex.get(EGProperty.EG_COORDINATE_Y);
		
		// sort of ugly --- substract the radius of the circle from the x/y position
		// reason is that the StackPane is positioned with the left top corner, but
		// should be positioned with its center, so correct the layout
		this.setLayoutX(coordX - GuiVertex.RADIUS);
		this.setLayoutY(coordY - GuiVertex.RADIUS);
		
		// add the text and the ellipse to the StackPane:
		// text has to be 2nd param, otherwise the ellipse would cover the text
		this.getChildren().addAll(ellipse, text);
		
		// add a VertexEvent to the StackPane
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				event.consume();
				GuiVertex.this.fireEvent(new VertexEvent(GuiVertex.this.vertex));
			}
        });
	}
}
