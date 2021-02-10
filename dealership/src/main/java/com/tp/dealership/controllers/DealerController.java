package com.tp.dealership.controllers;

import com.tp.dealership.models.Car;
import com.tp.dealership.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DealerController {

    @Autowired
    DealerService service;

    @PostMapping("/addcar")
    public ResponseEntity addcar(@RequestBody Car toAdd){
        Car completed = service.addCar(toAdd);
        return ResponseEntity.ok(completed);
    }

    @GetMapping("/allvehicles")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getCollection());
    }

    @PutMapping("/editinventory")
    public ResponseEntity editCar(@RequestBody Car toAdd){
        Car completed = service.editCar(toAdd);
        return ResponseEntity.ok(completed);
    }


}