package com.example.controller;

import com.example.model.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MessageController {

    private AtomicLong counter = new AtomicLong();
    private final String message = "Hello world";

    @RequestMapping("/")
    public Message message() {
        return new Message(counter.incrementAndGet(), message);
    }
}
