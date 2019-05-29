package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        User user = userService.get(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(user, HttpStatus.OK); //200
    }

    /*
    @GetMapping("login/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username){
        User user = userService.get(username);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(user, HttpStatus.OK); //200
    }
    */

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user){
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            userService.save(user);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<User> modifyUser(@PathVariable("id") Integer id, @RequestBody User user){
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            userService.update(id, user);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id){
        try {
            userService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.list();
        return new ResponseEntity<>(users, HttpStatus.OK); //200
    }
}
