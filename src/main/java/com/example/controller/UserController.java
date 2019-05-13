package com.example.controller;

import com.example.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/")
public class UserController {

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        if(id == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //new user = get existing user by id
        //if user is null - 404 Not Found
        //else - user and 200 OK
        return null; //comment this
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //save user in parameter
        //return 200 OK
        return null; //comment this
    }

    @RequestMapping(value = ""/*"{id}"*/, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> modifyUser(@RequestBody User user/*, @PathVariable Integer id*/){
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //save user in parameter
        //return 200 OK
        return null; //comment this
    }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){
        //new user = get existing user by id
        //if user is null - 404 Not Found
        //delete user by id
        //return 200 OK
        return null; //comment this
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        //new list of users = get all existing users
        //return 200 OK
        return null; //comment this
    }
}
