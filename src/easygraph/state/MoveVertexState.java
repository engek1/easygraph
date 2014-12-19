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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void handle(PaneMouseReleasedEvent event) {
		
		double eventX = event.getMouseEvent().getX();
		double eventY = event.getMouseEvent().getY();
		
		double coordX = eventX - Config.VERTEX_RADIUS;
		double coordY = eventY - Config.VERTEX_RADIUS;

		if (coordX < Config.VERTEX_RADIUS) {
			coordX = Config.VERTEX_RADIUS;
		}
		if (coordY < Config.VERTEX_RADIUS) {
			coordY = Config.VERTEX_RADIUS;
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
			if (e.has(EGProperty.EG_GUI_REFERENCE)) {
				GuiEdge ge = (GuiEdge) e.get(EGProperty.EG_GUI_REFERENCE);
				ge.setCoordinates();
			}
		}
		
		// finally, leave the drag-n-drop State and change to a SelectState.
		this.changeState(new SelectState(this.editor));;
	}

}
