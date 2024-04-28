package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Report;
import java.sql.Date;
import java.sql.Time;

public class ReportDto {

    private int idNumber;
    private Date date;
    private Time start;
    private Time end;
    private int employeeId;

    // Constructors
    public ReportDto() {}

    public ReportDto(int idNumber, Date date, Time start, Time end, int employeeId) { 
        this.idNumber = idNumber;
        this.date = date;
        this.start = start;
        this.end = end;
        this.employeeId = employeeId;
    }

    public ReportDto(Report report) {
        this.idNumber = report.getIdNumber();
        this.date = report.getDate();
        this.start = report.getStart();
        this.end = report.getEnd();
        this.employeeId = report.getEmployee().getIdNumber();
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}