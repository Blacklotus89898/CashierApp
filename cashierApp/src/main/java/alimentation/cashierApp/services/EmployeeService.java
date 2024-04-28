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
    public Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> response = employeeRepository.findById(id);
        if (response.isEmpty()) {
            throw new CashierAppException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        return response.get();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id){ //cannot delete employee if they have a report 
        Optional<Employee> target = employeeRepository.findById(id);
        if (target.get() == null) {
            throw new CashierAppException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        employeeRepository.deleteById(id);
    }
}
