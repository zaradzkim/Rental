package com.mzaradzki.controller;

import com.mzaradzki.dao.CarDao;
import com.mzaradzki.dao.RentDao;
import com.mzaradzki.dao.UserDao;
import com.mzaradzki.model.Car;
import com.mzaradzki.model.Rent;
import com.mzaradzki.model.User;
import com.mzaradzki.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class RentController {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CarDao carDao;

    @Autowired
    private RentService rentService;



    @RequestMapping(value = "/rents", method = RequestMethod.GET)
    public String getRentsPage(Model model, Principal principal) {

        String email=principal.getName();

        User user = userDao.findByEmail(email); //look for user with email, implementation in UserDao

        List<Rent> rentList;
        if(user.getRole() == User.Role.USER){
            rentList = rentDao.findByUserOrderByCreatedDateDesc(user); //list with rents for this user
        } else {
            rentList = rentDao.findAll(); //for admin showing all rents from users
        }
        model.addAttribute("rentsList", rentList);

        return "rents";
    }

    @RequestMapping(value = "/rent/car/{carId}")
    public String createRent(@PathVariable Long carId, Principal principal, RedirectAttributes redirectAttributes) {

        String email = principal.getName();

        Car car = carDao.findOne(carId);
        User user = userDao.findByEmail(email);

        rentService.createRent(user, car);

        return "redirect:/rents";


    }
}
