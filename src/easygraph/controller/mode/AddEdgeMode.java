package easygraph.controller.mode;

import easygraph.application.Editor;
import easygraph.guielements.GuiVertex;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public class AddEdgeMode extends Mode {

	private Vertex<?> fromVertex = null;

	public AddEdgeMode(Editor editor) {
		super(editor);
		System.out.println("change to: " + getClass().getName());
	}

	@Override
	public void vertexClicked(Vertex<?> vertex) {

		if (fromVertex == null) {
			this.fromVertex = vertex;
		}else if(fromVertex!=vertex){
			Vertex<?> fromV = fromVertex;
			this.fromVertex = null;
			editor.addEdge(fromV, vertex);
		}else{
			System.out.println("Choose two different vertices!");
		}

	}

	/* no action */
	@Override
	public void drawViewLeftClick(double x, double y) {}

	@Override
	public void editEdge(Edge<?> edge) {}

	@Override
	public void editVertex(Vertex<?> vertex) {}

	@Override
	public void vertexPressed(GuiVertex guiVertex) {}

	@Override
	public void drawViewMouseReleased(double x, double y) {}

}
