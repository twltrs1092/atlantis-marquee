package util;

import javafx.css.PseudoClass;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public final class Global
{
    // Data
    public static char BREAK_CHAR = '|';

    // Marquee
    public static int MAX_SPEED = 10; // milliseconds per dot
    public static int DEFAULT_SPEED = 200; // milliseconds per dot
    public static int NUM_COLS = 96;
    public static int NUM_ROWS = 16;
    private static int BORDER_WIDTH = 1;
    private static int PADDING_WIDTH = 1;
    public static int BORDER_SIZE = NUM_COLS * 2 + NUM_ROWS * 2 - 4; // does not account for change in width
    public static int PADDING_SIZE = (NUM_ROWS - 2) * 2 + (NUM_COLS - 2) * 2 - 4; // does not account for change in width
    public static int TEXT_COLS = NUM_COLS - (BORDER_WIDTH * 2 + PADDING_WIDTH * 2);
    public static int TEXT_ROWS = NUM_ROWS - (BORDER_WIDTH * 2 + PADDING_WIDTH * 2);
    public static int TEXT_COL_START = BORDER_WIDTH + PADDING_WIDTH;
    public static int TEXT_COL_END = NUM_COLS - (BORDER_WIDTH + PADDING_WIDTH + 1);
    public static int TEXT_ROW_START = BORDER_WIDTH + PADDING_WIDTH;
    public static int TEXT_ROW_END = NUM_ROWS - (BORDER_WIDTH + PADDING_WIDTH + 1);
    public static int MAX_WIDTH;
    public static int MAX_HEIGHT;
    public static int MIN_WIDTH = 200;
    public static int MIN_HEIGHT = 50;

    // GUI
    public static Color OFF_COLOR = Color.BLACK;
    public static Color DEFAULT_TEXT_COLOR = Color.WHITE;
    public static String TEXT_FONT = "Helvetica";
    public static final PseudoClass INVALID = PseudoClass.getPseudoClass("invalid");

    // Validation
    public static int MAX_IMAGE_HEIGHT = 300;
    public static int MAX_IMAGE_WIDTH = 1200;
    public static int MIN_OPACITY = 90;
    public static int MAX_BORDER_COLORS = 4;

    public static void init()
    {
        MAX_WIDTH = (int) Screen.getPrimary().getVisualBounds().getWidth();
        MAX_HEIGHT = (int) (MAX_WIDTH / (NUM_COLS * 1.0 / NUM_ROWS));
    }

    private Global() {}
}