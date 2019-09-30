package project1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import project1.antlr4.MyRulesBaseListener;
import project1.antlr4.rulesLexer;
import project1.antlr4.rulesParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
            walker.walk(listener, programContext);
        }
    }
}
