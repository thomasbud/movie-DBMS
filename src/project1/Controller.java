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
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import project1.antlr4.MyRulesBaseListener;
import project1.antlr4.rulesLexer;
import project1.antlr4.rulesParser;
import csce315.project1.Credits;
import csce315.project1.Movie;
import csce315.project1.MovieDatabaseParser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    void handleButton3(ActionEvent event) throws IOException {    //Cover Roles
        if(text3_1.getText().isEmpty()){
            System.out.println("Error text field 1 is empty");
        }
        else{
            String input1 = text3_1.getText();
            System.out.println(input1);
            MovieDatabaseParser parser2 = new MovieDatabaseParser();

            List<Movie> moviesList = parser2.deserializeMovies("/Users/engrbundle/Downloads/movies_single.json");
            List<Credits> creditsList = parser2.deserializeCredits("/Users/engrbundle/Downloads/dataJSON2/credits.json");

            //For Query
            List<String> allCharacters = new ArrayList<>();
            List<String> allActors = new ArrayList<>();

            for (Credits el : creditsList){
                for (Credits.CastMember x: el.getCastMember()){
                    String characterName = x.getCharacter().replaceAll(" \\(voice\\)", "").replaceAll(" ", "_").replaceAll("\\.", "");
                    if (Pattern.matches("[a-zA-Z_0-9]*", characterName)){
                        allCharacters.add(characterName);
                    }

                    String actorName = x.getName().replaceAll(" ", "_").replaceAll("\\.", "");

                    if (Pattern.matches("[a-zA-Z_0-9]*", actorName)){
                        allActors.add(actorName);
                    }
                }
            }
//            System.out.println("All Characters: --------------------");
//            for (String el : allCharacters){
//                System.out.println(el);
//            }
//            System.out.println("All Actors: --------------------");
//            for (String el : allActors){
//                System.out.println(el);
//            }

            System.out.println(allActors.size());
            System.out.println(allCharacters.size());

            List<String> lines = new ArrayList<>();

            lines.add("CREATE TABLE ActorsAndChars (actor VARCHAR(30), character VARCHAR(30)) PRIMARY KEY (actor, character)");
            for (int i = 0; i < allCharacters.size(); i++){
                //System.out.println("INSERT INTO ActorsAndChars VALUES FROM (\"" + allActors.get(i) + "\", \"" + allCharacters.get(i) + "\")");
                lines.add("INSERT INTO ActorsAndChars VALUES FROM (\"" + allActors.get(i) + "\", \"" + allCharacters.get(i) + "\")");
            }

            //lines.add("SHOW ActorsAndChars");
            //Project (actor) (select (character == “name”) credits_table

            lines.add("a <- project (actor) (select (character == \"" + input1+ "\") ActorsAndChars");

            lines.add("SHOW a");

            //System.out.println(lines);
            MyRulesBaseListener listener = new MyRulesBaseListener();
            for (String line : lines) {
                CharStream charStream = CharStreams.fromString(line);
                rulesLexer lexer = new rulesLexer(charStream);
                CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
                rulesParser parser = new rulesParser(commonTokenStream);
                lexer.removeErrorListeners();
                parser.removeErrorListeners();
                rulesParser.ProgramContext programContext = parser.program();
                ParseTreeWalker walker = new ParseTreeWalker();
                walker.walk((ParseTreeListener) listener, programContext);
            }
        }
    }
}
