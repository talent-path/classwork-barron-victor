package com.tp.dealership.persistence;


import com.tp.dealership.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

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
        template.update("TRUNCATE \"carcollection\" RESTART IDENTITY ");//the table with double quotes just do it from pgadmin

        //only have one table so no need to update or clear any other table but this one
    }


    @Test
    public void addCarGoldPathTest(){
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
        assertEquals(1,returned.getId());   //checks id
        assertEquals("Honda",returned.getMake());   //checks make
    }

}
