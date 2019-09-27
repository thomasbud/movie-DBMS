package project1.antlr4;
import project1.dbms;

public class MyRulesBaseListener extends rulesBaseListener {
    public MyRulesBaseListener() {
        dbms myDbms = new dbms();
    }
    @Override public void exitShow_cmd(rulesParser.Show_cmdContext ctx) {
        System.out.println("SHOW");
    }
}
