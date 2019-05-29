package com.example.controller;

import com.example.model.Show;
import com.example.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show/")
public class ShowController {

    @Autowired
    private ShowService showService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<Show> getShow(@PathVariable("id") Integer id){
        Show show = showService.get(id);
        if(show == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(show, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Show> createShow(@RequestBody Show show){
        if(show == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            showService.save(show);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Show> modifyShow(@PathVariable("id") Integer id, @RequestBody Show show){
        if(show == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            showService.update(id, show);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Show> deleteShow(@PathVariable("id") Integer id){
        try {
            showService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Show>> getAllShows(){
        List<Show> users = showService.list();
        return new ResponseEntity<>(users, HttpStatus.OK); //200
    }
}
