package project1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class dbms {

    private class Table {
        String tableName;
        List<String> attributeName = new ArrayList<String>();
        List<String> attributeType = new ArrayList<String>();
        //List<Integer> attributeLength = new ArrayList<Integer>();
        List<String> primaryKeys = new ArrayList<String>();
        List<List<String>> attributeValues = new ArrayList<List<String>>();

        // constructor
        Table(String tableName, List<String> attributeName, List<String> attributeType, List<String> primaryKeys)
        {
            this.tableName = tableName;
            for(String s : attributeName)
            {
                this.attributeName.add(s);
            }
            for(String s : attributeType)
            {
                this.attributeType.add(s);
            }
//            for(Integer s : attributeLength)
//            {
//                this.attributeLength.add(s);
//            }
            for(String s : primaryKeys)
            {
                this.primaryKeys.add(s);
            }
        }

        public void insertEntity(List<String> valuesIn)
        {
            //check the conditions later
            attributeValues.add(valuesIn); //////////////////////////////////is this a deep copy?
        }
    }

    // private members
    private List<Table> tableList = new ArrayList();
    private Table buffer;

    // public members
    public int findTable(String tableTitle)
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
        tableList.get(findTable(tableTitle)).insertEntity(valuesIn); ////////////////////////////this too
    }

    // Inserts union of new table into tableList
    public void union(String tabName1, String tabName2)
    {
        //search if tab 1 and 2 exists (second one should exist)
        int idx1 = -1;
        int idx2 = -1;
        Table t1, t2;
        for(int i = 0; i < tableList.size(); i++)
        {
            if(tabName1 == tableList.get(i).tableName)
            {
                idx1 = i;
            }
            else if(tabName2 == tableList.get(i).tableName)
            {
                idx2 = i;
            }
        }
        //if one of them doesn't exist, that means that we use the table from the buffer
        if(idx1 == -1){
            t1=buffer;
        }
        else
        {
            t1=tableList.get(idx1);
        }
        t2=tableList.get(idx2);
        //create a new table with info from ONE of these tables in the buffer
        buffer = new Table(t1.tableName, t1.attributeName, t1.attributeType, t1.primaryKeys);
        //populate the table with information from tab1 & tab2

        for(int i=0; i<t1.attributeValues.size(); i++)
        {
            buffer.insertEntity(t1.attributeValues.get(i));
        }
        for(int i=0; i<t2.attributeValues.size(); i++)
        {
            buffer.insertEntity(t2.attributeValues.get(i));
        }
    }

    public void writetoCSV(String tableTitle) throws IOException {
        int rows = 0;
        int cols  = 0;
        int tableIdx = findTable(tableTitle);
        int size = 0;
        int check = 0;
        for(List<String> specificEntity: tableList.get(tableIdx).attributeValues){
            size++;
        }
        FileWriter csvWriter = new FileWriter("toTaste.csv");
        int numAttributes = tableList.get(tableIdx).attributeName.size();
        if(numAttributes == 1){
            csvWriter.append(tableList.get(tableIdx).attributeName.remove(0));
            csvWriter.append("\n");
        }
        else{
            csvWriter.append(tableTitle);
            csvWriter.append("\n\n");
            check++;
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
            for(int k = 1; k <= size;k++) {
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
        int tableIdx = findTable(tableTitle);
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