package com.colbackend.collection.dto;

/**
 * created on: 07/03/21
 * created by: harsha
 */
public class CreateCollectionItem {
    private String colName;
    private String front;
    private String back;

    public CreateCollectionItem() {
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }
}
