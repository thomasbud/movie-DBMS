package project1.antlr4;
import project1.Dbms;

import java.sql.SQLOutput;

public class MyRulesBaseListener extends RulesBaseListener {
    public MyRulesBaseListener() {
        Dbms myDbms = new Dbms();
    }
    @Override public void enterShow_cmd(RulesParser.Show_cmdContext ctx) {
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
    @Override public void exitCreate_cmd(RulesParser.Create_cmdContext ctx) {
        System.out.println("EXIT CREATE TABLE");
    }
    @Override public void enterProgram(RulesParser.ProgramContext ctx) {
        System.out.println("ENTER PROGRAM");
    }
    @Override public void exitProgram(RulesParser.ProgramContext ctx) {
        System.out.println("EXIT PROGRAM");
    }
}
