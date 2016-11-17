package com.mzaradzki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class CarController {

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCarsPage() {
        return "cars";
    }

    @RequestMapping(value = "/car/create", method = RequestMethod.GET)
    public String getCreateCar() {
        return "car-create";
    }
}
