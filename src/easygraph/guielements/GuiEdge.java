package easygraph.guielements;

import easygraph.events.EdgeLeftClickEvent;
import easygraph.events.EdgeRightClickEvent;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
import graphlib.Edge;
import graphlib.Vertex;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GuiEdge extends Line implements Repaintable {
	
	private Edge<?> edge;
	private Vertex<?> origin;
	private Vertex<?> destination;
	private Text text = new Text();
	private final boolean isDirected;
	private Polygon arrow = new Polygon();
	
	private EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			MouseButton btn = event.getButton();
			
			if (btn == MouseButton.PRIMARY) {
				GuiEdge.this.fireEvent(new EdgeLeftClickEvent(GuiEdge.this.edge));
			}
			else if (btn == MouseButton.SECONDARY) {
				GuiEdge.this.fireEvent(new EdgeRightClickEvent(GuiEdge.this.edge, event));
			}

			event.consume();
		}
    };
	
	public GuiEdge(Edge<?> edge, Vertex<?> origin, Vertex<?> destination, boolean isDirected) {
		this.edge = edge;
		this.origin = origin;
		this.destination = destination;
		this.isDirected = isDirected;
		edge.set(EGProperty.EG_GUI_REFERENCE, this);
		init();
	}
	
	private void init() {
		this.setStrokeWidth(5.0);
		this.setStroke(Config.getUnmarkColor());
				
		this.setOnMouseClicked(eventHandler);
		this.text.setOnMouseClicked(eventHandler);		
		
		this.text.setFill(Config.getFontColor());
		this.text.setFont(Font.font(Config.getFontFamily(), FontWeight.BOLD, Config.getFontSize()));

		DropShadow ds = new DropShadow();
		ds.setColor(Color.WHITE);
		ds.setSpread(1.0);
		ds.setHeight(10.0);
		ds.setWidth(10.0);
		this.text.setEffect(ds);
		
		this.setText();
		
		this.markDirection();
		
		this.setCoordinates();
	}
	
	private void markDirection() {
		if(this.isDirected){
	        arrow.getPoints().addAll(new Double[]{
	                    0.0, 10.0,
	                    -10.0, -10.0,
	                    10.0, -10.0});
	        arrow.setFill(Config.getUnmarkColor());
		}
	}

	private void setText(){
		if(!this.edge.has(EGProperty.WEIGHT)){
			this.edge.set(EGProperty.WEIGHT, 1.0);
		}
		// TODO : for the GUI, show the double value as an integer without "1.0" notation
		// WARNING : it cannot be an integer because of the GraphExamples which expects a Double value!
		double w = (double) this.edge.get(EGProperty.WEIGHT);
		int i = (int)w;
		String txt = String.valueOf(i);
		this.text.setText(txt);
	}

	public void setCoordinates() {
		double startX = (double)this.origin.get(EGProperty.EG_COORDINATE_X);
		double startY = (double)this.origin.get(EGProperty.EG_COORDINATE_Y);
		this.setStartX(startX);
		this.setStartY(startY);
		
		double endX = (double)this.destination.get(EGProperty.EG_COORDINATE_X);
		double endY = (double)this.destination.get(EGProperty.EG_COORDINATE_Y);
		this.setEndX(endX);
		this.setEndY(endY);
		
		// middle of origin and destination
		double textX = (startX+endX)/2;
		double textY = (startY+endY)/2;
		
		// adjust position by the size of the text
		Bounds bounds = this.text.getBoundsInParent();
		this.text.setLayoutX(textX - (bounds.getWidth()/2) );
		this.text.setLayoutY(textY + (bounds.getHeight()/4) );
		
		if(isDirected){
			//compute angle
			double rad = Math.atan2(endY - startY, endX - startX);
			double angle = rad * 180 / 3.14;
	        arrow.setRotate(angle - 90);
	        
	        // compute correction
	        double y = Math.sin(rad) * (Config.VERTEX_RADIUS + 10.0);
	        double x = Math.cos(rad) * (Config.VERTEX_RADIUS + 10.0);

	        arrow.setTranslateX(endX - x);
	        arrow.setTranslateY(endY - y);
		}
		
	}

	@Override
	public void mark() {
		this.mark(Config.getMarkColor());
	}

	@Override
	public void mark(Color color) {
		this.setStroke(color);
		this.arrow.setFill(color);
		this.effectProperty();
	}

	@Override
	public void unmark() {
		this.setStroke(Config.getUnmarkColor());
		this.effectProperty();		
	}

	@Override
	public void repaint() {
		Color color;
		if (edge.has(EGProperty.EG_COLOR)) {
			color = (Color) edge.get(EGProperty.EG_COLOR);
		}else{
			color =  Config.getUnmarkColor();
			edge.set(EGProperty.EG_COLOR, color);
		}
		mark(color);
		this.setText();
		this.setCoordinates();
		// TODO paint other gui properties...
	}
	
	public Text getText(){
		return this.text;
	}

	public Polygon getArrow() {
		return this.arrow;
	}
}
