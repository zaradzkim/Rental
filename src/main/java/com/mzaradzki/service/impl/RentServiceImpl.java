package com.mzaradzki.service.impl;

import com.mzaradzki.dao.CarDao;
import com.mzaradzki.dao.RentDao;
import com.mzaradzki.model.Car;
import com.mzaradzki.model.Rent;
import com.mzaradzki.model.User;
import com.mzaradzki.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Marcel on 2016-11-20.
 */

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentDao rentDao;

    @Autowired
    private CarDao carDao;

    @Override
    @Transactional //automatic adding to datebase methods save and for webpage, when is some problem with saving, then annotation don't save anything
    public void createRent(User user, Car car) {
        Rent rent = new Rent(user, car);

        rentDao.save(rent);
        car.decrementQuantity();
        carDao.save(car);
    }
}
