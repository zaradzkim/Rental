package com.mzaradzki.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Marcel on 2016-11-20.
 */

@MappedSuperclass // every fields adding to extends class
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement in the database
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
