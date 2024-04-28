/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/
package alimentation.cashierApp.models;


import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
  @Id // make it generated automatically
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idNumber; //unique id, duplicate is updated
  
  private Date date;
  private Time start_time;
  private Time end_time;

  //Report Associations  
  @ManyToOne
  private Employee employee; //db only checks for the employee id

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(int aIdNumber, Date aDate, Time aStart, Time aEnd, Employee aEmployee)
  {
    idNumber = aIdNumber;
    date = aDate;
    start_time = aStart;
    end_time = aEnd;
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
    start_time = aStart;
    wasSet = true;
    return wasSet;
  }

  public boolean setEnd(Time aEnd)
  {
    boolean wasSet = false;
    end_time = aEnd;
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
    return start_time;
  }

  public Time getEnd()
  {
    return end_time;
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
            "  " + "end_time" + "=" + (getEnd() != null ? !getEnd().equals(this)  ? getEnd().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "employee = "+(getEmployee()!=null?Integer.toHexString(System.identityHashCode(getEmployee())):"null");
  }
}