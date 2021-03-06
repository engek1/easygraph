package easygraph.model;

import graphlib.Decorable;

/**
 * 
 * @author engek1,...
 *
 */
public class Step<T extends Decorable> {

	private T object = null;
	private String property = null;
	private Object value = null;

	
	public Step(T object, String property, Object value) {
		this.object = object;
		this.property = property;
		this.value = value;
	}


	public String getProperty() {
		return property;
	}

	public Object getValue() {
		return value;
	}

	public T getObject() {
		return object;
	}


	/**
	 * Saves the current state of the property to a new Step to ensure backward functionality.
	 * @return 
	 */
	public Step<T> origin() {
		Object propertyValue = null;
		if (object.has(property)) {
			propertyValue = object.get(property);
		}
		return new Step<T>(this.object, property, propertyValue);
	}

	/**
	 * save the property-change (that's what happens in this step) to the element. (decorable)
	 */
	public void apply() {
		this.object.set(this.getProperty(), this.getValue());
	}
	
}