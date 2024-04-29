/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package alimentation.cashierApp.models;


import jakarta.persistence.Column;

// line 11 "t.ump"

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductType
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProductType Attributes
  @Id  
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idNumber;

  @Column(unique=true)
  private String name; //name shoud be unique

  private String description;
  private String productType; //should be an enum in future //rename as category, 
  // very costy operation for db 
  private float price;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  public ProductType()
  {
    //TODO Auto-generated constructor stub
  }
  public ProductType(int aIdNumber, String aName, String aDescription, String aProductType, float aPrice)
  {
    idNumber = aIdNumber;
    name = aName;
    description = aDescription;
    productType = aProductType;
    price = aPrice;
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

  public boolean setDescription(String aDescription)
  {
    boolean wasSet = false;
    description = aDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setProductType(String aProductType)
  {
    boolean wasSet = false;
    productType = aProductType;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(float aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
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

  public String getDescription()
  {
    return description;
  }

  public String getProductType()
  {
    return productType;
  }

  public float getPrice()
  {
    return price;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "name" + ":" + getName()+ "," +
            "description" + ":" + getDescription()+ "," +
            "productType" + ":" + getProductType()+ "," +
            "price" + ":" + getPrice()+ "]";
  }
}