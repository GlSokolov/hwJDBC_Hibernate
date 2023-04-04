package JDBC.service;

import JDBC.pojo.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee addEmployee (Employee newEmployee);
    Employee getById (int id);
    List<Employee> getAll();
    String updateEmployeeById (int id, Employee employee);
    String deleteEmployeeDyId (int id);

}
