package com.mzaradzki.dao;

import com.mzaradzki.model.Rent;
import com.mzaradzki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Marcel on 2016-11-20.
 */

@Repository
public interface RentDao extends JpaRepository<Rent, Long> {

    List<Rent> findByUserOrderByCreatedDateDesc(User user); //finding for user rents, and show only this user rents, not all users
}
