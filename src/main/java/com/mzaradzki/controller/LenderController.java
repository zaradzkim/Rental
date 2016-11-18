package com.mzaradzki.controller;

import com.mzaradzki.dao.UserDao;
import com.mzaradzki.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class LenderController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/lenders", method = RequestMethod.GET)
    public String getLendersPage(Model model) {

        List<User> users = userDao.findAll();
        model.addAttribute("usersList", users);

        return "lenders";
    }

    @RequestMapping(value = "/lenders-create", method = RequestMethod.GET)
    public String getLendersCreate() {
        return "lenders-create";
    }

    @RequestMapping(value = "/lenders-create", method = RequestMethod.POST)
    public String saveLender(@ModelAttribute User user){



        userDao.save(user);

        return"redirect:/lenders";


    }

    @RequestMapping(value = "/lenders/delete/{id}", method = RequestMethod.POST)
    public String deleteLender(@PathVariable Long id) {

        userDao.delete(id);

        return "redirect:/lenders";
    }
}
