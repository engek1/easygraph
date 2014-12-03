package easygraph.utils;

import javafx.scene.paint.Color;

public class Config {
	
	private static final double GUI_PADDING = 30;
	private static final String GUI_COLOR_UNMARKED = "#6495ED"; // cornflower blue
	private static final String GUI_COLOR_MARKED = "#FF4000";
	
	private static final String FONT_FAMILY = "Verdana";
	private static final double FONT_SIZE = 15.0;
	private static final String FONT_COLOR = "#333333";

	
	public static double getPadding() {
		return Config.GUI_PADDING;
	}
	
	public static Color getUnmarkColor() {
		return Color.valueOf(Config.GUI_COLOR_UNMARKED);
	}
	
	public static Color getMarkColor() {
		return Color.valueOf(Config.GUI_COLOR_MARKED);
	}
	
	public static String getFontFamily() {
		return Config.FONT_FAMILY;
	}
	
	public static double getFontSize() {
		return Config.FONT_SIZE;
	}
	
	public static Color getFontColor() {
		return Color.valueOf(Config.FONT_COLOR);
	}
}
