package easygraph.model;

import graphlib.Edge;

/**
 * 
 * @author engek1,...
 *
 */
public class EStep extends Step {

	/* Edge or Vertex */
	private Edge<?> edge = null;
	/**
	 * 
	 * @param element
	 * @param property
	 * @param value
	 */
	public EStep(Edge<?> edge, String property, Object value) {
		super(property, value);
		this.edge = edge;
		
	}

	public Edge<?> getEdge() {
		return edge;
	}

	@Override
	public Step getBackwardStep() {
		EStep bStep = new EStep(edge, getProperty(), edge.get(getProperty()));
		return bStep;
	}

	@Override
	public void execute() {
		this.edge.set(getProperty(), getValue());
	}
	
	
	
}
