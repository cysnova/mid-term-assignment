package service;

import java.util.List;

import dao.EmployeeDAO;
import dao.EmployeeDAOMysqlimpl;
import dto.Employee;
import exception.EmployeeNotFoundException;

public class EmployeeServiceimpl implements EmployeeService {

    public EmployeeDAO employeeDAO = new EmployeeDAOMysqlimpl();

    @Override
    public void addEmployee(Employee e) {
        employeeDAO.addEmployee(e);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public Employee findEmployee(int id) throws EmployeeNotFoundException {
        return employeeDAO.findEmployee(id);
    }

    public void updateEmployee(Employee e) {
        employeeDAO.updateEmployee(e);
    }

    @Override
    public List<Employee> findAllEmployees() throws EmployeeNotFoundException {
        return employeeDAO.findAllEmployees();
    }

}