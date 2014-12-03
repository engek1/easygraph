package easygraph.state;

import easygraph.application.Editor;
import easygraph.events.PaneLeftClickEvent;

public class AddVertexState extends State {

	public AddVertexState(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(PaneLeftClickEvent event) {
		System.out.println("handle PaneLeftClickEvent ...");
		this.editor.addVertex(event.getMouseEvent().getX(), event.getMouseEvent().getY());
	}

}
