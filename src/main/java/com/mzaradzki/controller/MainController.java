package com.mzaradzki.controller;

import com.mzaradzki.dao.UserDao;
import com.mzaradzki.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class MainController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "main";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getCreatePage() {
        return "register";
    }

    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String getRegisterPage(@ModelAttribute User user) {

        userDao.save(user);  //save user from register page

        return"redirect:/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String getLogoutPage(){
        return "login";
    }
}