package com.tp.dealership.services;

import com.tp.dealership.exceptions.InvalidInputException;
import com.tp.dealership.models.Car;
import com.tp.dealership.persistence.DealerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@Component
public class DealerService {
    @Autowired
    DealerDao dao;

    public List<Car> getCollection(){ return dao.getCollection();}

//TODO check for wrong types for all
    //checks for
    //throws invalid for isBlank on Make,model,price,vin
    //throws invalid for range for miles,price, owners
    //changes all string inputs to lowercase
    public Car addCar(Car toAdd) throws InvalidInputException{
        if(!(toAdd.getYear() > 1950 && toAdd.getYear() < 2021)){throw new InvalidInputException("Year is not in range.");}
        if(toAdd.getMake().isBlank()){ throw new InvalidInputException("Make is empty."); }
        toAdd.setMake(toAdd.getMake().toLowerCase());
        if(toAdd.getModel().isBlank()){ throw new InvalidInputException("Model is empty."); }
        toAdd.setModel(toAdd.getModel().toLowerCase());
        if(toAdd.getColor().isBlank()){ throw new InvalidInputException("Color is empty.");}
        toAdd.setColor(toAdd.getColor().toLowerCase());
        if(toAdd.getPrice() < 1000){throw new InvalidInputException("Price is too low.");}
        if(toAdd.getVin().isBlank()){throw new InvalidInputException("Vin is empty.");}
        toAdd.setVin(toAdd.getVin().toLowerCase());
        if(!(toAdd.getMiles() > 10 && toAdd.getMiles() < 200000) ){throw new InvalidInputException("Miles are not within range."); }
        if(toAdd.getOwners() < 1){throw new InvalidInputException("Owners is incorrect");}
        return dao.addCar(toAdd);
    }

//TODO check for wrong types for all
    public Car editCar(Car toAdd) throws InvalidInputException {
        if(!(toAdd.getYear() > 1950 && toAdd.getYear() < 2021)){throw new InvalidInputException("Year is not in range.");}
        if(toAdd.getMake().isBlank()){ throw new InvalidInputException("Make is empty."); }
        toAdd.setMake(toAdd.getMake().toLowerCase());
        if(toAdd.getModel().isBlank()){ throw new InvalidInputException("Model is empty."); }
        toAdd.setModel(toAdd.getModel().toLowerCase());
        if(toAdd.getColor().isBlank()){ throw new InvalidInputException("Color is empty.");}
        toAdd.setColor(toAdd.getColor().toLowerCase());
        if(toAdd.getPrice() < 1000){throw new InvalidInputException("Price is too low.");}
        if(toAdd.getVin().isBlank()){throw new InvalidInputException("Vin is empty.");}
        toAdd.setVin(toAdd.getVin().toLowerCase());
        if(!(toAdd.getMiles() > 10 && toAdd.getMiles() < 200000) ){throw new InvalidInputException("Miles are not within range."); }
        if(toAdd.getOwners() < 1){throw new InvalidInputException("Owners is incorrect");}
        return dao.editCar(toAdd);
    }

// this one is okay if number is not in range or nonexistent
    public void deleteCar(Integer id) {
        //check to see if it exists?
        dao.deleteCar(id);

    }
//todo -- this one must check of number is in the database otherwise it will stack trace
    public Car getById(Integer id) {
        //check to see if it exists?
        return dao.getById(id);
    }
}
