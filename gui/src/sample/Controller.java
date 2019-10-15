package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;

import java.awt.*;

public class Controller {

    public Button button1;
    public Button button2;
    public Button button3;
    public TextField text_field_1;
    public TextField text_field_2;
    public void handleButtonClick(){
        text_field_1.setOpacity(1);
        text_field_2.setOpacity(1);
    }
}
