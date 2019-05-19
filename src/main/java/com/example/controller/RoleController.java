package com.example.controller;

import com.example.model.Role;
import com.example.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<Role> getRole(@PathVariable("id") int id){
        Role role = roleService.get(id);
        if(role == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(role, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        if(role == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            roleService.save(role);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Role> modifyRole(@PathVariable("id") int id, @RequestBody Role role){
        if(role == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            roleService.update(id, role);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable("id") int id){
        try {
            roleService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Role>> getAllDictionaries(){
        List<Role> dictionaries = roleService.list();
        return new ResponseEntity<>(dictionaries, HttpStatus.OK); //200
    }
}
