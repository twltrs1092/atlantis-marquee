package gui;

import data.Segment;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import util.*;

import static util.Global.TEXT_FONT;

public abstract class SegmentPane extends BorderPane
{
    private Segment segment;

    protected RadioButton statikRadioBtn, scrollRadioBtn, effectsRadioBtn;
    private ComboBox<EntranceEffect> entranceComboBox;
    protected ComboBox<MiddleEffect> middleComboBox;
    private ComboBox<ExitEffect> exitComboBox;
    protected ComboBox<ScrollDirection> scrollComboBox;
    private Button continueButton;
    private Button cancelButton;

    protected Label titleLabel, durationLabel, repeatLabel, delayLabel;
    protected TextField durationTextField, repeatTextField, delayTextField;

    public SegmentPane(Segment segment)
    {
        this.segment = segment;

        // Take the focus off of the active node if the dead space is clicked
        this.setOnMouseClicked(e -> requestFocus());

        titleLabel = new Label("Segment Settings");
        titleLabel.setFont(new Font("Helvetica", 32));
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setStyle("-fx-border-color: black;-fx-border-style: solid;-fx-font-weight: bold;-fx-border-width: 5px;-fx-padding:3");

        // Create a preview marquee below the title that executes when a preview button is clicked
        MarqueeController controller = new MarqueeController(segment, false);
        MarqueePane marqueePane = controller.getPreviewMarqueePane();
        marqueePane.setStyle("-fx-border-color: white;");
        Button previewButton = new Button("Preview");
        previewButton.setFont(new Font(TEXT_FONT, 25));
        previewButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        previewButton.setOnAction(e ->
        {
            if (segment.isValid())
            {
                controller.preview();
            }
        });

        HBox.setHgrow(previewButton, Priority.ALWAYS);
        HBox marqueeBox = new HBox(marqueePane, previewButton);
        marqueeBox.setSpacing(5);
        VBox topBox = new VBox(titleLabel, marqueeBox);
        topBox.setSpacing(10);
        this.setTop(topBox);

        /*Setting TextSegmentPane Size and Padding*/
        //This sets the TextSegment Pane size and padding
        this.setPrefSize(700, 700);
        this.setPadding(new Insets(30));

        durationLabel = new Label("Duration:");
        durationLabel.setFont(new Font(TEXT_FONT, 15));

        durationTextField = new TextField();
        durationTextField.setFont(new Font(TEXT_FONT, 15));
        durationTextField.setMaxWidth(45);
        durationTextField.setTooltip(new Tooltip("How long the marquee will display on the screen"));

        //Setting durationTextField Character Length
        durationTextField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() > oldValue.intValue()){
                if(durationTextField.getText().length() > 3){
                    durationTextField.setText(durationTextField.getText().substring(0,3));
                }
            }
        });

        //Making durationTextField Accept Only Numeric Values
        durationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                durationTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // Set the duration in the segment when the field loses focus
        durationTextField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) // Lost focus
            {
                String durationText = durationTextField.getText();
                segment.setDuration(durationText.isEmpty() ? 0 : Integer.valueOf(durationText));
            }
        }));

        repeatLabel = new Label("Repetitions:");
        repeatLabel.setFont(new Font(TEXT_FONT, 15));

        repeatTextField = new TextField();
        repeatTextField.setFont(new Font(TEXT_FONT, 15));
        repeatTextField.setMaxWidth(45);
        repeatTextField.setTooltip(new Tooltip("How fast the marquee contents will scroll across the screen"));

        //Setting repeatTextField Character Length
        repeatTextField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() > oldValue.intValue()){
                if(repeatTextField.getText().length() > 3){
                    repeatTextField.setText(repeatTextField.getText().substring(0,3));
                }
            }
        });

        //Making repeatTextField Accept Only Numeric Values
        repeatTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                repeatTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // Set the repeat factor in the segment when the field loses focus
        repeatTextField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) // Lost focus
            {
                String repeatText = repeatTextField.getText();
                segment.setRepeat(repeatText.isEmpty() ? 0 : Integer.valueOf(repeatText));
            }
        }));

        delayLabel = new Label("Delay (segment):");
        delayLabel.setFont(new Font(TEXT_FONT, 15));

        delayTextField = new TextField();
        delayTextField.setFont(new Font(TEXT_FONT, 15));
        delayTextField.setMaxWidth(45);
        delayTextField.setTooltip(new Tooltip("The delay between repetitions of this segment"));

        //Setting delayTextField Character Length
        delayTextField.lengthProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intValue() > oldValue.intValue()){
                if(delayTextField.getText().length() > 3){
                    delayTextField.setText(delayTextField.getText().substring(0,3));
                }
            }
        });

        //Making delayTextField Accept Only Numeric Values
        delayTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                delayTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        // Set the delay in the segment when the field loses focus
        delayTextField.focusedProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue) // Lost focus
            {
                String delayText = delayTextField.getText();
                segment.setDelay(delayText.isEmpty() ? 0 : Integer.valueOf(delayText));
            }
        }));

        /*Adding Creating Buttons and Setting Font/Size*/
        continueButton = new Button("Continue");
        cancelButton = new Button("Cancel");

        //Setting Font
        continueButton.setFont(new Font(TEXT_FONT, 15));
        cancelButton.setFont(new Font(TEXT_FONT, 15));

        //Setting Height
        cancelButton.setPrefHeight(40);
        continueButton.setPrefHeight(40);

        //Setting buttons width
        continueButton.setPrefWidth(200);
        cancelButton.setPrefWidth(200);

        HBox buttonsBox = new HBox(continueButton, cancelButton);
        buttonsBox.setSpacing(10);
        buttonsBox.setAlignment(Pos.CENTER);
        this.setBottom(buttonsBox);

        statikRadioBtn = new RadioButton("Static");
        scrollRadioBtn = new RadioButton("Continuous Scroll");
        effectsRadioBtn = new RadioButton("Effects");

        //Creating Toggle Group For Radio Button
        ToggleGroup group = new ToggleGroup();
        statikRadioBtn.setToggleGroup(group);
        statikRadioBtn.setSelected(true);
        scrollRadioBtn.setToggleGroup(group);
        effectsRadioBtn.setToggleGroup(group);

        scrollComboBox = new ComboBox<>();
        scrollComboBox.setEditable(false);
        scrollComboBox.getItems().addAll(ScrollDirection.LEFT, ScrollDirection.RIGHT, ScrollDirection.UP, ScrollDirection.DOWN);
        scrollComboBox.getSelectionModel().selectFirst();
        VBox scrollVBox = new VBox(scrollComboBox);
        scrollVBox.visibleProperty().bindBidirectional(scrollVBox.managedProperty());
        scrollVBox.visibleProperty().bind(scrollRadioBtn.selectedProperty());
        scrollVBox.setStyle("-fx-padding: 15");

        entranceComboBox = new ComboBox<>();
        middleComboBox = new ComboBox<>();
        exitComboBox = new ComboBox<>();

        //Adding ComboBox contents
        entranceComboBox.getItems().addAll(EntranceTransition.values());
        entranceComboBox.getItems().addAll(ScrollEffect.values());
        entranceComboBox.getItems().addAll(scrollComboBox.getItems());
        entranceComboBox.setEditable(false);
        entranceComboBox.getSelectionModel().selectFirst();
        middleComboBox.getItems().addAll(MiddleEffect.NONE, MiddleEffect.BLINK, MiddleEffect.INVERT);
        middleComboBox.setEditable(false);
        middleComboBox.getSelectionModel().selectFirst();
        exitComboBox.getItems().addAll(ExitTransition.values());
        exitComboBox.getItems().addAll(ScrollEffect.values());
        exitComboBox.getItems().addAll(scrollComboBox.getItems());
        exitComboBox.setEditable(false);
        exitComboBox.getSelectionModel().selectFirst();

        VBox effectsVBox = new VBox(entranceComboBox, middleComboBox, exitComboBox);
        effectsVBox.visibleProperty().bindBidirectional(effectsVBox.managedProperty());
        effectsVBox.visibleProperty().bind(effectsRadioBtn.selectedProperty());
        effectsVBox.setSpacing(5);
        effectsVBox.setPadding(new Insets(5));

        // Set the scroll direction to STATIC and remove effects if "static" is chosen
        statikRadioBtn.setOnAction(e -> {
            segment.setScrollDirection(ScrollDirection.STATIC);
            resetEffects();
        });

        // Set the scroll direction to the initial direction and remove effects if "scroll" is chosen
        scrollRadioBtn.setOnAction(e -> {
            segment.setScrollDirection(scrollComboBox.getValue());
            resetEffects();
        });

        // Set the scroll direction if the direction is changed
        scrollComboBox.setOnAction(e -> segment.setScrollDirection(scrollComboBox.getValue()));

        // Set the scroll direction to STATIC if "effects" is chosen
        effectsRadioBtn.setOnAction(e -> segment.setScrollDirection(ScrollDirection.STATIC));

        // Set the effects as changed if "effects" is chosen
        entranceComboBox.setOnAction(e -> segment.setEntranceEffect(entranceComboBox.getValue()));
        middleComboBox.setOnAction(e -> segment.setMiddleEffect(middleComboBox.getValue()));
        exitComboBox.setOnAction(e -> segment.setExitEffect(exitComboBox.getValue()));
        
        //Setting SegmentRadio/ComboBox Button Prompters
        statikRadioBtn.setTooltip(new Tooltip("The Sets The Marquee Display To Default Settings"));
        scrollRadioBtn.setTooltip(new Tooltip("This Sets Marquee Scroll Direction"));
        effectsRadioBtn.setTooltip(new Tooltip("This Adds Special Effects To The Marquee's Intro/Exit Screen Display"));
        entranceComboBox.setTooltip(new Tooltip("This Sets The Entrance Effects For The Marquee's Display"));
        middleComboBox.setTooltip(new Tooltip("This Sets The Static Effects For The Marquee's Display"));
        exitComboBox.setTooltip(new Tooltip("This Sets The Exit Effects For The Marquee's Display"));

        //HBox
        HBox radioBox = new HBox(statikRadioBtn, scrollRadioBtn, effectsRadioBtn);
        radioBox.setStyle("-fx-padding: 10");
        radioBox.setSpacing(5);

        this.setRight(new VBox(new HBox(radioBox), scrollVBox, effectsVBox));

        /*CSS*/
        this.getStylesheets().add("VisionStyleSheet.css");
    }

    public Segment getSegment()
    {
        return segment;
    }

    public Button getContinueButton(){
        return continueButton;
    }

    public Button getCancelButton(){
        return cancelButton;
    }

    // Fill in the pane's cells with information from the given segment (for segment editing)
    protected void populate()
    {
        durationTextField.setText(String.valueOf((int) segment.getDuration()));
        repeatTextField.setText(String.valueOf(segment.getRepeat()));
        delayTextField.setText(String.valueOf(segment.getDelay()));

        // Set display type radio button choice
        if (segment.getScrollDirection() != ScrollDirection.STATIC)
        {
            scrollRadioBtn.setSelected(true);
            scrollComboBox.getSelectionModel().select(segment.getScrollDirection());
        }
        else if (segment.getEntranceEffect() == EntranceTransition.NONE
                    && segment.getMiddleEffect() == MiddleEffect.NONE
                    && segment.getExitEffect() == ExitTransition.NONE)
        {
            statikRadioBtn.setSelected(true);
        }
        else
        {
            effectsRadioBtn.setSelected(true);
            entranceComboBox.getSelectionModel().select(segment.getEntranceEffect());
            middleComboBox.getSelectionModel().select(segment.getMiddleEffect());
            exitComboBox.getSelectionModel().select(segment.getExitEffect());
        }
    }

    // Display warnings for all fields which are invalid
    protected void warn()
    {
        System.out.println("INVALID SEGMENT");
    }

    // Reset the selected effects to the first option ("NONE")
    private void resetEffects()
    {
        entranceComboBox.getSelectionModel().selectFirst();
        middleComboBox.getSelectionModel().selectFirst();
        exitComboBox.getSelectionModel().selectFirst();
    }
}
