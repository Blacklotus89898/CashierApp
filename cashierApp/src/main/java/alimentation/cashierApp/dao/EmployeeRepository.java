package alimentation.cashierApp.dao;
import org.springframework.data.repository.CrudRepository;

import alimentation.cashierApp.models.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    
}

