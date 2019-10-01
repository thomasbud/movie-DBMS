package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class dbms {

    private class Table {
        String tableName;
        List<String> attributeName = new ArrayList<String>();
        List<String> attributeType = new ArrayList<String>();
        List<Integer> attributeLength = new ArrayList<Integer>();
        List<String> primaryKeys = new ArrayList<String>();
        List<List<String>> attributeValues = new ArrayList<List<String>>();

        // constructor
        Table(String tableName, List<String> attributeName, List<String> attributeType, List<Integer> attributeLength, List<String> primaryKeys)
        {
            this.tableName = tableName;
            this.attributeName = attributeName;
            this.attributeType = attributeType;
            this.attributeLength = attributeLength;
            this.primaryKeys = primaryKeys;
        }

        public void insertEntity(List<String> valuesIn)
        {
            attributeValues.add(valuesIn);
        }
    }

    // private members
    private List<Table> tableList = new ArrayList();
    private Stack<Table> buffer = new Stack<Table>();
    int garbageName;

    // public members
    public int findTable(String tableTitle)
    {
        for(int i = 0; i < tableList.size(); i++)
        {
            if(tableTitle == tableList.get(i).tableName)
            {
                return i;
            }
        }

        return -1; //will crash the program INTENTIONALLY if we can't find it because it's over at this points
    }

    public void createTable(String tableName, List<String> attributeName, List<String> attributeType, List<Integer> attributeLength, List<String> primaryKeys)
    {
        tableList.add(new Table(tableName, attributeName, attributeType, attributeLength, primaryKeys));
    }

    public void insertInto(String tableTitle, List<String> valuesIn)
    {
        tableList.get(findTable(tableTitle)).insertEntity(valuesIn);
    }

    // Inserts union of new table into tableList
    public void union(Table tab1, Table tab2)
    {
        //tableList.add(new Table())
    }

    public void print(String tableTitle)
    {
        List<List<String>> out = new ArrayList<List<String>>();

        int tableIdx = findTable(tableTitle);
        out.add(tableList.get(tableIdx).attributeName);
        for(int i=0; i<tableList.size(); i++)
            out.add(tableList.get(tableIdx).attributeValues.get(i));

        for(int i=0; i<out.size(); i++)
        {
            for(int j=0; i<out.get(i).size(); j++)
            {
                System.out.print(out.get(i).get(j) + "\t");
            }
            System.out.println(" ");
        }
    }
}
