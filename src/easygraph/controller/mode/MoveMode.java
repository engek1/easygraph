package easygraph.controller.mode;

import javafx.scene.Cursor;
import easygraph.application.Editor;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class MoveMode extends Mode {

	private GuiVertex gVertex;;

	public MoveMode(Editor editor, GuiVertex gVertex) {
		super(editor);
		this.gVertex = gVertex;
		System.out.println("change mode: " + getClass().getName());
	}

	@Override
	public void drawViewMouseReleased(double x, double y) {
		double xCoord = x-GuiVertex.RADIUS;
		double yCoord = y-GuiVertex.RADIUS;
		
		// prevent move to outside top, left
		if(xCoord<0){
			xCoord = 0;
		}
		if(yCoord<0){
			yCoord = 0;
		}
		// TODO prevent move to outside right, bottom
		
		// set new coordinates
		gVertex.setLayoutX(xCoord);
		gVertex.setLayoutY(yCoord);
		gVertex.getVertex().set(EGProperty.EG_COORDINATE_X, xCoord);
		gVertex.getVertex().set(EGProperty.EG_COORDINATE_Y, yCoord);
		System.out.println("moved vertex to x:" + xCoord + " y:" + yCoord);
		

		gVertex.setCursor(Cursor.DEFAULT);
		
		editor.setMode(new SelectMode(editor));
	}

	/* do nothing */
	@Override
	public void vertexClicked(Vertex<?> vertex) {
	}

	@Override
	public void vertexPressed(GuiVertex gVertex) {
	}

	@Override
	public void drawViewLeftClick(double x, double y) {
	}

	@Override
	public void editEdge(Edge<?> edge) {
	}

	@Override
	public void editVertex(Vertex<?> vertex) {
	}

}
