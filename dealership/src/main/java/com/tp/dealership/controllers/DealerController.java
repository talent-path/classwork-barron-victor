package com.tp.dealership.controllers;

import com.tp.dealership.exceptions.InvalidInputException;
import com.tp.dealership.models.Car;
import com.tp.dealership.services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Car completed = null;
        try {
            completed = service.addCar(toAdd);
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(completed);
    }

    @GetMapping("/allvehicles")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getCollection());
    }

    @GetMapping("/searchbyid/{id}")
    public ResponseEntity getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/editinventory")
    public ResponseEntity editCar(@RequestBody Car toAdd){
        Car completed = null;
        try {
            completed = service.editCar(toAdd);
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.ok(completed);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id){
        service.deleteCar(id);
        return ResponseEntity.ok("Successful Delete");
    }



}
