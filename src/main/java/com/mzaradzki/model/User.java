package com.mzaradzki.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Marcel on 2016-11-15.
 */
@Entity
@Table(name = "user")
public class User {
    private String firstName;
    private String lastName;
}
