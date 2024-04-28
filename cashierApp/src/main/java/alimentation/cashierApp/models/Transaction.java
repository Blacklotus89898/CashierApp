package alimentation.cashierApp.models;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// line 23 "t.ump"
@Entity
public class Transaction {

  // ------------------------
  // ENUMERATIONS
  // ------------------------

  public enum TransactionType {
    Payment, Cancellation
  }

  // ------------------------
  // MEMBER VARIABLES
  // ------------------------

  // Transaction Attributes
  @Id
  private int idNumber;
  private Time time;
  private TransactionType transactiontype;

  // Transaction Associations
  @ManyToOne
  private Report report;

  // ------------------------
  // CONSTRUCTOR
  // ------------------------
  public Transaction() {
    // TODO Auto-generated constructor stub
  }

  public Transaction(int aIdNumber, Time aTime, TransactionType aTransactiontype, Report aReport) {
    idNumber = aIdNumber;
    time = aTime;
    transactiontype = aTransactiontype;
    if (!setReport(aReport)) {
      throw new RuntimeException(
          "Unable to create Transaction due to aReport. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  // ------------------------
  // INTERFACE
  // ------------------------

  public boolean setIdNumber(int aIdNumber) {
    boolean wasSet = false;
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime) {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransactiontype(TransactionType aTransactiontype) {
    boolean wasSet = false;
    transactiontype = aTransactiontype;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber() {
    return idNumber;
  }

  public Time getTime() {
    return time;
  }

  public TransactionType getTransactiontype() {
    return transactiontype;
  }

  /* Code from template association_GetOne */
  public Report getReport() {
    return report;
  }

  /* Code from template association_SetUnidirectionalOne */
  public boolean setReport(Report aNewReport) {
    boolean wasSet = false;
    if (aNewReport != null) {
      report = aNewReport;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete() {
    report = null;
  }

  public String toString() {
    return super.toString() + "[" +
        "idNumber" + ":" + getIdNumber() + "]" + System.getProperties().getProperty("line.separator") +
        "  " + "time" + "="
        + (getTime() != null ? !getTime().equals(this) ? getTime().toString().replaceAll("  ", "    ") : "this"
            : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "transactiontype" + "="
        + (getTransactiontype() != null
            ? !getTransactiontype().equals(this) ? getTransactiontype().toString().replaceAll("  ", "    ") : "this"
            : "null")
        + System.getProperties().getProperty("line.separator") +
        "  " + "report = " + (getReport() != null ? Integer.toHexString(System.identityHashCode(getReport())) : "null");
  }
}