package com.example.controller;

import com.example.model.Payments;
import com.example.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments/")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    /*
   SELECT via GET
    */
    @GetMapping("{id}")
    public ResponseEntity<List<Payments>> getOwnPayments(@PathVariable("id") Integer id_user){
        List<Payments> payments = paymentsService.get(id_user);
        return new ResponseEntity<>(payments, HttpStatus.OK); //200
    }

    /*
    INSERT via POST
     */
    @PostMapping("")
    public ResponseEntity<Payments> createPayment(@RequestBody Payments payments){
        if(payments == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            paymentsService.save(payments);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    UPDATE via PUT
     */
    @PutMapping("{id}")
    public ResponseEntity<Payments> modifyPayment(@PathVariable("id") Integer id, @RequestBody Payments payments){
        if(payments == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
        }
        try {
            paymentsService.update(id, payments);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    DELETE via DELETE
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Payments> deletePayment(@PathVariable("id") Integer id){
        try {
            paymentsService.delete(id);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY); //422
        }
        return new ResponseEntity<>(HttpStatus.OK); //200
    }

    /*
    SELECT * via GET
     */
    @GetMapping("")
    public ResponseEntity<List<Payments>> getAllPayments(){
        List<Payments> payments = paymentsService.list();
        return new ResponseEntity<>(payments, HttpStatus.OK); //200
    }
}
