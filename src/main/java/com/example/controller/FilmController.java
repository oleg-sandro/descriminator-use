package com.example.controller;

import com.example.model.Film;
import com.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film/")
public class FilmController {

    @Autowired
    private FilmService filmService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<Film> getFilm(@PathVariable("id") Integer id){
        Film film = filmService.get(id);
        if(film == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(film, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Film> createFilm(@RequestBody Film film){
        if(film == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            filmService.save(film);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Film> modifyFilm(@PathVariable("id") Integer id, @RequestBody Film film){
        if(film == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            filmService.update(id, film);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable("id") Integer id){
        try {
            filmService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Film>> getAllFilms(){
        List<Film> users = filmService.list();
        return new ResponseEntity<>(users, HttpStatus.OK); //200
    }
}
