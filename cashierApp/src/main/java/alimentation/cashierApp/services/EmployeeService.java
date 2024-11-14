package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.EmployeeRepository;
import alimentation.cashierApp.exception.CashierAppException;
import alimentation.cashierApp.models.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Add methods for employee-related operations here
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        if (id <= 0) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Invalid employee ID");
        }
        Optional<Employee> response = employeeRepository.findById(id);
        if (response.isEmpty()) {
            throw new CashierAppException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return response.get();
    }

    public Employee getEmployeeByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Invalid employee name");
        }
        Employee employee = employeeRepository.findByName(name);
        if (employee == null) {
            throw new CashierAppException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Invalid employee data");
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        if (employee == null || employee.getIdNumber() <= 0 || employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Invalid employee data");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        if (id <= 0) {
            throw new CashierAppException(HttpStatus.BAD_REQUEST, "Invalid employee ID");
        }
        Optional<Employee> target = employeeRepository.findById(id);
        if (target.isEmpty()) {
            throw new CashierAppException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }
}
