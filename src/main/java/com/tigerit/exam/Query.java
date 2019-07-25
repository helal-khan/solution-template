package com.tigerit.exam;

public class Query {

    private String selectColumn;
    private String firstTable;
    private String secondTable;
    private String joinColumn;


    public Query() {
    }

    public Query(String selectColumn, String firstTable, String secondTable, String joinColumn) {
        this.selectColumn = selectColumn;
        this.firstTable = firstTable;
        this.secondTable = secondTable;
        this.joinColumn = joinColumn;
    }

    public String getSelectColumn() {
        return selectColumn;
    }

    public void setSelectColumn(String selectColumn) {
        this.selectColumn = selectColumn;
    }

    public String getFirstTable() {
        return firstTable;
    }

    public void setFirstTable(String firstTable) {
        this.firstTable = firstTable;
    }

    public String getSecondTable() {
        return secondTable;
    }

    public void setSecondTable(String secondTable) {
        this.secondTable = secondTable;
    }

    public String getJoinColumn() {
        return joinColumn;
    }

    public void setJoinColumn(String joinColumn) {
        this.joinColumn = joinColumn;
    }

    @Override
    public String toString() {
        return "Query{" +
                "selectColumn='" + selectColumn + '\'' +
                ", firstTable='" + firstTable + '\'' +
                ", secondTable='" + secondTable + '\'' +
                ", joinColumn='" + joinColumn + '\'' +
                '}';
    }
}
