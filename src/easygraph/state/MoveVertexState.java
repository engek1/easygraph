package easygraph.state;

import java.util.Iterator;

import javafx.scene.Cursor;
import easygraph.application.Editor;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.guielements.GuiEdge;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;
import easygraph.utils.Config;
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
		double coordX = event.getMouseEvent().getX() - GuiVertex.RADIUS;
		double coordY = event.getMouseEvent().getY() - GuiVertex.RADIUS;

		if (coordX < GuiVertex.RADIUS) {
			coordX = GuiVertex.RADIUS;
		}
		if (coordY < GuiVertex.RADIUS) {
			coordY = GuiVertex.RADIUS;
		}
		// TODO: prevent maximum sizes exceeded.
		
		 // set new coordinates
		this.guiVertex.setLayoutX(coordX);
		this.guiVertex.setLayoutY(coordY);
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_X, event.getMouseEvent().getX());
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_Y, event.getMouseEvent().getY());

		this.guiVertex.setCursor(Cursor.DEFAULT);
		this.guiVertex.unmark();
		this.guiVertex.effectProperty();
		
		// TODO : update all connecting Edges.
		Iterator<?> it = this.editor.getGraph().incidentEdges((Vertex) this.guiVertex.getVertex());
		while (it.hasNext()) {
			Edge<?> e = (Edge<?>) it.next();
			if (e.has(EGProperty.EG_GUI_EDGE_REFERENCE)) {
				GuiEdge ge = (GuiEdge) e.get(EGProperty.EG_GUI_EDGE_REFERENCE);
				ge.unmark();
				
				// TODO: don't work yet....
			}
		}
		
		// finally, leave the drag-n-drop State and change to a SelectState.
		this.editor.getState().changeState(new SelectState(this.editor));;
	}

}
