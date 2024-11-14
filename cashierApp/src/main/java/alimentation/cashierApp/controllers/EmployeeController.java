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

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        try {
            List<Employee> employees = (List<Employee>) employeeService.getAllEmployees();
            List<EmployeeDto> employeeDtos = employees.stream()
                    .map(EmployeeDto::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(employeeDtos);
        } catch (Exception e) {
            EmployeeDto errorDto = new EmployeeDto();
            errorDto.setName("Error: " + e.getMessage());
            List<EmployeeDto> errorList = List.of(errorDto);
            return ResponseEntity.status(500).body(errorList);
        }
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> getEmployeeById(@RequestParam("id") int id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return ResponseEntity.ok(new EmployeeDto(employee));
        } catch (Exception e) {
            EmployeeDto errorDto = new EmployeeDto();
            errorDto.setName("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @GetMapping("/name")
    public ResponseEntity<EmployeeDto> getEmployeeByName(@RequestParam("name") String name) {
        try {
            Employee employee = employeeService.getEmployeeByName(name);
            return ResponseEntity.ok(new EmployeeDto(employee));
        } catch (Exception e) {
            EmployeeDto errorDto = new EmployeeDto();
            errorDto.setName("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        try {
            Employee employee = employeeService.updateEmployee(employeeDto.toEmployee());
            return ResponseEntity.ok(new EmployeeDto(employee));
        } catch (Exception e) {
            EmployeeDto errorDto = new EmployeeDto();
            errorDto.setName("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(errorDto);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@RequestParam("id") int id) {
        try {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllEmployees() {
        try {
            employeeService.deleteAllEmployees();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}