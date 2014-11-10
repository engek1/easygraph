package easygraph.model;

import graphlib.Vertex;

/**
 * 
 * @author engek1,...
 *
 */
public class VStep extends Step {

	/* Edge or Vertex */
	private Vertex<?> vertex = null;
	/**
	 * 
	 * @param element
	 * @param property
	 * @param value
	 */
	public VStep(Vertex<?> element, String property, Object value) {
		super(property, value);
		this.vertex = element;
		
	}

	public Vertex<?> getVertex() {
		return vertex;
	}
	
	@Override
	public Step getBackwardStep() {
		VStep bStep = new VStep(vertex, getProperty(), vertex.get(getProperty()));
		return bStep;
	}

	@Override
	public void execute() {
		this.vertex.set(getProperty(), getValue());
	}
	
}
