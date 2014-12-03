package easygraph.state;

import javafx.scene.Cursor;
import easygraph.application.Editor;
import easygraph.events.EdgeRightClickEvent;
import easygraph.events.VertexLeftPressedEvent;
import easygraph.events.VertexRightClickEvent;

public class SelectState extends State {

	
	public SelectState(Editor editor) {
		super(editor);
	}
	

	@Override
	public void handle(VertexLeftPressedEvent event) {
		event.getGuiVertex().setCursor(Cursor.CLOSED_HAND);
		this.editor.getState().changeState(new MoveVertexState(this.editor, event.getGuiVertex()));
	}


	@Override
	public void handle(VertexRightClickEvent event) {
		System.out.println("@Override :: SelectState handles VertexRightClickEvent.");
		this.showPropertiesDialog();
	}
	
	
	@Override
	public void handle(EdgeRightClickEvent event) {
		System.out.println("@Override :: SelectState handles EdgeRightClickEvent.");
		this.showPropertiesDialog();
	}
	
	

}
