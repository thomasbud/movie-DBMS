package project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    @FXML
    Label label_one;
    @FXML
    Label label_two;
    @FXML
    TextArea label_three;
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
            label_one.setText("Hullo");
        }
    }
    @FXML
    void handleButton2(ActionEvent event) throws IOException {    //Typecasting
        if(text2_1.getText().isEmpty()){
            System.out.println("Error text field 1 empty");
        }
        else{
            List<String> lines = new ArrayList<>();
            lines.add("CREATE TABLE ActorTable (cast_id INTEGER, actor VARCHAR(30)) PRIMARY KEY (cast_id, actor)");
            lines.add("CREATE TABLE MovieTable (movie_id INTEGER, genre VARCHAR(30)) PRIMARY KEY (movie_id, genre)");
            String input1 = text2_1.getText();
            MovieDatabaseParser parser2 = new MovieDatabaseParser();
            List<Movie> moviesList = parser2.deserializeMovies("C:\\Users\\sidds\\Desktop\\movie_data\\dataJSON\\movies.json");
            List<Credits> creditsList = parser2.deserializeCredits("C:\\Users\\sidds\\Desktop\\movie_data\\dataJSON\\credits.json");
            List<String> allActors = new ArrayList<>();
            List<Integer> allcIds = new ArrayList<>();
            List<Integer> allmIds = new ArrayList<>();
            for(int i = 0; i < 20;i++){
                allcIds.add(Integer.parseInt(creditsList.get(i).getId()));
                for(int j = 0; j < creditsList.get(i).getCastMember().size(); j++){
                    String actorName = creditsList.get(i).getCastMember().get(j).getName().replaceAll(" ", "_").replaceAll("\\.", "").replaceAll("'", "");
                    if (Pattern.matches("[a-zA-Z_0-9]*", actorName)){
                        lines.add("INSERT INTO ActorTable VALUES FROM (" +  allcIds.get(i)  + ", \"" + actorName + "\")");
                    }
                }
            }
            for(int m = 0; m < 20; m++){
                for(int n = 0; n < moviesList.get(m).getGenres().size();n++) {
                    //System.out.println(moviesList.get(m).getGenres().get(n).getName());
                    //System.out.println(moviesList.get(m).getId());
                    lines.add("INSERT INTO MovieTable VALUES FROM (" +  moviesList.get(m).getId() + ", \"" + moviesList.get(m).getGenres().get(n).getName() + "\")");
                }
            }
            //lines.add("SHOW ActorTable");
            //lines.add("SHOW MovieTable");
            lines.add("temp <- select (actor == \"" + input1 +  "\") ActorTable");
            //lines.add("SHOW temp");
            lines.add("temp2 <- MovieTable * temp");
            lines.add("resultTable <- select (movie_id == cast_id) temp2");
            lines.add("SHOW resultTable");
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
            Map<String, Integer> genreList = new HashMap<String,Integer>();
            String genre = "";
            int index = 0;
            List<List<String>> resultTable = MyRulesBaseListener.myDbms.getTable("resultTable");
            for(int w = 0; w < resultTable.size();w++){
                genre = resultTable.get(w).get(1);
                if(genreList.containsKey(genre)){
                    index = genreList.get(genre);
                    genreList.put(genre, genreList.get(genre) + 1);
                }
                else{
                    genreList.put(genre,1);
                }
            }
            int freq = 0;
            String answer = "";
            for(Map.Entry<String,Integer> entry: genreList.entrySet()){
                String genre_name = entry.getKey();
                Integer genre_freq = entry.getValue();
                if(genre_freq > freq){
                    freq = genre_freq;
                    answer = genre_name;
                }
            }
            System.out.println("The most common genre is " + answer + " and the frequency is " + freq);
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

            //List<Movie> moviesList = parser2.deserializeMovies("/Users/engrbundle/Downloads/movies_single.json");
            List<Credits> creditsList = parser2.deserializeCredits("C:\\Users\\sidds\\Desktop\\movie_data\\dataJSON\\credits.json");

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
            //String output = "";
            for (int i = 0; i < Hullo.size(); i++){
                label_three.setText(label_three.getText() + Hullo.get(i).get(0) + "\n");
            }
            //System.out.println(output);
//            output = output.substring(0, output.length()-2).replaceAll("\"", "");
//            label_three.setText(output);
//            System.out.println(output);
        }
    }
}
