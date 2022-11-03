package dao;

import java.util.List;

import dto.Employee;
import exception.EmployeeNotFoundException;

public interface EmployeeDAO {

    // credentials
    public static final String URL = "jdbc:mysql://localhost:3306/employee_database";
    public static final String USER = "root";
    public static final String PASSWORD = "64885986";

    List<Employee> findAllEmployees() throws EmployeeNotFoundException;

    void addEmployee(Employee e);

    void deleteEmployee(int id);

    Employee findEmployee(int id) throws EmployeeNotFoundException;

    void updateEmployee(Employee e);
}
