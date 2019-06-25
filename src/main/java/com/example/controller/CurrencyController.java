package com.example.controller;

import com.example.model.Currency;
import com.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency/")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    /*
    SELECT via GET
     */
    @GetMapping("{id}")
    public ResponseEntity<Currency> getCurrency(@PathVariable("id") Integer id){
        Currency currency = currencyService.get(id);
        if(currency == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }
        return new ResponseEntity<>(currency, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Currency> createCurrency(@RequestBody Currency currency){
        if(currency == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            currencyService.save(currency);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Currency> modifyCurrency(@PathVariable("id") Integer id, @RequestBody Currency currency){
        if(currency == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            currencyService.update(id, currency);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Currency> deleteCurrency(@PathVariable("id") Integer id){
        try {
            currencyService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Currency>> getAllDictionaries(){
        List<Currency> dictionaries = currencyService.list();
        return new ResponseEntity<>(dictionaries, HttpStatus.OK); //200
    }
}
