package com.tigerit.exam;

import java.util.ArrayList;
import java.util.List;

public class Table{

    String tableName;
    int noOfColumn;
    int noOfRecord;
    List<String> columnName = new ArrayList<>();
    List<List<Integer>> columnValue = new ArrayList<>();
    public Table() {
    }

    public Table(String tableName, int noOfColumn, int noOfRecord, List<String> columnName, List<List<Integer>> columnValue) {
        this.tableName = tableName;
        this.noOfColumn = noOfColumn;
        this.noOfRecord = noOfRecord;
        this.columnName = columnName;
        this.columnValue = columnValue;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getNoOfColumn() {
        return noOfColumn;
    }

    public void setNoOfColumn(int noOfColumn) {
        this.noOfColumn = noOfColumn;
    }

    public int getNoOfRecord() {
        return noOfRecord;
    }

    public void setNoOfRecord(int noOfRecord) {
        this.noOfRecord = noOfRecord;
    }

    public List<String> getColumnName() {
        return columnName;
    }

    public void setColumnName(List<String> columnName) {
        this.columnName = columnName;
    }

    public List<List<Integer>> getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(List<List<Integer>> columnValue) {
        this.columnValue = columnValue;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", noOfColumn=" + noOfColumn +
                ", noOfRecord=" + noOfRecord +
                ", columnName=" + columnName +
                ", columnValue=" + columnValue +
                '}';
    }
}
