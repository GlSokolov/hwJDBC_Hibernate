package JDBC;


import JDBC.pojo.Employee;
import JDBC.service.EmployeeDAO;
import JDBC.service.impl.EmployeeDAOimpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
//
        System.out.println("============================");
        System.out.println("============================");

        EmployeeDAO employeeDAO = new EmployeeDAOimpl();

        System.out.println( employeeDAO.addEmployee(new Employee("Gleb", "Sokolov", "male", 24, 1)));
        System.out.println("============================");
        System.out.println(employeeDAO.getById(1));
        System.out.println("============================");
        System.out.print(employeeDAO.getAll());
        System.out.println("============================");
        System.out.println(employeeDAO.updateEmployeeById(41, new Employee("Alexander", "Nekrasov", "male", 36, 6)));
        System.out.println("============================");
        System.out.println(employeeDAO.deleteEmployeeDyId(24));

    }
    


}
