/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 54 "t.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private int idNumber;
  private String name;
  private String privilege;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(int aIdNumber, String aName, String aPrivilege)
  {
    idNumber = aIdNumber;
    name = aName;
    privilege = aPrivilege;
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrivilege(String aPrivilege)
  {
    boolean wasSet = false;
    privilege = aPrivilege;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public String getName()
  {
    return name;
  }

  public String getPrivilege()
  {
    return privilege;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "name" + ":" + getName()+ "," +
            "privilege" + ":" + getPrivilege()+ "]";
  }
}