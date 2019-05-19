package com.example.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This class was created for testing of Tomcat's successful launch
 */
@RestController
public class TestController {

    private AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public long printSomething() {
        return counter.incrementAndGet();
    }
}
