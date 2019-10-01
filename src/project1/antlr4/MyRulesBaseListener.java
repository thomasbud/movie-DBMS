package project1.antlr4;
//import javafx.scene.Parent;
import jdk.swing.interop.SwingInterOpUtils;
import project1.dbms;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

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
        //System.out.println("EXIT INSERT");
//        List<ParseTree> children = ctx.children;
//        String line = "";
//        List<String> leaves = new ArrayList<String>();
////        ParseTree x = children.get(0);
////        ParseTree x = children.get(0);
////        System.out.println( x.get(children.size()-1));
//        for (ParseTree x : children){
//            line += x.getText() + " ";
//        }
//
//        //System.out.println(line);
//        String tableName = children.get(1).getText();
//        boolean insertTypeRel = false;
//        if (line.contains("RELATION")){
//            insertTypeRel = true;
//        }
//        System.out.println("insertTypeRel: " + insertTypeRel);
//        if (insertTypeRel){
//            String expr =  children.get(children.size()-1).getChild(0).getChild(0).getText();
//            System.out.println("expr: " + expr);
//            switch(expr) {
//                case "project":
//                    // shunting algorithm here!
//                    ParseTree attrList =  children.get(3).getChild(0).getChild(2);
//                    List<String> attrListLeaves = new ArrayList<>();
//                    getLeafNodes(attrList, attrListLeaves);
////                    for (String el : attrListLeaves){
////                        System.out.println(el);
////                    }
//                    ParseTree atomicExprNode = children.get(3).getChild(0).getChild(4);
//                    List<String> atomicExprLeaves = new ArrayList<>();
//                    getLeafNodes(atomicExprNode, atomicExprLeaves);
//                    // dbms.insertProject(table_name, attrList);
//                    // code block
//                    break;
//                case "select":
//                    ParseTree condition = children.get(children.size()-1).getChild(0).getChild(2);
//                    //dbms
//                    break;
//
//                    default:
//                    break;
//            }
//
//        }

        //ParseTree second_child = children.get(1);
        //String table_name = second_child.getText();
        //ParseTree sixth_child = children.get(5);
        //String values = sixth_child.getText();
        //System.out.println("table_name: " + table_name);
        //System.out.println("values: " + values);
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
    @Override public void exitSelection(rulesParser.SelectionContext ctx) {
        ParseTree conditionNode = ctx.children.get(2);
        ParseTree exprNode = ctx.children.get(4);

        List<String> conditionLeaves = new ArrayList<>();
        List<String> exprLeaves = new ArrayList<>();
        getLeafNodes(conditionNode, conditionLeaves);
        getLeafNodes(exprNode, exprLeaves);
        for (String x: exprLeaves){
            System.out.println("exprLeaves: " + x);
        }

        // Shunting yard algorithm
        Deque<String> conditionOpStack = new ArrayDeque<>();
        Queue<String> conditionQueue = new LinkedList<>();
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();
        // shuntAlg(condition
        conditionShunting(conditionLeaves, conditionOpStack, conditionQueue);
        atomicExprShunting(exprLeaves, atomicExprOpStack,atomicExprQueue);

    }
    private void getLeafNodes(ParseTree node, List<String> leaves){
        if (node.getChildCount() == 0 && !(node.getText().equals(","))){
            leaves.add(node.getText());
            return;
        }
        else {
            for (int i = 0; i < node.getChildCount(); ++i){
                getLeafNodes(node.getChild(i), leaves);
            }
        }
    }
    private boolean isCombiningOp(String op){
        return (op.equals("+") || op.equals("-") || op.equals("*"));
    }

    private boolean isConditionOp(String op){
        return (op.equals(">") || op.equals(">=") || op.equals("<") || op.equals("<=") || op.equals("==")  || op.equals("!="));
    }
    private boolean isRelAlgebraOp(String op){
        return (op.equals("&&") || op.equals("||") || op.equals("(") || op.equals(")"));
    }

    private void atomicExprShunting(List<String> exprLeaves, Deque<String> atomicExprOpStack, Queue<String> atomicExprQueue){
        for (String el : exprLeaves) {
            if (!isCombiningOp(el) && !isRelAlgebraOp(el)){
                atomicExprQueue.add(el);
            } else {
                atomicExprOpStack.push(el);

            }
        }
        for (String el : atomicExprOpStack){
            if (!el.equals("(") && !el.equals(")")){
                atomicExprQueue.add(el);
            }
        }
        System.out.println("atomicExprQueue: " + atomicExprQueue);
    }
    private void conditionShunting(List<String> conditionLeaves, Deque<String> conditionOpStack, Queue<String> conditionQueue){
        for (String el : conditionLeaves){
            if (!isConditionOp(el) && !isRelAlgebraOp(el)){
                conditionQueue.add(el);
            }
            else{
                if (conditionOpStack.peek() != null && isConditionOp(conditionOpStack.peek()) && isRelAlgebraOp(el)){
                    conditionQueue.add(conditionOpStack.remove());
                }
                conditionOpStack.push(el);

            }
        }

        for (String el : conditionOpStack){
            if (!el.equals("(") && !el.equals(")")){
                conditionQueue.add(el);
            }
        }
    }


}
