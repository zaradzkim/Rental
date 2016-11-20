package com.mzaradzki.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marcel on 2016-11-20.
 */

@Entity
@Table(name ="rent")
public class Rent extends BaseEntity {

    public enum Status{
        IN_PROGRESS, FINISHED
    }

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER) // relation beetween 2 columns with foreign key
    @JoinColumn(name = "user_id", nullable = false) //column with foreign key
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;


    public Rent(User user, Car car) {
        this.createdDate = new Date();
        this.status = Status.IN_PROGRESS;
        this.car = car;
        this.user = user;
    }

    public Rent(){

    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
