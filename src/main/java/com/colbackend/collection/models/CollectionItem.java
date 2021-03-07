package com.colbackend.collection.models;

import com.colbackend.collection.dto.CreateCollectionItem;
import com.colbackend.collection.exceptions.CreateCollectionItemException;

import javax.persistence.*;

/**
 * created on: 03/03/21
 * created by: harsha
 */

@Entity
public class CollectionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String front;
    private String back;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private Collection collection;

    public CollectionItem() {
    }

    public CollectionItem(String front, String back, Collection collection) {
        this.front = front;
        this.back = back;
        this.collection = collection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "CollectionItem{" +
                "front='" + front + '\'' +
                ", back='" + back + '\'' +
                ", collection=" + collection +
                '}';
    }
}
