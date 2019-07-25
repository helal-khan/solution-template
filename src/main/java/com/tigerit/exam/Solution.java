package com.tigerit.exam;

import java.util.ArrayList;
import java.util.List;

import static com.tigerit.exam.IO.*;

/**
 * All of your application logic should be placed inside this class. Remember we
 * will load your application from our custom container. You may add private
 * method inside this class but, make sure your application's execution points
 * start from inside run method.
 */
public class Solution implements Runnable {

    @Override
    public void run() {
        // your application entry point
        try {
            int noOfTestCase;
            noOfTestCase = new Helper().getNoOfTestCase();
            int testNo = 1;

            for (int i = 0; i < noOfTestCase; i++) {
                int noOfTable, noOfQuery;
                List<Table> listOfTables;
                List<Query> listOfQueries;

                //Geting Table information
                noOfTable = new Helper().getNoOfTable();
                listOfTables = new Helper().getTableInstance(noOfTable);
                for (Table t : listOfTables) {
                    //table_a
                    t.setTableName(readLine());

                    //3 3 (enter no of column and records)
                    List<Integer> columnRecord = new Helper().getNoOfColumnRecord();
                    t.setNoOfColumn(columnRecord.get(0));
                    t.setNoOfRecord(columnRecord.get(1));

                    //id_a a1 a2 (enter column names)
                    t.setColumnName(new Helper().getStrInput(t.getNoOfColumn()));

                    //1 2 3  2 4 5  3 6 7(data inserting)
                    List<List<Integer>> colVal = new ArrayList<>();
                    for (int j = 0; j < t.getNoOfRecord(); j++) {
                        colVal.add(new Helper().getIntInput(t.getNoOfColumn()));
                    }
                    t.setColumnValue(colVal);
                }

                //Geting Query information
                noOfQuery = new Helper().getNoOfQuery();
                listOfQueries = new Helper().getQueryInstance(noOfQuery);
                for (Query q : listOfQueries) {
                    q.setSelectColumn(readLine());
                    q.setFirstTable(readLine());
                    q.setSecondTable(readLine());
                    q.setJoinColumn(readLine());
                    print("\n");
                }

                //Output calculation here
                println("Test: " + testNo);
                for (Query q : listOfQueries) {
                    String firstTable = null, secondTable = null, firstJoiningKey = null, secondJoiningKey = null;
                    int firstJoinIndex = 0, secondJoinIndex = 0;

                    List<String> firstSelectCol = new ArrayList<>();
                    List<String> secondSelectCol = new ArrayList<>();

                    List<Integer> firstSelectColIndex = new ArrayList<>();
                    List<Integer> secondSelectColIndex = new ArrayList<>();
                    List<Integer> firstJoinValues = new ArrayList<>();
                    List<Integer> secondJoinValues = new ArrayList<>();
                    List<Integer> matchedRow = new ArrayList<>();

                    for (Table t : listOfTables) {
                        if (q.getFirstTable().contains(t.getTableName())) {
                            firstTable = t.getTableName();
                            for (String col : t.getColumnName()) {
                                firstSelectCol.add(col);
                                firstSelectColIndex.add(t.getColumnName().indexOf(col));
                                if (q.getJoinColumn().contains(col)) {
                                    firstJoiningKey = col;
                                    firstJoinIndex = t.getColumnName().indexOf(col);

                                    for (List<Integer> row : t.getColumnValue()) {
                                        firstJoinValues.add(row.get(firstJoinIndex));
                                    }
                                }

                            }
                        } else {
                            secondTable = t.getTableName();
                            for (String col : t.getColumnName()) {
                                secondSelectCol.add(col);
                                secondSelectColIndex.add(t.getColumnName().indexOf(col));
                                if (q.getJoinColumn().contains(col)) {
                                    secondJoiningKey = col;
                                    secondJoinIndex = t.getColumnName().indexOf(col);

                                    for (List<Integer> row : t.getColumnValue()) {
                                        secondJoinValues.add(row.get(secondJoinIndex));
                                    }
                                }
                            }
                        }
                    }

                    if (!q.getSelectColumn().contains("*")) {
                        List<String> tempCol = new ArrayList<>();
                        List<Integer> tempColIndex = new ArrayList<>();
                        for (int p = 0; p < firstSelectCol.size(); p++) {
                            if (q.getSelectColumn().contains(firstSelectCol.get(p))) {
                                tempCol.add(firstSelectCol.get(p));
                                tempColIndex.add(p);
                            }
                        }
                        firstSelectCol = tempCol;
                        tempCol = new ArrayList<>();
                        firstSelectColIndex = tempColIndex;
                        tempColIndex = new ArrayList<>();
                        for (int p = 0; p < secondSelectCol.size(); p++) {
                            if (q.getSelectColumn().contains(secondSelectCol.get(p))) {
                                tempCol.add(secondSelectCol.get(p));
                                tempColIndex.add(p);
                            }
                        }
                        secondSelectCol = tempCol;
                        tempCol = new ArrayList<>();
                        secondSelectColIndex = tempColIndex;
                        tempColIndex = new ArrayList<>();
                    }

                    for (int row = 0; row < firstJoinValues.size(); row++) {
                        if (firstJoinValues.get(row) == secondJoinValues.get(row)) {
                            matchedRow.add(row);
                        }
                    }

                    //Output printing
                    //Print column
                    for (String col : firstSelectCol) {
                        print(col + " ");
                    }
                    for (String col : secondSelectCol) {
                        print(col + " ");
                    }

                    //Print data
                    List<List<Integer>> firstData = new ArrayList<>();
                    List<List<Integer>> secondData = new ArrayList<>();
                    for (Table t : listOfTables) {
                        if (t.getTableName().equals(firstTable)) {
                            for (List<Integer> rows : t.getColumnValue()) {
                                List<Integer> tempData = new ArrayList<>();
                                for (Integer row : matchedRow) {
                                    if (t.getColumnValue().indexOf(rows) == row) {
                                        for (Integer index : firstSelectColIndex) {
                                            tempData.add(rows.get(index));
                                        }
                                    }
                                }
                                if (tempData.size() != 0) {
                                    firstData.add(tempData);
                                }
                            }
                        }
                        if (t.getTableName().equals(secondTable)) {
                            for (List<Integer> rows : t.getColumnValue()) {
                                List<Integer> tempData = new ArrayList<>();
                                for (Integer row : matchedRow) {
                                    if (t.getColumnValue().indexOf(rows) == row) {
                                        for (Integer index : secondSelectColIndex) {
                                            tempData.add(rows.get(index));
                                        }
                                    }
                                }
                                if (tempData.size() != 0) {
                                    secondData.add(tempData);
                                }
                            }
                        }
                    }
                    print("\n");
                    for (int a = 0; a < firstData.size(); a++) {
                        for (Integer rows : firstData.get(a)) {
                            print(rows + " ");
                        }
                        for (Integer rows : secondData.get(a)) {
                            print(rows + " ");
                        }

                        print("\n");

                    }
                    print("\n");

                }
                testNo++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}