package easygraph.state;

import easygraph.application.Editor;
import easygraph.events.PlayEvent;

public class PlayState extends State {

	public PlayState(Editor editor) {
		super(editor);
	}
	
	@Override
	public void handle(PlayEvent event) {
		System.out.println("auto-play now ...");
		/*
		try {
			if (!Thread.interrupted()) {
				Thread.currentThread();
				Thread.sleep(2000);
				Event.fireEvent(editor.getPrimaryStage().getScene(), new PlayEvent());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	}
}
