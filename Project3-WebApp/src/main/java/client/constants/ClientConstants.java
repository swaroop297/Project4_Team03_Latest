package client.constants;

import java.awt.Color;

import utility.Constants;
/**
 * ClientConstants holds values that are to be used
 * by the client program.
 */
public class ClientConstants extends Constants {
    public static volatile int CHANNELS = 2;
    public static final int MAX_RETRIES = 10;
    public static volatile int DEFAULT_FREQ = 2;
	public static final String MEDITATION = "Meditation";
	public static final String ENGAGEMENT = "Engagement";
	public static final String FRUSTATION = "Frustation";
	public static final String EXCITEMENTLT = "Excitement Long Term";
	public static final String EXCITEMENTST = "Excitement Short Term";
	public static final String FOCUS = "Focus";
	public final static String DISPLAY_LENGTH = "Length:";
	public final static String SECONDS = "Seconds";
	public final static Color FOCUS_COLOR = Color.BLACK;
	public final static Color GRAPHPANEL = new Color(238, 238, 238);
	public final static Color GRAPHLABEL_BACKGROUND = Color.GRAY;
	public final static Color GRAPHLABEL_FOREGROUND = Color.WHITE;
	public static Color meditationColor = Color.GREEN;
	public static Color engagementColor = Color.RED;
	public static Color frustationColor = Color.MAGENTA;
	public static Color relaxationColor = Color.YELLOW;
	public static Color excitementstColor = Color.BLUE;
	public static Color excitementltColor = Color.BLACK;
}
