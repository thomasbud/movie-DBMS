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
import project1.antlr4.MyRulesBaseListener;
import project1.dbms;
import csce315.project1.Credits;
import csce315.project1.Movie;
import csce315.project1.MovieDatabaseParser;

import java.io.IOException;
import java.net.URL;
import java.util.*;
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
    void handleButton2(ActionEvent event) throws IOException {    //Typecasting
        if(text2_1.getText().isEmpty()){
            System.out.println("Error text field 1 empty");
        }
        else{
            String input1 = text2_1.getText();
            System.out.println(input1);
            MovieDatabaseParser parser2 = new MovieDatabaseParser();
            List<Movie> moviesList = parser2.deserializeMovies("C:\\Users\\sidds\\Desktop\\movie_data\\dataJSON\\movies.json");
            List<Credits> creditsList = parser2.deserializeCredits("C:\\Users\\sidds\\Desktop\\movie_data\\dataJSON\\credits.json");
            List<Integer> id_list = new ArrayList<>();
            Map<String, Integer> genreList = new HashMap<String,Integer>();
            for(int i = 0; i < creditsList.size();i++){
                for(int j = 0; j < creditsList.get(i).getCastMember().size();j++){
                    if(creditsList.get(i).getCastMember().get(j).getName().equals(input1)){
                        id_list.add(Integer.parseInt(creditsList.get(i).getId()));
                    }
                }
            }
            if(id_list.size() == 0){
                System.out.println("The input you entered did not match any results");
            }
            else{
                int pos = 0;
                for(int k = 0; k < moviesList.size();k++){
                    if(moviesList.get(k).getId() == id_list.get(pos)){
                        pos++;
                        int genreObjectSize = moviesList.get(k).getGenres().size();
                        for(int m = 0; m < genreObjectSize; m++){
                            String genre = moviesList.get(k).getGenres().get(m).getName();
                            if(genreList.containsKey(genre)){
                                int index = genreList.get(genre);
                                genreList.put(genre, genreList.get(genre) + 1);
                            }
                            else{
                                genreList.put(genre,0);
                            }
                        }
                    }
                }
                int freq = 0;
                String answer = "";
                for(Map.Entry<String,Integer> entry: genreList.entrySet()){
                    String genre = entry.getKey();
                    Integer genre_freq = entry.getValue();
                    if(genre_freq > freq){
                        freq = genre_freq;
                        answer = genre;
                    }
                }
                System.out.println("The most common genre is " + answer + " and the frequency is " + freq);

            }
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
                    String actorName = x.getName().replaceAll(" ", "_").replaceAll("\\.", "").replaceAll("'", "");
                    if (Pattern.matches("[a-zA-Z_0-9]*", characterName) && Pattern.matches("[a-zA-Z_0-9]*", actorName)){
                        allCharacters.add(characterName);
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

           //System.out.println(allActors.size());
            //System.out.println(allCharacters.size());

            List<String> lines = new ArrayList<>();

            lines.add("CREATE TABLE ActorsAndChars (actor VARCHAR(30), character VARCHAR(30)) PRIMARY KEY (actor, character)");
            for (int i = 0; i < allCharacters.size(); i++){
                //System.out.println("INSERT INTO ActorsAndChars VALUES FROM (\"" + allActors.get(i) + "\", \"" + allCharacters.get(i) + "\")");
                lines.add("INSERT INTO ActorsAndChars VALUES FROM (\"" + allActors.get(i) + "\", \"" + allCharacters.get(i) + "\")");
            }

            //lines.add("SHOW ActorsAndChars");
            //Project (actor) (select (character == “name”) credits_table

            lines.add("a <- (project (actor) (select (character == \"" + input1 + "\") ActorsAndChars))");

            //lines.add("SHOW a");


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

            List<List<String>> Hullo = MyRulesBaseListener.myDbms.getTable("a");
            System.out.println(Hullo);
            String output = "";
            for (int i = 0; i < Hullo.size(); i++){
                output += output + Hullo.get(i).get(0) + ", ";
            }
            output = output.substring(0, output.length()-2).replaceAll("\"", "");
            System.out.println(output);
        }
    }
}
