package easygraph.controller.mode;

import easygraph.application.Editor;
import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1
 *
 */
public abstract class Mode {

	Editor editor;

	public Mode(Editor editor) {
		this.editor = editor;
	}
	
	public abstract void drawViewLeftClick(double x, double y);

	public abstract void vertexClicked(Vertex<?> vertex);

	public abstract void editEdge(Edge<?> edge);
	
	public abstract void editVertex(Vertex<?> vertex);
	
}
