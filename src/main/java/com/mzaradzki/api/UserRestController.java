package com.mzaradzki.api;

import com.mzaradzki.dao.UserDao;
import com.mzaradzki.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcel on 2016-11-20.
 */
@RestController //this adnotation give json format
public class UserRestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/api/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // convert data to json
    public List<UserDto> getUsers() {
        List<User> users = userDao.findAll(); //users from database

//        List<UserDto> userDtos = new ArrayList<>();
//
//        for (User user : users) {                    old way
//            userDtos.add(new UserDto(user));
//    }

     return users.stream().map(UserDto::new).collect(Collectors.toList()); //java 8


  //      return userDtos;

    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {

        User user = new User(userDto);
        userDao.save(user);

        return ResponseEntity.ok("User created"); //message from for example android

    }
}
