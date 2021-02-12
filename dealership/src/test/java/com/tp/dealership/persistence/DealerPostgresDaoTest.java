package com.tp.dealership.persistence;


import com.tp.dealership.exceptions.InvalidIdException;
import com.tp.dealership.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("daoTesting")
public class DealerPostgresDaoTest {

    @Autowired
    DealerPostgressDao toTest;

    @Autowired
    JdbcTemplate template;

    @BeforeEach
    public void setup(){
        //
        template.update("TRUNCATE \"car collection\" RESTART IDENTITY; ");//the table with double quotes just do it from pgadmin

        //only have one table so no need to update or clear any other table but this one
    }


    @Test
    public void getById() throws InvalidIdException {
        Car toAdd = new Car();
        toAdd.setMake("Honda");
        toAdd.setModel("NSX");
        toAdd.setYear(2002);
        toAdd.setMiles(10000);
        toAdd.setColor("white");
        toAdd.setOwners(1);
        toAdd.setPassedInspec(true);
        toAdd.setVin("UNIQUE");
        toAdd.setPrice(40000.00);


        Car returned = toTest.addCar(toAdd);
        assertEquals(1, toTest.getById(1).getId());
    }



    @Test
    public void addCarTest() throws InvalidIdException {
        Car toAdd = new Car();
        toAdd.setMake("Honda");
        toAdd.setModel("NSX");
        toAdd.setYear(2002);
        toAdd.setMiles(10000);
        toAdd.setColor("white");
        toAdd.setOwners(1);
        toAdd.setPassedInspec(true);
        toAdd.setVin("UNIQUE");
        toAdd.setPrice(40000.00);


        Car returned = toTest.addCar(toAdd);
        int id = returned.getId();
        assertEquals(1, toTest.getById(id).getId());
        assertEquals("Honda", toTest.getById(id).getMake());
        assertEquals("NSX", toTest.getById(id).getModel());
        assertEquals(2002, toTest.getById(id).getYear());
        assertEquals(10000, toTest.getById(id).getMiles());
        assertEquals("white", toTest.getById(id).getColor());
        assertEquals(1, toTest.getById(id).getOwners());
        assertEquals(true, toTest.getById(id).isPassedInspec());
        assertEquals("UNIQUE", toTest.getById(id).getVin());
        assertEquals(40000.00, toTest.getById(id).getPrice());

    }


    @Test
    public void editCarTest() throws InvalidIdException {
        Car original = new Car();
        original.setMake("Honda");
        original.setModel("NSX");
        original.setYear(2002);
        original.setMiles(10000);
        original.setColor("white");
        original.setOwners(1);
        original.setPassedInspec(true);
        original.setVin("UNIQUE");
        original.setPrice(40000.00);


        Car editedCar = new Car();
        editedCar.setId(1);
        editedCar.setMake("Toyota");
        editedCar.setModel("Corolla");
        editedCar.setYear(2008);
        editedCar.setMiles(50000);
        editedCar.setColor("blue");
        editedCar.setOwners(2);
        editedCar.setPassedInspec(true);
        editedCar.setVin("MadeUpVin");
        editedCar.setPrice(8000.00);


        Car returned = toTest.addCar(original);
        int id = returned.getId();
        Car toCheck = toTest.editCar(editedCar);
        assertEquals(1, toTest.getById(id).getId());
        assertEquals("Toyota", toTest.getById(id).getMake());
        assertEquals("Corolla", toTest.getById(id).getModel());
        assertEquals(2008, toTest.getById(id).getYear());
        assertEquals(50000, toTest.getById(id).getMiles());
        assertEquals("blue", toTest.getById(id).getColor());
        assertEquals(2, toTest.getById(id).getOwners());
        assertEquals(true, toTest.getById(id).isPassedInspec());
        assertEquals("MadeUpVin", toTest.getById(id).getVin());
        assertEquals(8000.00, toTest.getById(id).getPrice());
    }


    //test delete
    @Test
    public void deleteCarTest(){
        Car original = new Car();
        original.setMake("Honda");
        original.setModel("NSX");
        original.setYear(2002);
        original.setMiles(10000);
        original.setColor("white");
        original.setOwners(1);
        original.setPassedInspec(true);
        original.setVin("UNIQUE");
        original.setPrice(40000.00);

        Car returned = toTest.addCar(original);

        toTest.deleteCar(1);
        int id = returned.getId();
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getId());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getMake());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getModel());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getYear());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getMiles());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getColor());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getOwners());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).isPassedInspec());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getVin());
        assertThrows(EmptyResultDataAccessException.class,() -> toTest.getById(id).getPrice());

    }


}
