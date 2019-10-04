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
        System.out.println("tabName1: " + tabName1);
        System.out.println("tabName2: " + tabName2);
        //search if tab 1 and 2 exists (second one should exist)
        int idx1 = -1;
        int idx2 = -1;
        Table t1, t2;
        for(int i = 0; i < tableList.size(); i++)
        {
            //System.out.println("table list size" + tableList.get(i).tableName);
            if(tabName1.equals(tableList.get(i).tableName))
            {
                idx1 = i;
            }
            if(tabName2.equals(tableList.get(i).tableName))
            {
                idx2 = i;
            }
        }
        System.out.println("tabName1 idx: " + idx1);
        System.out.println("tabName2 idx: " + idx2);
        //if one of them doesn't exist, that means that we use the table from the buffer
        if(idx1 == -1){
            t1=buffer.remove(0);
        }
        else
        {
            t1=tableList.get(idx1);
        }
        t2=tableList.get(idx2);
        //create a new table with info from ONE of these tables in the buffer
        buffer.add(new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys));
        //populate the table with information from tab1 & tab2
        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            Table temp = buffer.get(0);
            temp.insertEntity(t1.attributeValues.get(i));
            buffer.set(0, temp);
        }
        System.out.println("tableName: "+ buffer.get(0).tableName);
        for(int i=0; i<t2.attributeValues.size(); i++)
        {
            //buffer.get(0).insertEntity(t2.attributeValues.get(i));
            Table temp = buffer.get(0);
            temp.insertEntity(t2.attributeValues.get(i));
            buffer.set(0, temp);
        }
        System.out.println("tableName now: " + buffer.get(0).tableName);
    }
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
    public void print(String tableTitle)
    {
        System.out.println("tableTitle: " + tableTitle);
        int tableIdx = findTable(tableTitle);
        if(tableIdx == -1){
            tableIdx = buffer.size()-1;
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