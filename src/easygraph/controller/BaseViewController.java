package easygraph.controller;

import easygraph.application.Editor;

abstract public class BaseViewController {
	
	Editor gui;
	
	public BaseViewController () {
		// nothing to do here yet.
	}
	
	public void setMainGUI(Editor gui) {
		this.gui = gui;
	}
}
