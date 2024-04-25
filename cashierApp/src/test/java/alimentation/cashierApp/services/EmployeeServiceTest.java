package alimentation.cashierApp.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

import alimentation.cashierApp.dao.EmployeeRepository;
import alimentation.cashierApp.models.Employee;

@SpringBootTest
public class EmployeeServiceTest {

    final static Employee MockEmployee = new Employee(0, null, null);

    @BeforeAll
    public static void setUp() {
        MockEmployee.setIdNumber(1);
        MockEmployee.setName("John Doe");
        MockEmployee.setPrivilege("Cashier");
    }

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testGetAllEmployees() {
        employeeService.getAllEmployees();
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testAddEmployee() {
        employeeService.addEmployee(MockEmployee);
        verify(employeeRepository, times(1)).save(MockEmployee);
    }
    
    @Test
    public void testGetEmployeeById() {
        int id = 1;
        employeeService.getEmployeeById(id);
        verify(employeeRepository, times(1)).findById(id);
    }


    @Test
    public void testUpdateEmployee() {
        employeeService.updateEmployee(MockEmployee);
        verify(employeeRepository, times(1)).save(MockEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 1;
        employeeService.deleteEmployee(id);
        verify(employeeRepository, times(1)).deleteById(id);
    }
}
