package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /*
   SELECT via GET
    */
    @GetMapping("{id_user}")
    public ResponseEntity<List<Account>> getOwnAccounts(@PathVariable("id_user") Integer id_user){
        List<Account> ownAccounts = accountService.get(id_user);
        return new ResponseEntity<>(ownAccounts, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    /*
    @PostMapping("")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        if(account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            accountService.save(account);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }
     */

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Account> modifyAccount(@PathVariable("id") Integer id, @RequestBody Account account){
        if(account == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            accountService.update(id, account);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    /*
    @DeleteMapping("{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") Integer id){
        try {
            accountService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }
     */

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> accounts = accountService.list();
        return new ResponseEntity<>(accounts, HttpStatus.OK); //200
    }
}
