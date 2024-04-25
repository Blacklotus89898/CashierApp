package alimentation.cashierApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alimentation.cashierApp.dao.EmployeeRepository;
import alimentation.cashierApp.models.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    // Add methods for employee-related operations here
    Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    Employee getEmployeeById(int id){
        Optional<Employee> response = employeeRepository.findById(id);
        if (response.isPresent()) {
            return response.get();
        }
        return null;
    }

    void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
