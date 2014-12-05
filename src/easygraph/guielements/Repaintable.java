package easygraph.guielements;

import javafx.scene.paint.Color;

public interface Repaintable {
	
	
	void mark();
	
	void mark(Color color);
	
	void unmark();
	
	/**
	 * repaint all gui-specific attributes from model.
	 */
	void repaint();

}
