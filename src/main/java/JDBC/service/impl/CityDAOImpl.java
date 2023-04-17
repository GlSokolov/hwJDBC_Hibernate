package JDBC.service.impl;

import JDBC.connection.Config;
import JDBC.pojo.City;
import JDBC.pojo.Employee;
import JDBC.service.CityDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    @Override
    public City addCity (City newCity) {
        try (Session session = Config.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.save(newCity);

            transaction.commit();

            return newCity;
        }
    }

    @Override
    public City getById(int id) {
        try (Session session = Config.getSessionFactory().openSession()) {
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> getAll() {
        try (Session session = Config.getSessionFactory().openSession()) {
            return session.createQuery("FROM City").list();
        }

    }

}
