package com.mzaradzki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class RentController {

    @RequestMapping(value = "/rents", method = RequestMethod.GET)
    public String getRentsPage() {
        return "rents";
    }
}
