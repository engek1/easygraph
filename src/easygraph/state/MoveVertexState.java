package easygraph.state;

import java.util.Iterator;

import javafx.scene.Cursor;
import easygraph.application.Editor;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;
import graphlib.Edge;
import graphlib.Vertex;

public class MoveVertexState extends State {

	private GuiVertex guiVertex;
	
	public MoveVertexState(Editor editor, GuiVertex guiVertex) {
		super(editor);
		this.guiVertex = guiVertex;
		guiVertex.mark();
	}
	
	@Override
	public void handle(PaneMouseReleasedEvent event) {
		
		double eventX = event.getMouseEvent().getX();
		double eventY = event.getMouseEvent().getY();
		
		double coordX = eventX - GuiVertex.RADIUS;
		double coordY = eventY - GuiVertex.RADIUS;

		if (coordX < GuiVertex.RADIUS) {
			coordX = GuiVertex.RADIUS;
		}
		if (coordY < GuiVertex.RADIUS) {
			coordY = GuiVertex.RADIUS;
		}
		
		// TODO: prevent maximum sizes exceeded.
		
		this.guiVertex.setLayoutX(coordX);
		this.guiVertex.setLayoutY(coordY);
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_X, eventX);
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_Y, eventY);

		this.guiVertex.setCursor(Cursor.DEFAULT);
		this.guiVertex.unmark();
		
		// update all connecting edges
		Iterator<?> it = this.editor.getGraph().incidentEdges((Vertex) this.guiVertex.getVertex());
		while (it.hasNext()) {
			Edge<?> e = (Edge<?>) it.next();
			if (e.has(EGProperty.EG_GUI_EDGE_REFERENCE)) {
				GuiEdge ge = (GuiEdge) e.get(EGProperty.EG_GUI_EDGE_REFERENCE);
				ge.setCoordinates();
			}
		}
		
		// finally, leave the drag-n-drop State and change to a SelectState.
		this.changeState(new SelectState(this.editor));;
	}

}
