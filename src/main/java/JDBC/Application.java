package JDBC;


import JDBC.pojo.Employee;
import JDBC.service.EmployeeDAO;
import JDBC.service.impl.EmployeeDAOimpl;

import java.sql.*;

public class Application {
    public static void main(String[] args) {
//
        EmployeeDAO employeeDAO = new EmployeeDAOimpl();

//        System.out.println( employeeDAO.addEmployee(new Employee()));
        System.out.println("============================");
//        System.out.println(employeeDAO.getById(1));
        System.out.println("============================");
//        System.out.print(employeeDAO.getAll());
        System.out.println("============================");
//        System.out.println(employeeDAO.updateEmployeeById(41, new Employee()));
        System.out.println("============================");
//        System.out.println(employeeDAO.deleteEmployeeDyId(24));
    }
}
