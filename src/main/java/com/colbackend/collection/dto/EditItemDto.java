package com.colbackend.collection.dto;

/**
 * created on: 11/03/21
 * created by: harsha
 */
public class EditItemDto {

    private String front;
    private String back;
    private Long id;

    public EditItemDto() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
