package com.colbackend.collection.models;

import javax.persistence.*;

/**
 * created on: 03/03/21
 * created by: harsha
 */

@Entity
public class Collection {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    public Collection() {
    }

    public Collection(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                '}';
    }
}
