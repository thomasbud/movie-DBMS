package project1.antlr4;
//import javafx.scene.Parent;
//import jdk.swing.interop.SwingInterOpUtils;
import project1.dbms;
import org.antlr.v4.runtime.tree.ParseTree;

//import java.io.IOException;
import java.io.IOException;
import java.util.*;

public class MyRulesBaseListener extends rulesBaseListener {
    private dbms myDbms;
    private Deque<String> opQ;

    public MyRulesBaseListener() {
        this.myDbms = new dbms();
        this.opQ = new ArrayDeque<>();
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
    @Override public void enterCreate_cmd(RulesParser.Create_cmdContext ctx) {
        System.out.println("ENTER CREATE TABLE");
    }
      */
    @Override public void exitProduct(rulesParser.ProductContext ctx) {
        System.out.println("------------------ Inside exitProduct ---------------------");
        ParseTree exprNode = ctx;
        System.out.println(exprNode.getText());

        List<String> exprLeaves = new ArrayList<>();
        //List<String> passingLeaves = new ArrayList<>();
        getLeafNodes(exprNode, exprLeaves);
        System.out.println("Expression leaves" + exprLeaves);
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();


        atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);

        System.out.println("----------------------------------------------------");
    }
    @Override
    public void exitCreate_cmd(rulesParser.Create_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        ParseTree second_child = children.get(1);
        String table_name = second_child.getText();
        ParseTree fourthChild = children.get(3);
        List<String> combinedList = new ArrayList<>();
        getLeafNodes(fourthChild, combinedList);
        List<String> attrNames = new ArrayList<>();
        List<String> attrFields = new ArrayList<>();
        for (int i = 0; i < combinedList.size(); i++) {
            if (combinedList.get(i).equals("VARCHAR")) {
                attrFields.add(combinedList.get(i) + "(" + combinedList.get(i + 2) + ")");
                i += 3;
            } else if (combinedList.get(i).equals("INTEGER")) {
                attrFields.add(combinedList.get(i));
            } else {
                attrNames.add(combinedList.get(i));
            }
        }
//        System.out.println(combinedList);
//        System.out.println(attrNames);
//        System.out.println(attrFields);

        // primary key

        ParseTree primeKeyNode = children.get(5);
        List<String> primary_keys = new ArrayList<>();
        getLeafNodes(primeKeyNode, primary_keys);
        myDbms.createTable(table_name, attrNames, attrFields, primary_keys);
        /*
        System.out.println("-----------------------------------------");
        myDbms.print(table_name);
        System.out.println("-----------------------------------------");

         */

    }

    @Override
    public void exitInsert_cmd(rulesParser.Insert_cmdContext ctx) {
        //accounts for inserts in the form of "INSERT INTO relation_name VALUES FROM (,,,)"
        boolean containsValuesFromRelation = false;
        List<ParseTree> children = ctx.children;
        for (ParseTree x : children) {
            if (x.getText().equals("VALUES FROM RELATION")) {

                containsValuesFromRelation = true;
            }
        }
        if (containsValuesFromRelation == false) {
            String tableTitle = children.get(1).getText();
            List<String> values = new ArrayList<>();
            ParseTree thirdChild = children.get(4);
            for (int i = 4; i < ctx.getChildCount(); i += 2) {
                values.add(children.get(i).getText());
            }
            myDbms.insertInto(tableTitle, values);
        }
        else{
            ParseTree exprNode = children.get(3);
            String relName = children.get(1).getText();
            Deque<String> atomicExprOpStack = new ArrayDeque<>();
            Queue<String> atomicExprQueue = new LinkedList<>();
            List<String> exprLeaves = new ArrayList<>();
            getLeafNodes(exprNode, exprLeaves);
            if (exprNode.getChildCount() == 1) {
                String tableName = exprNode.getChild(0).getText();
                myDbms.union(tableName, relName);

            }
            else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
                String tableName = "garbageValue";
                myDbms.union(tableName, relName);
                //myDbms.insert(tableName,relName)
            }
            else {
                String tableName = "garbage";
                atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
                myDbms.union(tableName, relName);

            }
        }
    }

    @Override
    public void exitShow_cmd(rulesParser.Show_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        String tableTitle = children.get(1).getText();
        System.out.println("-----------After Calling SHOW-------------------");
        myDbms.print(tableTitle);
    }
/*
    @Override
    public void exitWrite_cmd(rulesParser.Write_cmdContext ctx) {
        List<ParseTree> children = ctx.children;
        String tableTitle = children.get(1).getText();
        try {
            System.out.println("\n\n-----------After Calling WRITE -------------------");
            myDbms.writetoCSV(tableTitle);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 */
    @Override
    public void exitSelection(rulesParser.SelectionContext ctx) {
        System.out.println("Entered selection");
        ParseTree conditionNode = ctx.children.get(2);
        ParseTree exprNode = ctx.children.get(4);

        Deque<String> conditionOpStack = new ArrayDeque<>();
        Queue<String> conditionQueue = new LinkedList<>();
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();
        List<String> conditionLeaves = new ArrayList<>();
        List<String> exprLeaves = new ArrayList<>();
        getLeafNodes(conditionNode, conditionLeaves);
        getLeafNodes(exprNode, exprLeaves);
        for (String x : exprLeaves) {
            System.out.println("exprLeaves: " + x);
        }
        if (exprNode.getChildCount() == 1) {
            String tableName = exprNode.getChild(0).getText();
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue, opQ, tableName);
            System.out.println("ConditionQueue: " + conditionQueue);
            dbmsSelect(conditionQueue, tableName);
        }
        else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
            String tableName = "garbageValue";
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue, opQ, tableName);
            dbmsSelect(conditionQueue, tableName);
        }
        else {
            String tableName = "garbage";
            atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue, opQ, tableName);
            dbmsSelect(conditionQueue, tableName);
        }
        // Shunting yard algorithm

        // shuntAlg(condition
        //atomicExprShunting(exprLeaves, atomicExprOpStack,atomicExprQueue);

    }


    @Override
    public void exitUnion(rulesParser.UnionContext ctx) {
        System.out.println("------------------ Inside exitUnion ---------------------");
        ParseTree exprNode = ctx;
        System.out.println(exprNode.getText());

        List<String> exprLeaves = new ArrayList<>();
        //List<String> passingLeaves = new ArrayList<>();
        getLeafNodes(exprNode, exprLeaves);
        System.out.println("Expression leaves" + exprLeaves);
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();


        atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);

        System.out.println("----------------------------------------------------");


    }

    private void getLeafNodes(ParseTree node, List<String> leaves) {
        if (node.getChildCount() == 0 && !(node.getText().equals(","))) {
            leaves.add(node.getText());
            return;
        } else {
            for (int i = 0; i < node.getChildCount(); ++i) {
                getLeafNodes(node.getChild(i), leaves);
            }
        }
    }
    private boolean isCombiningOp(String op) {
        return (op.equals("+") || op.equals("-") || op.equals("*"));
    }

    private boolean isConditionOp(String op) {
        return (op.equals(">") || op.equals(">=") || op.equals("<") || op.equals("<=") || op.equals("==") || op.equals("!="));
    }

    private boolean isRelAlgebraOp(String op) {
        return (op.equals("&&") || op.equals("||") || op.equals("(") || op.equals(")"));
    }

    private void atomicExprShunting(List<String> exprLeaves, Deque<String> atomicExprOpStack, Queue<String> atomicExprQueue, Deque<String> opQ) {
        for (String el : exprLeaves) {
            if (!isCombiningOp(el) && !isRelAlgebraOp(el)) {
                atomicExprQueue.add(el);
            } else {
                if (el.equals(")") && (!atomicExprOpStack.peek().equals("("))) {
                    atomicExprQueue.add(atomicExprOpStack.remove());
                } else {
                    atomicExprOpStack.push(el);
                }
            }

        }
        for (String el : atomicExprOpStack) {
            if (!el.equals("(") && !el.equals(")")) {
                atomicExprQueue.add(el);
            }
        }
        System.out.println("atomicExprQueue: " + atomicExprQueue);
        for (String el : atomicExprQueue) {
            opQ.push(el);
            //System.out.println("initial opQ: " + opQ);
            if (el.equals("+")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                //System.out.println(rel1);
                //System.out.println(rel2);
                myDbms.union(rel1, rel2);
//                System.out.println("opQ after remove: " + opQ);
                opQ.push("garbage"); // pushes a garbage value
                //System.out.println("opQ after pushing garbage: " + opQ);
            } else if (el.equals("-")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                //dbms.difference(rel1, rel2)
                opQ.push(UUID.randomUUID().toString()); // pushes a garbage value
            }
            if (el.equals("*")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                myDbms.intersect(rel1, rel2);
                opQ.push("garbage"); // pushes a garbage value
            }

        }
    }

    private void conditionShunting(List<String> conditionLeaves, Deque<String> conditionOpStack, Queue<String> conditionQueue, Deque<String> opQ, String tableName) {
        for (String el : conditionLeaves) {
            if (!isConditionOp(el) && !isRelAlgebraOp(el)) {
                conditionQueue.add(el);
            } else {
                if (conditionOpStack.peek() != null && isConditionOp(conditionOpStack.peek()) && isRelAlgebraOp(el)) {
                    conditionQueue.add(conditionOpStack.remove());
                }
                conditionOpStack.push(el);

            }
        }

        for (String el : conditionOpStack) {
            if (!el.equals("(") && !el.equals(")")) {
                conditionQueue.add(el);
            }
        }
        //System.out.println("conditionQueue: " + conditionQueue);
    }

    private void dbmsSelect(Queue<String> conditionQueue, String tableName) {
        for (String el : conditionQueue) {
            opQ.push(el);
            //System.out.println("initial opQ: " + opQ);
            if (el.equals("==")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String attrValue = opQ.remove();
                String attrName = opQ.remove();
                myDbms.select(tableName, attrName, attrValue, "==");
                opQ.push("garbage"); // pushes a garbage value
                //System.out.println("opQ after pushing garbage: " + opQ);
            }
        }
    }
}
