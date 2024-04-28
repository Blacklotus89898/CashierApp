package alimentation.cashierApp.dto;

import java.sql.Time;

import alimentation.cashierApp.models.Notes;

public class NotesDto {

    private int idNumber;
    private String message;
    private Time time;
    private int reportId;

    public NotesDto(int idNumber, String message, Time time, int reportId) {
        this.idNumber = idNumber;
        this.message = message;
        this.time = time;
        this.reportId = reportId;
    }

    public NotesDto(Notes notes) {
        this.idNumber = notes.getIdNumber();
        this.message = notes.getMessage();
        this.time = notes.getTime();
        this.reportId = notes.getReport().getIdNumber();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }


}