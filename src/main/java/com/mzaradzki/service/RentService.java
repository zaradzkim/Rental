package com.mzaradzki.service;

import com.mzaradzki.model.Car;
import com.mzaradzki.model.User;

/**
 * Created by Marcel on 2016-11-20.
 */
public interface RentService {

    void createRent(User user, Car car);
}
