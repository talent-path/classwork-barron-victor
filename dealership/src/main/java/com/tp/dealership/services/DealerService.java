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


    public Car addCar(Car toAdd) throws InvalidInputException{
        if(toAdd.getMake().isBlank()){ throw new InvalidInputException("Make is empty"); }
        toAdd.setMake(toAdd.getMake().toLowerCase());
        if(toAdd.getModel().isBlank()){ throw new InvalidInputException("Model is empty"); }
        toAdd.setModel(toAdd.getModel().toLowerCase());
        if(toAdd.getColor().isBlank()){ throw new InvalidInputException("Color is empty");}
        toAdd.setColor(toAdd.getColor().toLowerCase());
        if(toAdd.getPrice() < 1000){throw new InvalidInputException("Price is too low");}
        if(toAdd.getVin().isBlank()){throw new InvalidInputException("Vin is empty");}
        toAdd.setVin(toAdd.getVin().toLowerCase());
        if(!(toAdd.getMiles() > 10 && toAdd.getMiles() < 200000) ){ }
        else{ throw new InvalidInputException("Miles are not within range"); }
        return dao.addCar(toAdd);
    }

    public Car editCar(Car toAdd) throws InvalidInputException {
        if(toAdd.getMake().isBlank()){ throw new InvalidInputException("Make is empty"); }
        toAdd.setMake(toAdd.getMake().toLowerCase());
        if(toAdd.getModel().isBlank()){ throw new InvalidInputException("Model is empty"); }
        toAdd.setModel(toAdd.getModel().toLowerCase());
        if(toAdd.getColor().isBlank()){ throw new InvalidInputException("Color is empty");}
        toAdd.setColor(toAdd.getColor().toLowerCase());
        if(toAdd.getPrice() < 1000){throw new InvalidInputException("Price is too low");}
        if(toAdd.getVin().isBlank()){throw new InvalidInputException("Vin is empty");}
        toAdd.setVin(toAdd.getVin().toLowerCase());
        if(!(toAdd.getMiles() > 10 && toAdd.getMiles() < 200000) ){ }
        else{ throw new InvalidInputException("Miles are not within range"); }
        return dao.editCar(toAdd);
    }


    public void deleteCar(Integer id) {
        //validate
        dao.deleteCar(id);

    }

    public Car getById(Integer id) {
        //validate this
        return dao.getById(id);
    }
}
