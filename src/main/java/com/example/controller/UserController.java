package com.example.controller;

import com.example.entities.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/")
public class UserController {

    @Autowired
    private UserService userService;

    //@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        if(id == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //new user = get existing user by id
        //if user is null - 404 Not Found
        //else - user and 200 OK
        User user = userService.get(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //save user in parameter
        //return 200 OK
        Integer id = userService.save(user);
        return new ResponseEntity<User>(HttpStatus.OK);
        //return new ResponseEntity.ok().body("New Book has been saved with ID:" + id);
    }

    //@RequestMapping(value = ""/*"{id}"*/, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping("{id}")
    public ResponseEntity<User> modifyUser(@PathVariable("id") Integer id, @RequestBody User user/*, @PathVariable Integer id*/){
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        //save user in parameter
        //return 200 OK
        userService.update(id, user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    //@RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        //new user = get existing user by id
        //if user is null - 404 Not Found
        //delete user by id
        //return 200 OK
        if(id == null){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    //@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        //new list of users = get all existing users
        //return 200 OK
        List<User> users = userService.list();
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }
}
