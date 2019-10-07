package project1.antlr4;
//import javafx.scene.Parent;
//import jdk.swing.interop.SwingInterOpUtils;
import project1.dbms;
import org.antlr.v4.runtime.tree.ParseTree;

//import java.io.IOException;
import java.io.IOException;
import java.io.StringBufferInputStream;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

public class MyRulesBaseListener extends rulesBaseListener {
    private dbms myDbms;
    private Deque<String> opQ;

    public MyRulesBaseListener() {
        this.myDbms = new dbms();
        this.opQ = new ArrayDeque<>();
    }

    @Override public void exitRenaming(rulesParser.RenamingContext ctx) {
        //System.out.println("---------------- exit renaming ---------------");
        ParseTree exprNode = ctx.children.get(4);
        List<ParseTree> children = ctx.children;
        //System.out.println(children.get(0).getText());
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();
        List<String> exprLeaves = new ArrayList<>();
        getLeafNodes(exprNode, exprLeaves);
        //System.out.println("This is the expr leaves " + exprLeaves);
        List<String> values = new ArrayList<>();
        int i = 2;
        values = Arrays.asList(children.get(2).getText().split(","));
//        while (!children.get(i).getText().equals(")")){
//            if (!children.get(i).getText().equals(",")){
//                values.add(children.get(i).getText());
//            }
//            i++;
//        }
        if (exprNode.getChildCount() == 1) {
            String tableName = exprNode.getChild(0).getText();
            myDbms.rename(tableName, values);
        }
        else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
            String tableName = "garbageValue";
            myDbms.rename(tableName, values);
        }
        else {
            String tableName = "garbageTanal";
            atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
            myDbms.rename(tableName, values);
        }
    }
    @Override public void exitDelete_cmd(rulesParser.Delete_cmdContext ctx) {
        //System.out.println("--------------- exit delete -------------------");
        List<ParseTree> children = ctx.children;
        String tableName = children.get(1).getText();
        ParseTree condNode = children.get(4);
        List<String> condLeaves = new ArrayList<>();
        getLeafNodes(condNode, condLeaves);
        Deque<String> conditionOpStack = new ArrayDeque<>();
        Queue<String> conditionQueue = new LinkedList<>();
        conditionShunting(condLeaves, conditionOpStack, conditionQueue);
        dbmsSelect(conditionQueue, tableName);

        myDbms.deleteFrom(tableName);
    }
    @Override public void exitQuery(rulesParser.QueryContext ctx) {
        //System.out.println("------------- exit Query ---------------");
        List<ParseTree> children = ctx.children;
        String tableName = children.get(0).getText();
        myDbms.createQueryTable(tableName);
    }
    @Override public void exitDifference(rulesParser.DifferenceContext ctx) {
        ParseTree exprNode1 = ctx.children.get(0);
        ParseTree exprNode2 = ctx.children.get(2);
        //System.out.println(exprNode1.getText());

        List<String> expr1Leaves = new ArrayList<>();
        List<String> expr2Leaves = new ArrayList<>();
        //List<String> passingLeaves = new ArrayList<>();
        getLeafNodes(exprNode1, expr1Leaves);
        getLeafNodes(exprNode2, expr2Leaves);
        //System.out.println("Expression 1 leaves " + expr1Leaves);
        //System.out.println("Expression 2 leaves " + expr2Leaves);
        Deque<String> atomicExpr1OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr1Queue = new LinkedList<>();
        Deque<String> atomicExpr2OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr2Queue = new LinkedList<>();
        //System.out.println("expr1Leaves.size : " + expr1Leaves.size());
        //System.out.println(expr2Leaves.contains("select"));
        if ( (exprNode1.getChildCount() == 1) && (exprNode2.getChildCount() == 1)){
            myDbms.difference(exprNode1.getChild(0).getText(), exprNode2.getChild(0).getText());

        }
        else if ((expr1Leaves.size() == 1) && (expr2Leaves.contains("select") || expr2Leaves.contains("project") || expr2Leaves.contains("rename"))) {
            String tableName = exprNode1.getChild(0).getText();
            //System.out.println("inputting the garbage tanal");
            myDbms.difference(tableName, "garbageTanalll");
        }
        else {
            atomicExprShunting(expr2Leaves, atomicExpr2OpStack, atomicExpr2Queue, opQ);
        }
    }
    @Override public void exitProduct(rulesParser.ProductContext ctx) {
        //System.out.println("------------------ Inside exitProduct ---------------------");
        ParseTree exprNode1 = ctx.children.get(0);
        ParseTree exprNode2 = ctx.children.get(2);
        //System.out.println(exprNode1.getText());

        List<String> expr1Leaves = new ArrayList<>();
        List<String> expr2Leaves = new ArrayList<>();
        //List<String> passingLeaves = new ArrayList<>();
        getLeafNodes(exprNode1, expr1Leaves);
        getLeafNodes(exprNode2, expr2Leaves);
        Deque<String> atomicExpr1OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr1Queue = new LinkedList<>();
        Deque<String> atomicExpr2OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr2Queue = new LinkedList<>();
        //System.out.println("expr1Leaves.size : " + expr1Leaves.size());
        //System.out.println(expr2Leaves.contains("select"));
        if ( (exprNode1.getChildCount() == 1) && (exprNode2.getChildCount() == 1)){
            myDbms.product(exprNode1.getChild(0).getText(), exprNode2.getChild(0).getText());

        }
        else if ((expr1Leaves.size() == 1) && (expr2Leaves.contains("select") || expr2Leaves.contains("project") || expr2Leaves.contains("rename"))) {
            String tableName = exprNode1.getChild(0).getText();
            //System.out.println("inputting the garbage tanal");
            myDbms.product(tableName, "garbageTanalll");
        }
        else {
            atomicExprShunting(expr2Leaves, atomicExpr2OpStack, atomicExpr2Queue, opQ);
        }

        //System.out.println("----------------------------------------------------");
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

        // primary key
        ParseTree primeKeyNode = children.get(5);
        List<String> primary_keys = new ArrayList<>();
        getLeafNodes(primeKeyNode, primary_keys);
        myDbms.createTable(table_name, attrNames, attrFields, primary_keys);

    }

    @Override
    public void exitInsert_cmd(rulesParser.Insert_cmdContext ctx) {
        //accounts for inserts in the form of "INSERT INTO relation_name VALUES FROM (,,,)"
        //System.out.println("-------------------------- Exit insert command -------------------------------");
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
                myDbms.insertFromRelation(relName, tableName);

            }
            else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
                String tableName = "garbageValue";
                myDbms.insertFromRelation(relName, tableName);
            }
            else {
                String tableName = "garbage";
                atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
                myDbms.insertFromRelation(relName, tableName);

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
    @Override public void exitProjection(rulesParser.ProjectionContext ctx) {
        //System.out.println("------------------- Inside Projection --------------------");
        ParseTree exprNode = ctx.children.get(4);
        List<ParseTree> children = ctx.children;
//        System.out.println(children.get(2).getText());
//        System.out.println(children.get(0).getText());
        Deque<String> atomicExprOpStack = new ArrayDeque<>();
        Queue<String> atomicExprQueue = new LinkedList<>();
        List<String> exprLeaves = new ArrayList<>();
        getLeafNodes(exprNode, exprLeaves);
        //System.out.println("This is the expr leaves " + exprLeaves);
        List<String> values = new ArrayList<>();
        int i = 2;
        values = Arrays.asList(children.get(2).getText().split(","));
        //System.out.println("values in project are " + values);
        if (exprNode.getChildCount() == 1) {
            String tableName = exprNode.getChild(0).getText();
            myDbms.project(tableName, values);
        }
        else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
            String tableName = "garbageValue";
            myDbms.project(tableName, values);
        }
        else {
            String tableName = "garbage";
            atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
            myDbms.project(tableName, values);
        }
    }
    @Override
    public void exitSelection(rulesParser.SelectionContext ctx) {
        //System.out.println("--------------Entered selection------------------");
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
//        for (String x : exprLeaves) {
//            System.out.println("exprLeaves: " + x);
//        }
        if (exprNode.getChildCount() == 1) {
            String tableName = exprNode.getChild(0).getText();
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue);
//            System.out.println("ConditionQueue: " + conditionQueue);
//            System.out.println("condition queue: " + conditionQueue);
//            System.out.println("table Name: " + tableName);
            dbmsSelect(conditionQueue, tableName);
        }
        else if (exprLeaves.contains("select") || exprLeaves.contains("project") || exprLeaves.contains("rename")) {
            String tableName = "garbageValue";
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue);
            dbmsSelect(conditionQueue, tableName);
        }
        else {
            String tableName = "garbage";
            atomicExprShunting(exprLeaves, atomicExprOpStack, atomicExprQueue, opQ);
            conditionShunting(conditionLeaves, conditionOpStack, conditionQueue);
            dbmsSelect(conditionQueue, tableName);
        }

    }

    @Override public void exitUpdate_cmd(rulesParser.Update_cmdContext ctx) {
        //System.out.println("------------------ Inside exitUpdate ---------------------");
        List<String> leaves = new ArrayList<>();
        ParseTree condNode = ctx.children.get(ctx.children.size()-2);
        List<String> condLeaves = new ArrayList<>();
        getLeafNodes(condNode, condLeaves);
        getLeafNodes(ctx, leaves);
        String relName = leaves.get(1);
        List<String> attrNames = new ArrayList<>();
        List<String> valNames = new ArrayList<>();
        int i = 3;
        while (!leaves.get(i).equals("WHERE")){
            if (!leaves.get(i).equals(",") && !leaves.get(i).contains("\"") && !leaves.get(i).equals("=") && !isNumeric(leaves.get(i))){
                attrNames.add(leaves.get(i));
            }
            else if (!leaves.get(i).equals(",") && !leaves.get(i).equals("=")){
                valNames.add(leaves.get(i));
            }
            i++;
        }
        //System.out.println("attrNames " + attrNames);
        //System.out.println("valNames " + valNames);
        Deque<String> conditionOpStack = new ArrayDeque<>();
        Queue<String> conditionQueue = new LinkedList<>();
        conditionShunting(condLeaves, conditionOpStack, conditionQueue);
        dbmsSelect(conditionQueue, relName);
        myDbms.update(relName, attrNames, valNames);
    }

    @Override
    public void exitUnion(rulesParser.UnionContext ctx) {
        //System.out.println("------------------ Inside exitUnion ---------------------");
        ParseTree exprNode1 = ctx.children.get(0);
        ParseTree exprNode2 = ctx.children.get(2);
        //System.out.println(exprNode1.getText());

        List<String> expr1Leaves = new ArrayList<>();
        List<String> expr2Leaves = new ArrayList<>();
        //List<String> passingLeaves = new ArrayList<>();
        getLeafNodes(exprNode1, expr1Leaves);
        getLeafNodes(exprNode2, expr2Leaves);
        //System.out.println("Expression 1 leaves " + expr1Leaves);
        //System.out.println("Expression 2 leaves " + expr2Leaves);
        Deque<String> atomicExpr1OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr1Queue = new LinkedList<>();
        Deque<String> atomicExpr2OpStack = new ArrayDeque<>();
        Queue<String> atomicExpr2Queue = new LinkedList<>();
        //System.out.println("expr1Leaves.size : " + expr1Leaves.size());
        //System.out.println(expr2Leaves.contains("select"));
        if ( (exprNode1.getChildCount() == 1) && (exprNode2.getChildCount() == 1)){
            myDbms.union(exprNode1.getChild(0).getText(), exprNode2.getChild(0).getText());

        }
        else if ((expr1Leaves.size() == 1) && (expr2Leaves.contains("select") || expr2Leaves.contains("project") || expr2Leaves.contains("rename"))) {
            String tableName = exprNode1.getChild(0).getText();
           //System.out.println("inputting the garbage tanal");
            myDbms.union(tableName, "garbageTanalll");
        }
        else if (!(expr1Leaves.contains("select") || expr1Leaves.contains("project") || expr1Leaves.contains("rename"))){
            atomicExprShunting(expr1Leaves, atomicExpr1OpStack, atomicExpr1Queue, opQ);
        }
        else {
            atomicExprShunting(expr2Leaves, atomicExpr2OpStack, atomicExpr2Queue, opQ);
        }



        //System.out.println("----------------------------------------------------");


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
        //System.out.println("atomicExprQueue: " + atomicExprQueue);
        for (String el : atomicExprQueue) {
            opQ.push(el);
            //System.out.println("initial opQ: " + opQ);
            if (el.equals("+")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                myDbms.union(rel1, rel2);
                opQ.push("garbage"); // pushes a garbage value
            } else if (el.equals("-")) { //
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                opQ.push(UUID.randomUUID().toString()); // pushes a garbage value
            }
            if (el.equals("*")) {
                // Look at previous two elements in OpQ
                opQ.remove(); // remove +
                String rel1 = opQ.remove();
                String rel2 = opQ.remove();
                //System.out.println("about to call product");
                myDbms.product(rel1, rel2);
                opQ.push("garbage"); // pushes a garbage value
            }

        }
    }

    private void conditionShunting(List<String> conditionLeaves, Deque<String> conditionOpStack, Queue<String> conditionQueue) {
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
        //System.out.println("INSIDE dbms select ------------------------------------------------------------");
        //System.out.println("condition Queue" + conditionQueue);
        for (String el : conditionQueue) {
            opQ.push(el);
            //System.out.println("opQ " + opQ);
            //System.out.println("initial opQ: " + opQ);
            if (el.equals("==") || el.equals("&&") || el.equals("||") || el.equals(">") || el.equals("<") || el.equals("<=") || el.equals(">=") || el.equals("!=")){
                // Look at previous two elements in OpQ
                //System.out.println("inside dbmsSelect --- el: " + el);
                opQ.remove(); // remove +
                String attrValue = opQ.remove();
                String attrName = opQ.remove();
                //System.out.println("attrValue " + attrValue);
                //System.out.println("attrName " + attrName);
                if (!attrValue.contains("\"") && isConditionOp(el) && !isNumeric(attrValue)){

                    myDbms.selectAttr(tableName, attrName, attrValue, el);
                }
                else{
                    myDbms.select(tableName, attrName, attrValue, el);
                }

                opQ.push("garbage"); // pushes a garbage value
                //System.out.println("opQ after pushing garbage: " + opQ);
            }

        }
    }
    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
