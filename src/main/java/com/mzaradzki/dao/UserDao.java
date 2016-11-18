package com.mzaradzki.dao;

import com.mzaradzki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marcel on 2016-11-17.
 */

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String email); //finding user in database with email and go to UserServiceImpl
}



