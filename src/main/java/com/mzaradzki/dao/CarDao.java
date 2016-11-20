package com.mzaradzki.dao;

import com.mzaradzki.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcel on 2016-11-20.
 */

@Repository
public interface CarDao extends JpaRepository<Car, Long> {
}
