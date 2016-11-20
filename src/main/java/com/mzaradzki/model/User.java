package com.mzaradzki.model;

import com.mzaradzki.api.UserDto;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

/**
 * Created by Marcel on 2016-11-15.
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    public User(UserDto userDto) {
        id = userDto.getId();
        email = userDto.getEmail();
        firstName = userDto.getFirstName(); //costructor for userRestController
        lastName = userDto.getLastName();
        password = "1234";
    }

    public enum Role{
        USER, ADMIN
    }



    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;



    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.USER; //default role user, amin changing in the database


    public User(){ //empty constructor, specification from JPA requaierd this

    }




    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
