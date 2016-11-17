package com.mzaradzki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class LenderController {
    @RequestMapping(value = "/lenders", method = RequestMethod.GET)
    public String getLendersPage() {
        return "lenders";
    }

    @RequestMapping(value = "/lenders/lenders-create", method = RequestMethod.GET)
    public String getLendersCreate() {
        return "lenders-create";
    }
}
