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

        public void insertEntity(List<String> valuesIn)
        {
            //check the conditions later
            attributeValues.add(valuesIn);
        }
    }

    // private members
    private List<Table> tableList = new ArrayList<Table>();
    private List<Table> buffer = new ArrayList<Table>();

    // public members
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

    // Inserts union of new table into tableList
    public void union(String tabName1, String tabName2)
    {
        //System.out.println("tabName1: " + tabName1);
        //System.out.println("tabName2: " + tabName2);
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);
        //create a new table with info from ONE of these tables in the buffer
        //buffer.add(new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys));
        //System.out.println("initial bufferList: " + buffer.get(0).attributeValues);
        //populate the table with information from tab1 & tab2
        Table temp = new Table("unionedTable", t1.attributeName, t1.attributeType, t1.primaryKeys);
        temp.attributeValues.addAll(t1.attributeValues);
        temp.attributeValues.addAll(t2.attributeValues);
        buffer.add(0, temp);
        //System.out.println("bufferList: "+ buffer.get(0).attributeValues);
        System.out.println("Table names in buffer");
        for (Table el : buffer){
            System.out.println("buffer values: " + el.attributeValues);
        }
        System.out.println("Table names in tableList");
        for(Table l: tableList){
            System.out.println("table list names: " + l.tableName);
        }
    }
    public void rename(String tabName, String oldName, String newName)
    {
        Table t = setTempTable(tabName);

        Collections.replaceAll(t.attributeName, oldName, newName);
        tableList.set(findTable(tabName), t);
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
    public void intersect(String tabName1, String tabName2)
    {
        Table t1 = setTempTable(tabName1);
        Table t2 = setTempTable(tabName2);

        //create a new table with info from the first table
        Table temp = new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys);

        //populate the table with the intersection of tab1 & tab2
        t1.attributeValues.retainAll(t2.attributeValues);
        temp.attributeValues.addAll(t1.attributeValues);

        buffer.add(0, temp);
        System.out.println("buffer: " + buffer.get(0).attributeValues);
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
    public void select(String tabName, String name, String val, String op) {
        Table t1 = setTempTable(tabName);
        Table temp = (new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys));
        // search for index of attributeName in tabName
        System.out.println("name " + name);
        System.out.println("Attribute names " + t1.attributeName);
        int col = t1.attributeName.indexOf(name);
        System.out.println(col);
        System.out.println("Tables in list");
        for (Table el : tableList){
            System.out.println(el.tableName);
        }
        switch (op) {
            case "==":
                // iterate through attributeValues[col]
                for (int i = 0; i < t1.attributeValues.size(); i++) {
                    if (t1.attributeValues.get(i).get(col).equals(val)) {
                        temp.insertEntity(t1.attributeValues.get(i));
                    }
                }
                buffer.add(0, temp);
                break;
        }
        System.out.println("buffer " + buffer.get(0).attributeValues);
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
            System.out.println("buffer at top: " + buffer.get(tableIdx).attributeValues);
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