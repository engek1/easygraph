package easygraph.utils;

import javafx.scene.paint.Color;

public class Config {
	
	private static final double GUI_PADDING = 30;
	private static final String GUI_COLOR = "#6495ED"; // cornflower blue
	
	private static final String FONT_FAMILY = "Verdana";
	private static final double FONT_SIZE = 15.0;
	private static final String FONT_COLOR = "#333333";

	
	public static double getPadding() {
		return Config.GUI_PADDING;
	}
	
	public static Color getColor() {
		return Color.valueOf(Config.GUI_COLOR);
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
