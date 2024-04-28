package alimentation.cashierApp.dto;

import java.sql.Time;

import alimentation.cashierApp.models.Transaction;
import alimentation.cashierApp.models.Transaction.TransactionType;  //not ideal immport


public class TransactionDto {

    private int idNumber;
    private Time time;
    private TransactionType transactiontype;
    private int reportId; //change beack to reportIdId

    public TransactionDto(int idNumber, Time time, TransactionType transactiontype, int reportId) {
        this.idNumber = idNumber;
        this.time = time;
        this.transactiontype = transactiontype;
        this.reportId = reportId;
    }

    public TransactionDto(Transaction transaction) {
        this.idNumber = transaction.getIdNumber();
        this.time = transaction.getTime();
        this.transactiontype = transaction.getTransactiontype();
        this.reportId = transaction.getReport().getIdNumber();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public TransactionType getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(TransactionType transactiontype) {
        this.transactiontype = transactiontype;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    // public Transaction toTransaction() { //not possible, will be performed in the controller
    //     return new Transaction(this.idNumber, this.time, this.transactiontype, this.reportId);
    // }
}