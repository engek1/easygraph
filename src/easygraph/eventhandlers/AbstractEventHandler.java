package easygraph.eventhandlers;

import easygraph.application.Editor;

public class AbstractEventHandler {

	private Editor editor;
	
	public AbstractEventHandler(Editor editor) {
		this.editor = editor;
	}

	public Editor getEditor() {
		return editor;
	}
	
}
