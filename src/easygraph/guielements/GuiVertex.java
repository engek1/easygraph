
package easygraph.guielements;

import easygraph.application.Editor;
import easygraph.events.VertexLeftClickEvent;
import easygraph.events.VertexLeftPressedEvent;
import easygraph.events.VertexRightClickEvent;
import easygraph.model.EGProperty;
import easygraph.utils.ClassChecker;
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


	private Vertex<?> vertex;

	private Ellipse ellipse = new Ellipse();
	private Text text = new Text();

	public GuiVertex(Vertex<?> v) {
		this.vertex = v;
		v.set(EGProperty.EG_GUI_REFERENCE, this);
		v.set(EGProperty.EG_COLOR, Config.getUnmarkColor());
		this.init();
	}

	private void init() {
						
		// use an ellipse to make border visible
		ellipse.setRadiusX(Config.VERTEX_RADIUS);
		ellipse.setRadiusY(Config.VERTEX_RADIUS);
		ellipse.setFill(Color.WHITE);
		ellipse.setStroke(Config.getUnmarkColor());
		ellipse.setStrokeWidth(Config.VERTEX_BORDER_WIDTH);
		
		if(isStartVertex()){
			setAsStartVertex(true);
		}
		
		this.setText();
		text.setFont(Font.font(Config.getFontFamily(), FontWeight.BOLD, Config.getFontSize()));
		text.setFill(Config.getUnmarkColor());
				
		// get the X and Y positions where the centers of the vertex circle have to be
		double coordX = (double)vertex.get(EGProperty.EG_COORDINATE_X);
		double coordY = (double)vertex.get(EGProperty.EG_COORDINATE_Y);
		
		// sort of ugly --- substract the radius of the circle from the x/y position
		// reason is that the StackPane is positioned with the left top corner, but
		// should be positioned with its center, so correct the layout
		this.setLayoutX(coordX - Config.VERTEX_RADIUS);
		this.setLayoutY(coordY - Config.VERTEX_RADIUS);
		
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
					GuiVertex.this.fireEvent(new VertexRightClickEvent(GuiVertex.this.vertex, event));
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
		Color color;
		if (vertex.has(EGProperty.EG_COLOR)) {
			color = (Color) vertex.get(EGProperty.EG_COLOR);
		}else{
			color =  Config.getUnmarkColor();
			vertex.set(EGProperty.EG_COLOR, color);
		}
		mark(color);
		this.setText();
	}

	public void setAsStartVertex(boolean bool) {
		if (bool) {
			ellipse.setFill(Config.START_VERTEX_COLOR);
			this.vertex.set(EGProperty.EG_IS_START_VERTEX, true);
		} else {
			ellipse.setFill(Config.DEFAULT_VERTEX_COLOR);
			this.vertex.destroy(EGProperty.EG_IS_START_VERTEX);
		}
	}

	public boolean isStartVertex() {
		if (this.vertex.has(EGProperty.EG_IS_START_VERTEX)) {
			boolean bool = (boolean) this.vertex
					.get(EGProperty.EG_IS_START_VERTEX);
			return bool;
		} else {
			return false;
		}

	}

	private void setText() {
		// use a Text for the string representation of the value stored in vertex
		Object obj = this.vertex.element();
		String txt;
		if (this.vertex.has(EGProperty.EG_NAME)) {
			txt = (String) this.vertex.get(EGProperty.EG_NAME);
		} else if (ClassChecker.isDisplayable(obj)) {
			txt = obj.toString();
		} else {
			txt = Editor.getIdentifier();
		}
		text.setText(txt);
	}

}
