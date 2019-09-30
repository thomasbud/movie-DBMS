package project1.antlr4;
import org.antlr.v4.runtime.tree.ParseTree;
import project1.Dbms;

import java.sql.SQLOutput;
import java.util.List;

public class MyRulesBaseListener extends RulesBaseListener {
    public MyRulesBaseListener() {
        Dbms myDbms = new Dbms();
    }
    /*
    @Override public void enterShow_cmd(RulesParser.Show_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        System.out.println("ENTER SHOW");
    }
    @Override public void exitShow_cmd(RulesParser.Show_cmdContext ctx) {
        System.out.println("EXIT SHOW");
    }
    @Override public void enterInsert_cmd(RulesParser.Insert_cmdContext ctx) {
        System.out.println("ENTER INSERT INTO");
    }
    @Override public void exitInsert_cmd(RulesParser.Insert_cmdContext ctx) {
        System.out.println("EXIT INSERT INTO");
    }
    @Override public void enterCreate_cmd(RulesParser.Create_cmdContext ctx) {
        System.out.println("ENTER CREATE TABLE");
    }
    */

    @Override public void exitCreate_cmd(RulesParser.Create_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        ParseTree second_child = children.get(1);
        String table_name = second_child.getText();
        ParseTree fourthChild = children.get(3);
        String table_fields = fourthChild.getText();
        ParseTree sixthChild = children.get(5);
        String primary_key = sixthChild.getText();
        //dbms.createTable(table_name,table_fields,primary_key)
    }
    @Override public void exitInsert_cmd(RulesParser.Insert_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        String line = "";

        for(ParseTree x :children){

                System.out.println( x.getText());

        }

        //ParseTree second_child = children.get(1);
        //String table_name = second_child.getText();
        //ParseTree sixth_child = children.get(5);
        //String values = sixth_child.getText();
        //System.out.println("table_name: " + table_name);
        //System.out.println("values: " + values);
        System.out.println("\n\n");
        //dbms.insertInto(table_name,values)
    }

    /*
    @Override public void enterProgram(RulesParser.ProgramContext ctx) {
        System.out.println("ENTER PROGRAM");
    }
    @Override public void exitProgram(RulesParser.ProgramContext ctx) {
        System.out.println("EXIT PROGRAM");
    }
    */

}