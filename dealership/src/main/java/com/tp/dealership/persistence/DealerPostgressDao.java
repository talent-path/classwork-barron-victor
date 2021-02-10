package com.tp.dealership.persistence;

import com.tp.dealership.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class DealerPostgressDao implements DealerDao{

    @Autowired
    JdbcTemplate template;

    @Override
    public List<Car> getCollection(){
        List<Car> collection = template.query("SELECT id, make, model, miles, color, year, owners, passinspec, vin, price\n" +
                "\tFROM public.\"car collection\";", new CarMapper());

        return collection;
    }

    @Override
    public Car addCar(Car toAdd){

        //providing the ? for values to then add values into data to avoid sql injection.
        Integer id = template.queryForObject("INSERT INTO \"car collection\"(\n" +
                "\tmake, model, miles, color, year, owners, passinspec, vin, price)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING \"id\";", new CarIdMapper(), toAdd.getMake(), toAdd.getModel(), toAdd.getMiles(), toAdd.getColor(),
                toAdd.getYear(),toAdd.getOwners(),toAdd.isPassedInspec(),toAdd.getVin(), toAdd.getPrice());

        toAdd.setId(id);
        return toAdd;
    }

    @Override
    public Car editCar(Car toAdd) {
        Integer id = template.queryForObject("UPDATE public.\"car collection\"\n" +
                        "\tSET make=?, model=?, miles=?, color=?, year=?, owners=?, passinspec=?, vin=?, price=?\n" +
                        "\tWHERE id= ? RETURNING \"id\";", new CarIdMapper(), toAdd.getMake(), toAdd.getModel(), toAdd.getMiles(), toAdd.getColor(),
                toAdd.getYear(),toAdd.getOwners(),toAdd.isPassedInspec(),toAdd.getVin(), toAdd.getPrice(),toAdd.getId());

        toAdd.setId(id);
        return toAdd;
    }




    class CarMapper implements RowMapper<Car>{

        @Override
        public Car mapRow(ResultSet resultSet, int i) throws SQLException {
            Car mappedCar = new Car();
            mappedCar.setId(resultSet.getInt("id"));
            mappedCar.setMake(resultSet.getString("make") );
            mappedCar.setModel(resultSet.getString("model"));
            mappedCar.setColor(resultSet.getString("color"));
            mappedCar.setYear(resultSet.getInt("year"));
            mappedCar.setOwners(resultSet.getInt("owners"));
            mappedCar.setMiles(resultSet.getInt("miles"));
            mappedCar.setPassedInspec(resultSet.getBoolean("passinspec"));
            mappedCar.setVin(resultSet.getString("vin"));
            mappedCar.setPrice(resultSet.getInt("price"));

            return mappedCar;
        }

    }

    class CarIdMapper implements RowMapper<Integer>{

        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("id");
        }
    }


}
