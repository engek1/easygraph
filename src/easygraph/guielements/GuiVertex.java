package easygraph.guielements;

import easygraph.application.Editor;
import easygraph.events.VertexLeftClickEvent;
import easygraph.events.VertexLeftPressedEvent;
import easygraph.events.VertexRightClickEvent;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GuiVertex extends StackPane implements Repaintable {

	public static final int RADIUS = 20;
	private Vertex<?> vertex;
	
	private Ellipse ellipse;
	private Text text;
	
	public GuiVertex(Vertex<?> v) {
		this.vertex = v;
		this.init();
		v.set(EGProperty.EG_GUI_VERTEX_REFERENCE, this);
	}
	
	private void init() {
				
		// use an ellipse to make border visible
		ellipse = new Ellipse();
		ellipse.setRadiusX(GuiVertex.RADIUS);
		ellipse.setRadiusY(GuiVertex.RADIUS);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Config.getUnmarkColor());
		ellipse.setStrokeWidth(2.0);
		
		// use a Text for the string representation of the value stored in vertex
		
		Object obj = this.vertex.element();
		
		if (obj != null && (obj.getClass().isPrimitive() || obj instanceof String) ) {
			text = new Text(obj.toString());
		} else if (this.vertex.has(EGProperty.EG_NAME)) {
			text = new Text((String)this.vertex.get(EGProperty.EG_NAME));
		} else {
			text = new Text(Editor.getIdentifier());
		}
		
		text.setFont(Font.font(Config.getFontFamily(), FontWeight.BOLD, Config.getFontSize()));
		text.setFill(Config.getUnmarkColor());
				
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
		
		// add a Click Handler to the StackPane
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				// stop propagation of the originally fired event.
				event.consume();
				
				MouseButton btn = event.getButton();
				
				if (btn == MouseButton.PRIMARY) {
					GuiVertex.this.fireEvent(new VertexLeftClickEvent(GuiVertex.this));
				}
				else if (btn == MouseButton.SECONDARY) {
					GuiVertex.this.fireEvent(new VertexRightClickEvent(GuiVertex.this));
				}
			}
        });

		// add a Pressed Handler to the StackPane 
		this.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					GuiVertex.this.fireEvent(new VertexLeftPressedEvent(GuiVertex.this));
				}
				// stop propagation of originally fired event.
				event.consume();
			}
		});
		
	}

	public Vertex<?> getVertex() {
		return vertex;
	}
	
	@Override
	public void mark() {
		this.mark(Config.getMarkColor());
	}

	@Override
	public void mark(Color color) {
		ellipse.setStroke(color);
		text.setFill(color);
		this.effectProperty();
	}

	@Override
	public void unmark() {
		ellipse.setStroke(Config.getUnmarkColor());
		text.setFill(Config.getUnmarkColor());
		this.effectProperty();
	}

	@Override
	public void repaint() {
		Color color = (Color) vertex.get(EGProperty.EG_COLOR);
		mark(color);
		// TODO paint other gui properties...
	}
	
	
}
