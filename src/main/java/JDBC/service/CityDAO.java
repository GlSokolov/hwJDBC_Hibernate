package JDBC.service;

import JDBC.pojo.City;
import JDBC.pojo.Employee;

import java.util.List;

public interface CityDAO {

    City addCity (City newCity);
    City getById (int id);
    List<City> getAll();
}
