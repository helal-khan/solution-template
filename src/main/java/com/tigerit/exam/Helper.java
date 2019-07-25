package com.tigerit.exam;

import java.io.IOException;
import static com.tigerit.exam.IO.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {

    private List<String> strInput = new ArrayList<>();
    private List<Integer> intInput = new ArrayList<>();

    public int getNoOfTestCase(){
        int noOfTestCase = readLineAsInteger();
        if(noOfTestCase<1 || noOfTestCase>10) {
            println("No of test case should be \"1<=T<=10\"\nTry Again:");
            getNoOfTestCase();
        }
        return noOfTestCase;
    }

    public int getNoOfTable(){
        int noOfTablee = readLineAsInteger();
        if(noOfTablee<1 || noOfTablee>10) {
            println("No of table should be \"2<=nT<=10\"\nTry Again:");
            getNoOfTable();
        }
        return noOfTablee;
    }

    public List<Integer> getNoOfColumnRecord() throws IOException{
        List<Integer> columnRecord = this.getIntInput(2);
        if(columnRecord.get(0)<2 || columnRecord.get(1)>100) {
            println("No of column & record should be \"2<=nC,nD<=100\"\nTry Again:");
            getNoOfColumnRecord();
        }
        return columnRecord;
    }

    public int getNoOfQuery(){
        int noOfQuery = readLineAsInteger();
        if(noOfQuery>50) {
            println("No of query should be \"0<=nQ<=50\"\nTry Again:");
            getNoOfQuery();
        }
        return noOfQuery;
    }

    public List<String> getStrInput(int size) throws IOException {
        String line = readLine();
        String[] tokens = line.split("\\s");
        for (int i = 0; i < tokens.length; i++) {
            strInput.add(tokens[i]);
            if (strInput.size() == size) {
                break;
            }
        }
        if (strInput.size() < size) {
            getStrInput(size);
        }
        return strInput;
    }

    public List<Integer> getIntInput(int size) throws IOException {
        try {
            String line = readLine();
            String[] tokens = line.split("\\s");
            for (int i = 0; i < tokens.length; i++) {
                intInput.add(Integer.parseInt(tokens[i]));
                if (intInput.size() == size) {
                    break;
                }
            }
            if (intInput.size() < size) {
                getIntInput(size);
            }
        } catch (NumberFormatException e) {
            getIntInput(size);
        }
        return intInput;
    }

    public List<Table> getTableInstance(int size){
        List<Table> listOfTables = new ArrayList<>();
        for (int i=0;i<size;i++){
            listOfTables.add(new Table());
        }
        return listOfTables;
    }

    public List<Query> getQueryInstance(int size){
        List<Query> listOfQuires = new ArrayList<>();
        for (int i=0;i<size;i++){
            listOfQuires.add(new Query());
        }
        return listOfQuires;
    }
}
