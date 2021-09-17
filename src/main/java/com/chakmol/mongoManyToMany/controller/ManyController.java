package com.chakmol.mongoManyToMany.controller;

import com.chakmol.mongoManyToMany.model.User;
import com.chakmol.mongoManyToMany.repository.ManyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class ManyController {

    @Autowired
    private ManyRepository manyRepository;

    @PostMapping("/placeOrderNow")
    public String placeOrder(@RequestBody User user){
        manyRepository.save(user);
        return "Order placed succed";
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable("name") String name){
        return manyRepository.findByName(name);
    }

    @GetMapping("/getUserByAddress/{city}")
    public List<User> getUserByAddress(@PathVariable("city") String city){
        return manyRepository.findByCity(city);
    }
}
