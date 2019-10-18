package project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class dbms {

    private class Table {
        String tableName;
        List<String> attributeName = new ArrayList<String>();
        List<String> attributeType = new ArrayList<String>();
        List<String> primaryKeys = new ArrayList<String>();
        List<List<String>> attributeValues = new ArrayList<List<String>>();

        // constructor
        Table(String tableName, List<String> attributeName, List<String> attributeType, List<String> primaryKeys)
        {
            this.tableName = tableName;
            this.attributeName.addAll(attributeName);
            this.attributeType.addAll(attributeType);
            this.primaryKeys.addAll(primaryKeys);
        }
        Table(){}

        public void insertEntity(List<String> valuesIn)
        {
            //check the conditions later
            attributeValues.add(valuesIn);
        }
    }

    // private members
    private List<Table> tableList = new ArrayList<Table>();
    private List<Table> buffer = new ArrayList<Table>();
    private Table tableForSelect = new Table();

    // public members
    public List<List<String>> getTable(String tableName){
        return tableList.get(findTable(tableName)).attributeValues;
    }
    private int findTable(String tableTitle)
    {
        for(int i = 0; i < tableList.size(); i++)   
        {
            if(tableTitle.equals( tableList.get(i).tableName))
            {
                return i;
            }
        }
        return -1; //will crash the program INTENTIONALLY if we can't find it because it's over at this points
    }

    private Table setTempTable(String tabName)
    {
        int idx = -1;
        Table t;
        for(int i = 0; i < tableList.size(); i++)
        {
            //System.out.println("table list size" + tableList.get(i).tableName);
            if(tabName.equals(tableList.get(i).tableName))
            {
                idx = i;
            }
        }
        if(idx == -1){
            //System.out.println("buffer befor " + buffer.get(0).attributeValues);
            t=buffer.remove(0);
        }
        else
        {
            t=tableList.get(idx);
        }

        return t;
    }

    //specifically for CREATE TABLE command
    public void createTable(String tableName, List<String> attributeName, List<String> attributeType, List<String> primaryKeys)
    {
        tableList.add(new Table(tableName, attributeName, attributeType, primaryKeys));
    }

    public void insertInto(String tableTitle, List<String> valuesIn)
    {
        tableList.get(findTable(tableTitle)).insertEntity(valuesIn);
    }

    public void insertFromRelation(String relName, String tableName){
        if (findTable(tableName) == -1){
            List<List<String>> valuesFromBuffer = buffer.get(0).attributeValues;
            for (List<String> el : valuesFromBuffer){
                this.insertInto(relName, el);
            }
        }
        else{
            List<List<String>> valuesToInsert = tableList.get(findTable(tableName)).attributeValues;
            for (List<String> el : valuesToInsert){
                this.insertInto(relName, el);
            }
        }
    }
    public void project(String tableName, List<String> attributes)
    {
        Table t1 = setTempTable(tableName);
        // get the locations
        List<Integer> attrIdx = new ArrayList<Integer>();
//        for(int i=0; i<t1.attributeName.size(); i++)
//        {
//            for(int j=0; j<attributes.size(); j++)
//            {
//                if(attributes.get(j).equals(t1.attributeName.get(i))) {
//                    System.out.println("attributes " + attributes.get(j));
//                    attrIdx.add(i);
//                }
//            }
//        }
        for (int i=0; i < attributes.size(); i++){
            //System.out.println(i);
            for (int j = 0; j < t1.attributeName.size(); j++){
                if(attributes.get(i).equals(t1.attributeName.get(j))) {
                    //System.out.println("attributes " + attributes.get(j));
                    attrIdx.add(j);
                }
            }
        }
        // get the types at those positions
        List<String> types = new ArrayList<String>();
        for(int i=0; i<attrIdx.size(); i++)
        {
            types.add(t1.attributeType.get(attrIdx.get(i)));
        }

        Table temp = new Table("projectedTable", attributes, types, t1.primaryKeys); //primary keys is iffy

        // add everything relevant data into temp's attributeValues
        for(int i = 0; i < t1.attributeValues.size(); i++)
        {
            List<String> l = new ArrayList<String>();
            for(int j=0; j<attributes.size(); j++)
            {
                l.add(t1.attributeValues.get(i).get(attrIdx.get(j)));
            }
            temp.attributeValues.add(l);
        }
        temp.attributeValues = removeDuplicates(temp.attributeValues);
        buffer.add(0, temp);
    }

    public void update(String tabName, List<String> attributes, List<String> newVal)
    {
        Table t1 = setTempTable(tabName);
        Table t2 = setTempTable("garbageeeees");
        // get the locations
        List<Integer> attrIdx = new ArrayList<Integer>();
        for(int i=0; i<t1.attributeName.size(); i++)
        {
            for(int j=0; j<attributes.size(); j++)
            {
                if(attributes.get(j).equals(t1.attributeName.get(i)))
                    attrIdx.add(i);
            }
        }

        //find common values
        List<Integer> commonList = new ArrayList<Integer>();
        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            for(int j=0; j<t2.attributeValues.size(); j++)
            {
                if(t1.attributeValues.get(i).equals(t2.attributeValues.get(j)))
                {
                    commonList.add(i);
                }
            }
        }

        Table temp = new Table(tabName, t1.attributeName, t1.attributeType, t1.primaryKeys);
        for(int i = 0; i < t1.attributeValues.size(); i++)
        {
            if(commonList.contains(i)) //if it is a common list then we need to update it
            {
                List<String> l = new ArrayList<String>();
                for (int j = 0; j < t1.attributeValues.get(i).size(); j++) {
                    if (attrIdx.contains(j)) {
                        l.add(newVal.get(attrIdx.indexOf(j)));
                    } else {
                        l.add(t1.attributeValues.get(i).get(j));
                    }
                }
                temp.attributeValues.add(l);
            }
            else //otherwise just add the old one
            {
                temp.attributeValues.add(t1.attributeValues.get(i));
            }
        }
        tableList.set(findTable(tabName), temp);
    }



    // Inserts union of new table into tableList
    public void union(String tabName1, String tabName2)
    {
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);
        //create a new table with info from ONE of these tables in the buffer
        //populate the table with information from tab1 & tab2
        Table temp = new Table("unionedTable", t1.attributeName, t1.attributeType, t1.primaryKeys);
        temp.attributeValues.addAll(t1.attributeValues);
        temp.attributeValues.addAll(t2.attributeValues);

        temp.attributeValues = removeDuplicates(temp.attributeValues);
        buffer.add(0, temp);
    }
    public void rename(String tabName, List<String> newNames)
    {
        Table t = setTempTable(tabName);

        for(int i=0; i<newNames.size(); i++)
        {
            t.attributeName.set(i, newNames.get(i));
        }

        buffer.add(0, t);
    }


    /*
    public void insert(String tableName, String relName){
        int idx = findTable(tableName);
        this.union(tableName, relName);
        List<List<String>> temp = buffer.get(0).attributeValues;
        for(List<String> x: temp){
            System.out.println("x: " + x);
            tableList.get(idx).insertEntity(x);
        }
        buffer.remove(0);
        System.out.println("tableName: "+ tableList.get(findTable(tableName)).attributeValues);
    }

     */
    public void difference(String tabName1, String tabName2)
    {
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);

        //create a new table with info from the first table
        Table temp = new Table("differenceTable", t1.attributeName, t1.attributeType, t1.primaryKeys);

        //populate a temp table with stuff that isn't in both
        boolean notBoth; //exists in only one
        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            notBoth = false;
            for(int j=0; j<t2.attributeValues.size(); j++)
            {
                if(t1.attributeValues.get(i).equals(t2.attributeValues.get(j)))
                {
                    notBoth = true;
                }
            }
            if(notBoth)
            {
                temp.attributeValues.add(t1.attributeValues.get(i));
            }
        }
        buffer.add(0, temp);
    }

    public void intersect(String tabName1, String tabName2)
    {
//        System.out.println(" ----------- inside intersect ---------------");
//        System.out.println("buffer before : " + buffer.size());
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);
        //System.out.println("buffer: " + buffer.get(0).attributeValues);

//        System.out.println("t1 vals: " + t1.attributeValues);
//
//        System.out.println("t2 vals: " + t2.attributeValues);


        //create a new table with info from the first table
        Table temp = new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys);

        //populate the table with the intersection of tab1 & tab2
        t1.attributeValues.retainAll(t2.attributeValues);
        temp.attributeValues.addAll(t1.attributeValues);

        buffer.add(0, temp);
        //System.out.println("buffer after intersect" + buffer.get(0).attributeValues);
        //System.out.println("After the intersect");
        //this.printBuffer();
    }

    public void product(String tabName1, String tabName2)
    {
        //System.out.println("tanaaaaal");
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);

        //System.out.println("t1 name " + t1.tableName);
        //System.out.println("t2 name " + t2.tableName);

        //create a new table with info from the first table
        List<String> combinedAttrList = new ArrayList<>();
        List<String> combinedTypeList = new ArrayList<>();
        List<String> combinedKeyList = new ArrayList<>();

        combinedAttrList.addAll(t1.attributeName);
        combinedAttrList.addAll(t2.attributeName);
        combinedTypeList.addAll(t1.attributeType);
        combinedTypeList.addAll(t2.attributeType);
        combinedKeyList.addAll(t1.primaryKeys);
        combinedKeyList.addAll(t2.primaryKeys);

        Table temp = new Table("productTable", combinedAttrList, combinedTypeList, combinedKeyList);

        List<String> attrValues = new ArrayList<>();
        for (int i = 0; i < t1.attributeValues.size(); i++){
            for (int j = 0; j < t2.attributeValues.size(); j++){
                attrValues.addAll(t1.attributeValues.get(i));
                attrValues.addAll(t2.attributeValues.get(j));
                temp.insertEntity(attrValues);
                attrValues = new ArrayList<>();
            }
        }

        temp.attributeValues = removeDuplicates(temp.attributeValues);
        buffer.add(0, temp);
    }

    public void remove(String tabName1, String tabName2)
    {
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);

        //create a new table with info from the first table
        buffer.add(new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys));

        //populate the table with the intersection of tab1 & tab2
        t1.attributeValues.retainAll(t2.attributeValues);
        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            buffer.get(0).insertEntity(t1.attributeValues.get(i));
        }
    }
    public void printBuffer(){
        for(int i = 0; i < buffer.size();i++){
            System.out.println("bufferlist:" + i + " " + buffer.get(i).attributeValues);
        }

    }
    public void setTableForSelect(String tabName){
        Table t1 = setTempTable(tabName);
        tableForSelect = t1;
    }
    public void select(String tabName, String name, String val, String op) {
        //System.out.println("----------------- Inside select ---------------------------- ");
        Table t1 = tableForSelect;
        //System.out.println("Inside select: Whats t1?");
        //System.out.println(t1.attributeValues);
        Table temp = (new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys));
        // search for index of attributeName in tabName
        int col = t1.attributeName.indexOf(name);
        switch (op) {
            case "==":
                // iterate through attributeValues[col]
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (t1.attributeValues.get(i).get(col).equals(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                //System.out.println(temp.attributeValues);
                buffer.add(0, temp);
                break;
            case ">=":
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (Integer.parseInt(t1.attributeValues.get(i).get(col)) >= Integer.parseInt(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
            case "<=":
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (Integer.parseInt(t1.attributeValues.get(i).get(col)) <= Integer.parseInt(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
                break;
            case ">":
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (Integer.parseInt(t1.attributeValues.get(i).get(col)) > Integer.parseInt(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
                //System.out.println("The buffer after adding el");
                //printBuffer();
                break;
            case "<":
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (Integer.parseInt(t1.attributeValues.get(i).get(col)) < Integer.parseInt(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
                break;
            case "!=":
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (Integer.parseInt(t1.attributeValues.get(i).get(col)) != Integer.parseInt(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
                break;
            case "&&":
//                System.out.println("before intersect buffer");
//                this.printBuffer();
//                buffer.add(0, t1);
//                System.out.println("After adding it back to buffer");
//                this.printBuffer();
                this.intersect(name, val);
                break;
            case "||":
//                System.out.println("now for union");
//                System.out.println("Table 1 name " + name);
//                System.out.println("Table 2 name " + val);
                this.union(name, val);
                break;
        }
    }
    public void selectAttr(String tabName, String attr1, String attr2, String op) {
//        System.out.println("Inside select Attr");
//        System.out.println("attr1 " + attr1);
//        System.out.println("attr2 " + attr2);
//        System.out.println("op " + op);
        Table t = tableForSelect;
        int attr1_idx = 0;
        int attr2_idx = 0;
        for(int i = 0; i < t.attributeName.size();i++){
            if(t.attributeName.get(i).equals(attr1)){
                attr1_idx = i;
            }
            if(t.attributeName.get(i).equals(attr2)){
                attr2_idx = i;
            }
        }
        Table temp = new Table("selectedTable", t.attributeName, t.attributeType, t.primaryKeys);
        switch (op) {
            case "==":
                // iterate through attributeValues[col]
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(t.attributeValues.get(j).get(attr1_idx).equals(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
                //System.out.println("SelectAttr eq: " + buffer.get(0).attributeValues);
                break;
            case ">=":
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(Integer.parseInt(t.attributeValues.get(j).get(attr1_idx)) >= Integer.parseInt(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
            case "<=":
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(Integer.parseInt(t.attributeValues.get(j).get(attr1_idx)) <= Integer.parseInt(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
                break;
            case ">":
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(Integer.parseInt(t.attributeValues.get(j).get(attr1_idx)) > Integer.parseInt(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
                //System.out.println("buffer after > -------------------------------------------------------------------");
                //printBuffer();
                break;
            case "<":
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(Integer.parseInt(t.attributeValues.get(j).get(attr1_idx)) < Integer.parseInt(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
                break;
            case "!=":
                for(int j = 0; j < t.attributeValues.size();j++){
                    if(!t.attributeValues.get(j).get(attr1_idx).equals(t.attributeValues.get(j).get(attr2_idx))){
                        //System.out.println(t.attributeValues.get(j));
                        temp.insertEntity(t.attributeValues.get(j));
                    }
                }
                temp.attributeValues = removeDuplicates(temp.attributeValues);
                buffer.add(0, temp);
                //System.out.println("buffer after neq: ");
                //this.printBuffer();
                break;
        }

    }
    public void createQueryTable(String newName, String potentialName)
    {
        Table t = setTempTable(potentialName);

        Table temp = new Table(newName, t.attributeName, t.attributeType, t.primaryKeys);
        temp.attributeValues.addAll(t.attributeValues);
        tableList.add(temp);
    }
    public List<List<String>> removeDuplicates(List<List<String>> table){
        Set<List<String>> set = new HashSet<>(table);
        table.clear();
        table.addAll(set);
        return table;
    }
    public void deleteFrom(String tabName)
    {
        Table t1 = setTempTable(tabName);
        Table t2 = setTempTable("throwawaaaaaay");

        //find common values
        List<Integer> commonList = new ArrayList<Integer>();
        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            for(int j=0; j<t2.attributeValues.size(); j++)
            {
                if(t1.attributeValues.get(i).equals(t2.attributeValues.get(j)))
                {
                    commonList.add(i);
                }
            }
        }

        Table temp = new Table(tabName, t1.attributeName, t1.attributeType, t1.primaryKeys);
        for(int i = 0; i < t1.attributeValues.size(); i++)
        {
            if(!commonList.contains(i)) //if it is not a common list then we need to add it
            {

                temp.attributeValues.add(t1.attributeValues.get(i));
            }
        }
        tableList.set(findTable(tabName), temp);
    }




    /*
    public void writetoCSV(String tableTitle) throws IOException {
        int rows = 0;
        int cols  = 0;
        int tableIdx = findTable(tableTitle);
        String path = tableTitle + ".csv";
        FileWriter csvWriter = new FileWriter(path, false);
        int numAttributes = tableList.get(tableIdx).attributeName.size();
        if(numAttributes == 1){
            csvWriter.append(tableList.get(tableIdx).attributeName.remove(0));
            csvWriter.append("\n");
        }
        else{
            for (int i = 0; i < (2*numAttributes); i++) {
                if (i == (2 * numAttributes) - 1) {
                    csvWriter.append("\n");
                } else if (i % 2 == 0) {
                    String val = tableList.get(tableIdx).attributeName.remove(0);
                    csvWriter.append(val);
                }
                else {
                    csvWriter.append(",");
                }
            }
            for(int k = 1; k <=  tableList.get(tableIdx).attributeValues.size()  ;k++) {
                for (int j = 0; j < (2 * numAttributes); j++) {
                    if (j == (2 * numAttributes) - 1) {
                        csvWriter.append("\n");
                    }
                    else if (j % 2 == 0) {
                        csvWriter.append(tableList.get(tableIdx).attributeValues.get(rows).get(cols));
                        cols++;
                        if (cols == numAttributes) {
                            cols = 0;
                            rows = rows + 1;
                        } else {
                            csvWriter.append(",");
                        }
                    }
                }
            }
            csvWriter.append("\n\n\n");
            csvWriter.flush();
            csvWriter.close();
        }
    }

     */
    public void print(String tableTitle)
    {
        System.out.println("tableTitle: " + tableTitle);
        int tableIdx = findTable(tableTitle);
        if(tableIdx == -1){
            tableIdx = 0;
            for (String s : buffer.get(tableIdx).attributeName) {
                System.out.print(s + "\t");
            }
            System.out.println("");
            for (int i = 0; i < buffer.get(tableIdx).attributeValues.size(); i++) {
                for (int j = 0; j < buffer.get(tableIdx).attributeValues.get(i).size(); j++) {
                    System.out.print(buffer.get(tableIdx).attributeValues.get(i).get(j) + "\t");
                }
                System.out.println("");
            }
            //System.out.println("buffer at top: " + buffer.get(tableIdx).attributeValues);
        }
        else{
            for (String s : tableList.get(tableIdx).attributeName) {
                System.out.print(s + "\t");
            }
            System.out.println("");
            for (int i = 0; i < tableList.get(tableIdx).attributeValues.size(); i++) {
                for (int j = 0; j < tableList.get(tableIdx).attributeValues.get(i).size(); j++) {
                    System.out.print(tableList.get(tableIdx).attributeValues.get(i).get(j) + "\t");
                }
                System.out.println("");
            }
        }
    }
}