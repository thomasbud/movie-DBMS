package project1.antlr4;
import project1.dbms;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class MyRulesBaseListener extends rulesBaseListener{
    public MyRulesBaseListener() {
        dbms mydbms = new dbms();
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

    @Override public void exitCreate_cmd(rulesParser.Create_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        ParseTree second_child = children.get(1);
        String table_name = second_child.getText();
        ParseTree fourthChild = children.get(3);
        String table_fields = fourthChild.getText();
        ParseTree sixthChild = children.get(5);
        String primary_key = sixthChild.getText();
        //dbms.createTable(table_name,table_fields,primary_key)
    }
    @Override public void exitInsert_cmd(rulesParser.Insert_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        String line = "";
//        ParseTree x = children.get(0);
//        ParseTree x = children.get(0);
//        System.out.println( x.get(children.size()-1));
        for (ParseTree x : children){
            line += x.getText() + " ";
        }
        //System.out.println(line);
        String tableName = children.get(1).getText();
        boolean insertTypeRel = false;
        if (line.contains("RELATION")){
            insertTypeRel = true;
        }
        System.out.println("insertTypeRel: " + insertTypeRel);
        if (insertTypeRel){
            String expr =  children.get(children.size()-1).getChild(0).getChild(0).getText();
            System.out.println("expr: " + expr);
            switch(expr) {
                case "project":
                    // shunting algorithm here!
                    String attrList =  children.get(children.size()-1).getChild(0).getChild(2).getText();
                    System.out.println("attrList: " + attrList);
                    // dbms.insertProject(table_name, attrList);
                    // code block
                    break;
                case "select":
                    String condition = children.get(children.size()-1).getChild(0).getChild(2).getText();
                    //dbms
                    break;

                    default:
                    break;
            }

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
