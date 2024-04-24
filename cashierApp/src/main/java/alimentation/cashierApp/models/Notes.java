/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.sql.Time;

// line 31 "t.ump"
public class Notes
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Notes Attributes
  private int idNumber;
  private String message;
  private Time time;

  //Notes Associations
  private Report report;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Notes(int aIdNumber, String aMessage, Time aTime, Report aReport)
  {
    idNumber = aIdNumber;
    message = aMessage;
    time = aTime;
    boolean didAddReport = setReport(aReport);
    if (!didAddReport)
    {
      throw new RuntimeException("Unable to create note due to report. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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
  /* Code from template association_SetOneToMany */
  public boolean setReport(Report aReport)
  {
    boolean wasSet = false;
    if (aReport == null)
    {
      return wasSet;
    }

    Report existingReport = report;
    report = aReport;
    if (existingReport != null && !existingReport.equals(aReport))
    {
      existingReport.removeNote(this);
    }
    report.addNote(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Report placeholderReport = report;
    this.report = null;
    if(placeholderReport != null)
    {
      placeholderReport.removeNote(this);
    }
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