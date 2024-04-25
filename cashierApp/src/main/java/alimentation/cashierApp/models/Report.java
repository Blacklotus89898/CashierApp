/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/
package alimentation.cashierApp.models;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Time;

// line 47 "t.ump"
@Entity
public class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Attributes
  @Id
  private int idNumber;
  private Date date;
  private Time start;
  private Time end;

  //Report Associations  
  @ManyToOne
  private Employee employee;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(int aIdNumber, Date aDate, Time aStart, Time aEnd, Employee aEmployee)
  {
    idNumber = aIdNumber;
    date = aDate;
    start = aStart;
    end = aEnd;
    if (!setEmployee(aEmployee))
    {
      throw new RuntimeException("Unable to create Report due to aEmployee. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Report() {
    //TODO Auto-generated constructor stub
  }

  public boolean setIdNumber(int aIdNumber)
  {
    boolean wasSet = false;
    idNumber = aIdNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStart(Time aStart)
  {
    boolean wasSet = false;
    start = aStart;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnd(Time aEnd)
  {
    boolean wasSet = false;
    end = aEnd;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStart()
  {
    return start;
  }

  public Time getEnd()
  {
    return end;
  }
  /* Code from template association_GetOne */
  public Employee getEmployee()
  {
    return employee;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setEmployee(Employee aNewEmployee)
  {
    boolean wasSet = false;
    if (aNewEmployee != null)
    {
      employee = aNewEmployee;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    employee = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "start" + "=" + (getStart() != null ? !getStart().equals(this)  ? getStart().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "end" + "=" + (getEnd() != null ? !getEnd().equals(this)  ? getEnd().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null");
  }
}