package easygraph.controller;

import easygraph.application.Editor;

public class BaseController {
	
	private Editor editor;
	
	public void setEditor(Editor editor) {
		this.editor = editor;
	}
	
	public Editor getEditor() {
		return this.editor;
	}

}
