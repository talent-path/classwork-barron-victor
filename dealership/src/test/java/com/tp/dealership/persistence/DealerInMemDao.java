package com.tp.dealership.persistence;

import com.tp.dealership.controllers.SearchfilterParameters;
import com.tp.dealership.models.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("serviceTest")
public class DealerInMemDao implements DealerDao {

    @Override
    public List<Car> getCollection() {
        return null;
    }

    @Override
    public Car addCar(Car toAdd) {
        return toAdd;
    }

    @Override
    public Car editCar(Car toAdd) {
        return toAdd;
    }

    @Override
    public void deleteCar(Integer id) {

    }

    @Override
    public Car getById(Integer id) {
        return null;
    }

    @Override
    public List<Car> filterSearch(SearchfilterParameters toSearch) {
        return null;
    }
}
