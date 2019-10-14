package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csce315.project1.Credits;
import csce315.project1.Movie;
import csce315.project1.MovieDatabaseParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import project1.antlr4.MyRulesBaseListener;
import project1.antlr4.rulesLexer;
import project1.antlr4.rulesParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Main {
    public static void main(String[] args) throws IOException {


        MovieDatabaseParser parser2 = new MovieDatabaseParser();

        List<Movie> moviesList = parser2.deserializeMovies("C:/Users/sidds/Downloads/movies_single.json");
        List<Credits> creditsList = parser2.deserializeCredits("C:/Users/sidds/Downloads/credits_single.json");

        Movie movie = moviesList.get(0);
        Credits credits = creditsList.get(0);

        System.out.println("Is it an adult film? ");
        System.out.println(movie.getAdult());
        System.out.println();

        System.out.println("What language was the movie in?");
        System.out.println(movie.getSpoken_languages().get(0).getName());



/*

        File file = new File("src/project1/input.txt");
        Scanner scanner = new Scanner(file);
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.length() != 0) {
                lines.add(line);
            }

        }
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

 */
    }
}