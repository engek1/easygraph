package easygraph.model;

/**
 * 
 * @author engek1,...
 *
 */
public abstract class Step {

	private String property = null;
	private Object value = null;

	public Step(String property, Object value) {
		this.property = property;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public Object getValue() {
		return value;
	}

	/**
	 * Saves the current state of the property to a new Step to ensure backward functionality.
	 * @return
	 */
	public abstract Step getBackwardStep();

	/**
	 * save the property-change (that's what happens in this step) to the element. (decorable)
	 */
	public abstract void execute();
	
}