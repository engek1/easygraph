package easygraph.controller;

/**
 * 
 * @author engek1
 *
 */
abstract public class BaseViewController {
	
	RootController rootController;

	public void setRootController(RootController rootController) {
		this.rootController = rootController;
	}

	public RootController getRootController() {
		return rootController;
	}
	
	
	
}
