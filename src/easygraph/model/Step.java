package easygraph.model;

import java.util.HashMap;
import java.util.Map;

import graphlib.Edge;
import graphlib.Vertex;

/**
 * 
 * @author engek1,...
 *
 */
public class Step {

	private StepType type = null;
	
	private Edge<?> edge = null;
	
	private Vertex<?> vertex = null;
	
	private Map<?,?> options = new HashMap<Object, Object>();
	
	
}
