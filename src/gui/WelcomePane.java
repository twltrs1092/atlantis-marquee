package gui;

import data.Message;
import data.TextSegment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import util.ScrollDirection;

import static util.Global.TEXT_FONT;
/**
 * (Insert a brief comment that describes
 * the purpose of this class definition.)
 * <p>
 * <p/> Bugs: None known
 *
 * @author Team Atlantis
 */
public class WelcomePane extends BorderPane
{
    private MarqueeController controller;

    public WelcomePane()
    {
        // Welcome message on marquee without background
        TextSegment welcomeText = new TextSegment();
        welcomeText.setText("Welcome to VISION");
        welcomeText.setScrollDirection(ScrollDirection.LEFT);
        welcomeText.setDuration(10);
        welcomeText.setTextColors(new Color[]{Color.web("#DAF7A6")});
        Message welcomeMessage = new Message();
        welcomeMessage.addSegment(0, welcomeText);
        controller = new MarqueeController(welcomeMessage);
        this.setCenter(controller.getPreviewMarqueePane());

        // Start message at the bottom of the screen
        Label startLabel = new Label("Click anywhere to start...");
        startLabel.setFont(new Font(TEXT_FONT, 32));
        startLabel.setMaxWidth(Double.MAX_VALUE);
        startLabel.setAlignment(Pos.CENTER);
        this.setBottom(startLabel);

        this.setPrefSize(640, 480);
        this.setPadding(new Insets(20));
    }

    public void stopMessage()
    {
        controller.stopPreview();
    }
}