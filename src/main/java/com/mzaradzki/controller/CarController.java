package com.mzaradzki.controller;

import com.mzaradzki.dao.CarDao;
import com.mzaradzki.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Marcel on 2016-11-15.
 */

@Controller
public class CarController {

    @Autowired
    private CarDao carDao;

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String getCarsPage(Model model) {

        List<Car> cars = carDao.findAll();
        model.addAttribute("carsList", cars); // list with cars

        return "cars";
    }

    @RequestMapping(value = "/car-create", method = RequestMethod.GET)
    public String getCreateCar(Model model) {

        model.addAttribute("car", new Car());

        return "car-create";
    }

    @RequestMapping(value = "/car-create/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute @Valid Car car, BindingResult result){

        if (result.hasErrors()) {
            return "book-create";
        }

        carDao.save(car);

        return"redirect:/cars";
    }

    @RequestMapping(value = "/car/delete/{id}", method = RequestMethod.POST)
    public String postDeleteCar(@PathVariable Long id) {
        carDao.delete(id);

        return "redirect:/cars";
    }

    @RequestMapping(value = "/car/edit/{id}", method = RequestMethod.GET)
    public String getUserEditPage(@PathVariable Long id, Model model ){

        Car car = carDao.findOne(id);

        model.addAttribute("car", car);

        return "car-create";


    }

    @RequestMapping(value = "/car-create/cancel", method = RequestMethod.GET)
    public String cancelEdit() {
        return "redirect:/cars";
    }

}
