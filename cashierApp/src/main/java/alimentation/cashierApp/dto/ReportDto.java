package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Report;
import alimentation.cashierApp.models.Employee;
import java.sql.Date;
import java.sql.Time;

public class ReportDto {

    private int idNumber;
    private Date date;
    private Time start;
    private Time end;
    private EmployeeDto employee;

    // Constructors
    public ReportDto() {}

    public ReportDto(int idNumber, Date date, Time start, Time end, EmployeeDto employee) {
        this.idNumber = idNumber;
        this.date = date;
        this.start = start;
        this.end = end;
        this.employee = employee;
    }

    public ReportDto(Report report) {
        this.idNumber = report.getIdNumber();
        this.date = report.getDate();
        this.start = report.getStart();
        this.end = report.getEnd();
        Employee employee = report.getEmployee();
        this.employee = new EmployeeDto(employee.getIdNumber(), employee.getName(), employee.getPrivilege()); 
        //error due to triangle dependency import
    }

    // Getters and Setters
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public Report toReport() {
        // Employee employee = new Employee(this.employee.getIdNumber(), this.employee.getName(), this.employee.getPrivilege());
        return new Report(idNumber, date, start, end, employee.toEmployee());
        // return new Report(this.idNumber, this.date, this.start, this.end, new Employee(this.employee.getIdNumber(), this.employee.getName(), this.employee.getPrivilege()));
    }
}