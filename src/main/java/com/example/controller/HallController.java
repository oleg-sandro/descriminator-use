package com.example.controller;

import com.example.model.Hall;
import com.example.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hall/")
public class HallController {

    @Autowired
    private HallService hallService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<Hall> getHall(@PathVariable("id") Integer id){
        Hall hall = hallService.get(id);
        if(hall == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(hall, HttpStatus.OK); //200
    }

    /*
    @GetMapping("hall/{number}")
    public ResponseEntity<Hall> getHall(@PathVariable("number") String number){
        Hall hall = hallService.get(number);
        if(hall == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(hall, HttpStatus.OK); //200
    }
    */

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Hall> createHall(@RequestBody Hall hall){
        if(hall == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            hallService.save(hall);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Hall> modifyHall(@PathVariable("id") Integer id, @RequestBody Hall hall){
        if(hall == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            hallService.update(id, hall);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Hall> deleteHall(@PathVariable("id") Integer id){
        try {
            hallService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Hall>> getAllHalls(){
        List<Hall> users = hallService.list();
        return new ResponseEntity<>(users, HttpStatus.OK); //200
    }
}
