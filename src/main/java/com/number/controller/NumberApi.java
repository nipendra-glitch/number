package com.number.controller;

import com.number.entity.User;
import com.number.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/v1")
public class NumberApi {

    private AtomicInteger count = new AtomicInteger(1);

    @Autowired
    NumberService numberService;

    @GetMapping("/user")
    public User getUser(@RequestParam Long id) {
        return numberService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser() {

        return numberService.addUser();

    }



    @PutMapping("/user")
    public void incrementUserNumber(@RequestParam Long id) {
//        System.out.println("count1: "+count.getAndIncrement());
         numberService.incrementUserNumber(id);
    }
}
