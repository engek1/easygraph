package easygraph.state;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import easygraph.application.Editor;
import easygraph.events.EdgeRightClickEvent;
import easygraph.events.VertexLeftPressedEvent;
import easygraph.events.VertexRightClickEvent;
import easygraph.guielements.EdgeDialog;
import easygraph.guielements.GuiVertex;
import easygraph.guielements.Texts;
import easygraph.guielements.VertexDialog;
import easygraph.model.EGProperty;

public class SelectState extends State {

	
	public SelectState(Editor editor) {
		super(editor);
	}
	

	@Override
	public void handle(VertexLeftPressedEvent event) {
		event.getGuiVertex().setCursor(Cursor.CLOSED_HAND);
		this.changeState(new MoveVertexState(this.editor, event.getGuiVertex()));
	}


	@Override
	public void handle(VertexRightClickEvent event) {		
		double screenX = event.getEvent().getScreenX();
		double screenY = event.getEvent().getScreenY();
		Node anchor = (Node) event.getEvent().getSource();
		
		// create context menu
		ContextMenu cm = new ContextMenu();
		// add edit action
		MenuItem cmEdit = new MenuItem("Edit");
		cmEdit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	// show dialog
		    	VertexDialog dialog = new VertexDialog();
		    	dialog.showIt();
		    }
		});
		cm.getItems().add(cmEdit);
		// add delete action
		MenuItem cmDelete = new MenuItem("Delete");
		cmDelete.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	editor.removeEdge(event.getVertex());
		    }
		});
		cm.getItems().add(cmDelete);

    	GuiVertex guiVertex = (GuiVertex) event.getVertex().get(EGProperty.EG_GUI_REFERENCE);
    	boolean isStartV = guiVertex.isStartVertex();
		String itemText = isStartV ? Texts.REMOVE_AS_START_VERTEX : Texts.SET_AS_START_VERTEX;
		MenuItem cmAsStartVertex = new MenuItem(itemText);
		cmAsStartVertex.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	guiVertex.setAsStartVertex(!isStartV);
		    }
		});
		cm.getItems().add(cmAsStartVertex);
		// show context menu
		cm.show(anchor, screenX, screenY);
	}
	
	
	@Override
	public void handle(EdgeRightClickEvent event) {		
		double screenX = event.getEvent().getScreenX();
		double screenY = event.getEvent().getScreenY();
		Node anchor = (Node) event.getEvent().getSource();
		
		// create context menu
		ContextMenu cm = new ContextMenu();
		// add edit action
		MenuItem cmEdit = new MenuItem("Edit");
		cmEdit.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	// show dialog
		    	EdgeDialog dialog = new EdgeDialog();
		    	dialog.showIt();
		    }
		});
		cm.getItems().add(cmEdit);
		// add delete action
		MenuItem cmDelete = new MenuItem("Delete");
		cmDelete.setOnAction(new EventHandler<ActionEvent>() {
		    public void handle(ActionEvent e) {
		    	editor.removeEdge(event.getEdge());
		    }
		});
		cm.getItems().add(cmDelete);
		// show context menu
		cm.show(anchor, screenX, screenY);
	}

}
