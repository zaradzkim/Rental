package com.mzaradzki.service.impl;

import com.mzaradzki.dao.UserDao;
import com.mzaradzki.model.User;
import com.mzaradzki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcel on 2016-11-18.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException { //logging by email

        User user = userDao.findByEmail(email); //look for user with email in database

        if(user == null) {
            throw new UsernameNotFoundException(email + "nie istnieje w bazie!");
        }

        List<GrantedAuthority> authorities = new ArrayList<>(); //list with roles and permissions

        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole())); //checking what role user have

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(), //email password from database
                authorities // list of permissions when email and password is correct


        );
    }
}
