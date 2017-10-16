package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
/**
 * (Insert a brief comment that describes
 * the purpose of this class definition.)
 * <p>
 * <p/> Bugs: None known
 *
 * @author Team Atlantis
 */
public class AuthPane extends VBox
{
    private Button continueButton;
    private Button cancelButton;

    AuthPane()
    {
        //Creating Authentication Header
        Label titleLabel = new Label("Authentication");
        titleLabel.setFont(new Font("Onyx", 32));
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);
        this.getChildren().add(titleLabel);

        //Creating Password Label
        Label passwordLabel = new Label("Enter Password:");
        passwordLabel.setFont(new Font("Onyx", 20));

        //Creating Password Text Field Label
        TextField passwordTextField = new TextField();
        passwordTextField.setMaxWidth(130);

        //Creating Continue Button
        continueButton = new Button("Continue");
        continueButton.setFont(new Font("Onyx", 20));

        //Creating Cancel Button
        cancelButton = new Button("Cancel");
        cancelButton.setFont(new Font("Onyx", 20));

        //Creating Horizontal Box
        HBox buttons = new HBox(continueButton, cancelButton);
        buttons.setSpacing(5);
        buttons.setAlignment(Pos.CENTER);

        // Global Pane Settings (VBOX)
        this.setPrefSize(200, 150);
        this.setPadding(new Insets(10));
        this.setSpacing(5);
        this.getChildren().addAll(passwordLabel, passwordTextField, buttons);
        this.setAlignment(Pos.CENTER);
    }

    public Button getContinueButton()
    {
        return continueButton;
    }

    public Button getCancelButton()
    {
        return cancelButton;
    }
}