package JDBC.service.impl;

import JDBC.connection.Config;
import JDBC.pojo.Employee;
import JDBC.service.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Table;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

    @Override
    public Employee addEmployee(Employee newEmployee) {
        try (Session session = Config.getSessionFactory().openSession()) {
//            Integer id;
            Transaction transaction = session.beginTransaction();

//            id = (Integer) session.save(newEmployee);
            session.save(newEmployee);

            transaction.commit();

            return newEmployee;
        }
    }

    @Override
    public Employee getById(int id) {
        try (Session session = Config.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAll() {
        try (Session session = Config.getSessionFactory().openSession()) {
            return session.createQuery("FROM Employee").list();
        }

    }

    @Override
    public String updateEmployeeById(int id, Employee updEmployee) {
        try (Session session = Config.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            updEmployee.setId(id);
            session.update(updEmployee);

            transaction.commit();

            return "Запись обновлена";
        }
    }

    @Override
    public String deleteEmployeeDyId(int id) {
        try (Session session = Config.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            session.delete(id);

            transaction.commit();

            return "Запись удалена";
        }
    }
}