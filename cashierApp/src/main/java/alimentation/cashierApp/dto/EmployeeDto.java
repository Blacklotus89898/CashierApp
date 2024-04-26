package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Employee;

public class EmployeeDto {

    private int idNumber;
    private String name;
    private String privilege;

    // Constructors
    public EmployeeDto() {}

    public EmployeeDto(Employee employee) {
        this.idNumber = employee.getIdNumber();
        this.name = employee.getName();
        this.privilege = employee.getPrivilege();
    }
    
    public EmployeeDto(int idNumber, String name, String privilege) {
        this.idNumber = idNumber;
        this.name = name;
        this.privilege = privilege;
    }


    // Getters and Setters
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public Employee toEmployee() {
        return new Employee(this.idNumber, this.name, this.privilege);
    }
}