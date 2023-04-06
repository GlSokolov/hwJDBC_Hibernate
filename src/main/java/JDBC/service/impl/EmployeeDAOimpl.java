package JDBC.service.impl;

import JDBC.Application;
import JDBC.connection.Connection;
import JDBC.pojo.Employee;
import JDBC.service.EmployeeDAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee addEmployee(Employee newEmployee) {

        try (PreparedStatement statement = Connection.getConnetion()
                .prepareStatement("INSERT INTO employee (first_name, last_name, gender, age, city_id)" +
                "values ( (?), (?), (?), (?), (?) )") ) {

            statement.setString(1, newEmployee.getFirst_name());
            statement.setString(2, newEmployee.getLast_name());
            statement.setString(3, newEmployee.getGender());
            statement.setInt(4, newEmployee.getAge());
            statement.setInt(5, newEmployee.getCity_id());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newEmployee;
    }

    @Override
    public Employee getById(int id) {
        Employee neededEmployee = new Employee("", "", "", 0 , 0);

        try (PreparedStatement statement = Connection.getConnetion()
                .prepareStatement("SELECT * FROM employee WHERE id = (?) ")) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                neededEmployee.setId(result.getInt(1));
                neededEmployee.setFirst_name(result.getString("first_name"));
                neededEmployee.setLast_name(result.getString("last_name"));
                neededEmployee.setGender(result.getString("gender"));
                neededEmployee.setAge(result.getInt(5));
                neededEmployee.setCity_id(result.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return neededEmployee;
    }

    @Override
    public List<Employee> getAll() {

        try (PreparedStatement statement = Connection.getConnetion()
                .prepareStatement("SELECT * FROM employee")) {

            ResultSet result = statement.executeQuery();

            while (result.next()){
//                int id = result.getInt("id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String gender = result.getString("gender");
                int age = result.getInt("age");
                int cityId = result.getInt("city_id");

                employeeList.add(new Employee(firstName, lastName, gender, age, cityId));
            }

        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public String updateEmployeeById(int id, Employee updEmployee) {

        try (PreparedStatement statement = Connection.getConnetion()
                .prepareStatement("UPDATE employee SET first_name = (?)" +
                        ", last_name = (?), gender = (?), age = (?), city_id = (?)" +
                        "WHERE id = (?)")) {

            statement.setString(1, updEmployee.getFirst_name());
            statement.setString(2, updEmployee.getLast_name());
            statement.setString(3, updEmployee.getGender());
            statement.setInt(4, updEmployee.getAge());
            statement.setInt(5, updEmployee.getCity_id());
            statement.setInt(6, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Запись обновлена";
    }

    @Override
    public String deleteEmployeeDyId(int id) {

        try (PreparedStatement statement = Connection.getConnetion()
                .prepareStatement("DELETE FROM employee WHERE id = (?) ")) {

            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
             e.printStackTrace();
        }
        return "Запись удалена";
    }
}
