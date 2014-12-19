package easygraph.state;

import easygraph.application.Editor;
import easygraph.events.VertexLeftClickEvent;
import easygraph.events.VertexRightClickEvent;
import easygraph.guielements.GuiVertex;
import easygraph.guielements.Texts;

public class AddEdgeState extends State {
	
	private GuiVertex origin = null;

	public AddEdgeState(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(VertexLeftClickEvent event) {
		GuiVertex guiVertex = event.getGuiVertex();
		
		if (this.origin == null) {
			this.origin = guiVertex;
			guiVertex.mark();
		}
		else {
			if (this.origin == guiVertex) {
				this.editor.showConfirmDialog(Texts.ERROR_SELECT_TWO_DIFFERENT_VERTICES_TO_CONNECT);
			} else {
				try {
				    this.editor.addEdge(this.origin.getVertex(), event.getGuiVertex().getVertex());
				    this.origin.unmark();
				    
				    // finally, change to a new AddEdgeState. otherwise, you would insert a new Edge from the origin vertex.
				    this.changeState(new AddEdgeState(this.editor));
				} catch (RuntimeException re) {
					this.editor.showConfirmDialog(Texts.ERROR_RUNTIME_CATCHED + re.getMessage());
				}
			}
		}
	}
	
	@Override
	public void handle(VertexRightClickEvent event) {
		if (this.origin != null) {
			this.origin.unmark();
			this.changeState(new AddEdgeState(this.editor));
		}
	}
	
	
	@Override
	public void leave() {
		if (this.origin != null) {
			this.origin.unmark();
		}
		// remember to call the parent's leave!
		super.leave();
	}

}
