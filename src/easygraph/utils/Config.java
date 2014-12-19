package easygraph.utils;

import javafx.scene.paint.Color;

public class Config {
	
	private static final double GUI_PADDING = 30;
	private static final String GUI_COLOR_UNMARKED = "#466aa8"; // dark blue
	private static final String GUI_COLOR_MARKED = "#FF4000"; // red
	
	private static final String FONT_FAMILY = "Verdana";
	private static final double FONT_SIZE = 15.0;
	private static final String FONT_COLOR = "#333333";
	
	private static final String ALGORITHM_CLASS_NAME = "graphlib.GraphExamples";
	
	// VERTEX
	public static final double VERTEX_BORDER_WIDTH = 2.0;
	public static final Color DEFAULT_VERTEX_COLOR = Color.WHITE;
	public static final Color START_VERTEX_COLOR = Color.valueOf("#ffcf7c"); // hellorange
	public static final int VERTEX_RADIUS = 20;

	
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
	
	public static String getLookupAlgorithmClassName() {
		return Config.ALGORITHM_CLASS_NAME;
	}
}
