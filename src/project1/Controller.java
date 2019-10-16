package project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField text1_1;
    @FXML
    TextField text1_2;
    @FXML
    TextField text2_1;
    @FXML
    TextField text3_1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    void display1(ActionEvent event) throws IOException {
        Parent textBox = FXMLLoader.load(getClass().getResource("buttonOne.fxml"));
        Scene newScene = new Scene(textBox);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void display2(ActionEvent event) throws IOException {
        Parent textBox = FXMLLoader.load(getClass().getResource("buttonTwo.fxml"));
        Scene newScene = new Scene(textBox);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    void display3(ActionEvent event) throws IOException {
        Parent textBox = FXMLLoader.load(getClass().getResource("buttonThree.fxml"));
        Scene newScene = new Scene(textBox);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    @FXML
    void handleButton1(ActionEvent event){    //Constellation
        if(text1_1.getText().isEmpty() || text1_2.getText().isEmpty()) {
            System.out.println("Error text field 1 or text field 2 is empty");
        }
        else{
            String input1 = text1_1.getText();
            String input2 = text1_2.getText();
            System.out.println(input1);
            System.out.println(input2);
        }
    }
    @FXML
    void handleButton2(ActionEvent event){    //Typecasting
        if(text2_1.getText().isEmpty()){
            System.out.println("Error text field 1 empty");
        }
        else{
            String input1 = text2_1.getText();
            System.out.println(input1);
        }
    }
    @FXML
    void handleButton3(ActionEvent event){    //Cover Roles
        if(text3_1.getText().isEmpty()){
            System.out.println("Error text field 1 is empty");
        }
        else{
            String input1 = text3_1.getText();
            System.out.println(input1);
        }
    }
}
