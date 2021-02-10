package com.tp.dealership.persistence;

import com.tp.dealership.models.Car;

import java.util.List;

public interface DealerDao {
    public List<Car> getCollection();
    public Car addCar(Car toAdd);

    public Car editCar(Car toAdd);
    public void deleteCar(Integer id);

    public Car getById(Integer id);
}
