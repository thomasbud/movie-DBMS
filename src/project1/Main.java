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
        dbms d = new dbms();
        List<String> attName = new ArrayList<String>();
        attName.add("Species");
        List<String> attType = new ArrayList<String>();
        attType.add("String");
        List<Integer> attLen = new ArrayList<Integer>();
        attLen.add(10);
        List<String> attKeys = new ArrayList();
        attKeys.add("Species");

        d.createTable("Animal", attName, attType, attLen, attKeys);

        List<String> one = new ArrayList<String>();
        one.add("Monkey");
        d.insertInto("Animal", one);

        d.print("Animal");




        d.createTable("Brown", attName, attType, attLen, attKeys);

        List<String> two = new ArrayList<String>();
        two.add("Ape");
        d.insertInto("Brown", two);

        d.print("Brown");






        d.union("Animal", "Brown");


    }
}