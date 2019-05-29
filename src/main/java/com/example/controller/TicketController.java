package com.example.controller;

import com.example.model.Ticket;
import com.example.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket/")
public class TicketController {

//    @Autowired
//    private TicketService ticketService;
//
//    /*
//    SELECT via GET
//     */
//    @GetMapping("{id}")
//    public ResponseEntity<Ticket> getTicket(@PathVariable("id") Integer id){
//        Ticket ticket = ticketService.get(id);
//        if(ticket == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
//        }
//        return new ResponseEntity<>(ticket, HttpStatus.OK); //200
//    }
//
//    /*
//    INSERT via POST
//     */
//    @PostMapping("")
//    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
//        if(ticket == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); //400
//        }
//        try {
//            ticketService.save(ticket);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
//        }
//        return new ResponseEntity<>(HttpStatus.OK); //200
//    }
//
//    /*
//    SELECT * via GET
//     */
//    @GetMapping("")
//    public ResponseEntity<List<Ticket>> getAllTickets(){
//        List<Ticket> users = ticketService.list();
//        return new ResponseEntity<>(users, HttpStatus.OK); //200
//    }
}
