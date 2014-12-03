package easygraph.state;

import javafx.scene.Cursor;
import easygraph.application.Editor;
import easygraph.events.PaneMouseReleasedEvent;
import easygraph.guielements.GuiVertex;
import easygraph.model.EGProperty;

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

		if (coordX < 0) {
			coordX = 0;
		}
		if (coordY < 0) {
			coordY = 0;
		}
		// TODO: prevent maximum sizes exceeded.
		
		 // set new coordinates
		this.guiVertex.setLayoutX(coordX);
		this.guiVertex.setLayoutY(coordY);
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_X, coordX);
		this.guiVertex.getVertex().set(EGProperty.EG_COORDINATE_Y, coordY);

		this.guiVertex.setCursor(Cursor.DEFAULT);
		this.guiVertex.unmark();
		this.guiVertex.effectProperty();
		
		// TODO : update all connecting Edges.
		
		// finally, leave the drag-n-drop State and change to a SelectState.
		this.editor.getState().changeState(new SelectState(this.editor));;
	}

}
