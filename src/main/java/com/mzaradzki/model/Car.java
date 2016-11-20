package com.mzaradzki.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Marcel on 2016-11-20.
 */

@Entity
@Table(name = "car")
public class Car extends BaseEntity {


    @NotNull
    @Size(min = 3, max = 255, message = "Specify the length {min} do {max}")
    private String mark;

    @NotNull
    @Size(min = 2, max = 255)
    private String model;

    @Min(0) // not allowed negative numbers
    private Integer avaible; //TODO: Rename avaible for avaiable

    public Car(){


    }

    public Car(String mark, String model, Integer avaible) {
        this.mark = mark;
        this.model = model;
        this.avaible = avaible;
    }



    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getAvaible() {
        return avaible;
    }

    public void setAvaible(Integer avaible) {
        this.avaible = avaible;
    }


    public void decrementQuantity() { //when user rent a car, avaiable -1
        avaible--;
    }
}
