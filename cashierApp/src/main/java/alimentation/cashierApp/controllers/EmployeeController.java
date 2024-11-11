package alimentation.cashierApp.controllers;

import alimentation.cashierApp.dto.EmployeeDto;
import alimentation.cashierApp.models.Employee;
import alimentation.cashierApp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
    // @PostMapping
    // public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
    //     Employee employee = employeeService.createEmployee(employeeDto.toEmployee());
    //     return ResponseEntity.ok(new EmployeeDto(employee));
    // }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<Employee> employees = (List<Employee>) employeeService.getAllEmployees();
        List<EmployeeDto> employeeDtos = employees.stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employeeDtos);
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam("id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(new EmployeeDto(employee));
    }

    @GetMapping("/name")
    public ResponseEntity<EmployeeDto> getEmployeeByName(@RequestParam("name") String name) {
        Employee employee = employeeService.getEmployeeByName(name);
        return ResponseEntity.ok(new EmployeeDto(employee));
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeDto.toEmployee());
        return ResponseEntity.ok(new EmployeeDto(employee));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEmployee(@RequestParam("id") int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.noContent().build();
    }

    // private EmployeeDto toEmployeeDto(Employee employee) {
    //     return new EmployeeDto(employee.getIdNumber(), employee.getName(), employee.getPrivilege());
    // }

    // private Employee toEmployee(EmployeeDto employeeDto) {
    //     return new Employee(employeeDto.getIdNumber(), employeeDto.getName(), employeeDto.getPrivilege());
    // }
}