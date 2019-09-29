package project1.antlr4;
import project1.dbms;

public class MyRulesBaseListener extends RulesBaseListener {
    public MyRulesBaseListener() {
        dbms myDbms = new dbms();
    }
    @Override public void exitShow_cmd(RulesParser.Show_cmdContext ctx) {
        System.out.println("SHOW");
    }
}
