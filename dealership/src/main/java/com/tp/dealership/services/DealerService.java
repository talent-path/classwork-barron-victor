package com.tp.dealership.services;

import com.tp.dealership.models.Car;
import com.tp.dealership.persistence.DealerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class DealerService {
    @Autowired
    DealerDao dao;

    public List<Car> getCollection(){ return dao.getCollection();}


    public Car addCar(Car toAdd) {
        //validate entry
        return dao.addCar(toAdd);
    }
}
