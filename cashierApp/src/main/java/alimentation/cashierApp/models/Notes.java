/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package alimentation.cashierApp.models;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Notes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Notes Attributes
  @Id
  private int idNumber;
  private String message;
  private Time time;

  //Notes Associations
  @ManyToOne
  private Report report;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Notes(int aIdNumber, String aMessage, Time aTime, Report aReport)
  {
    idNumber = aIdNumber;
    message = aMessage;
    time = aTime;
    if (!setReport(aReport))
    {
      throw new RuntimeException("Unable to create Notes due to aReport. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Notes() {
    //TODO Auto-generated constructor stub
  }

  public boolean setIdNumber(int aIdNumber)
  {
    boolean wasSet = false;
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setMessage(String aMessage)
  {
    boolean wasSet = false;
    message = aMessage;
    wasSet = true;
    return wasSet;
  }

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public String getMessage()
  {
    return message;
  }

  public Time getTime()
  {
    return time;
  }
  /* Code from template association_GetOne */
  public Report getReport()
  {
    return report;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setReport(Report aNewReport)
  {
    boolean wasSet = false;
    if (aNewReport != null)
    {
      report = aNewReport;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    report = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "message" + ":" + getMessage()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "report = "+(getReport()!=null?Integer.toHexString(System.identityHashCode(getReport())):"null");
  }
}