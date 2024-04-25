/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package alimentation.cashierApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// line 13 "t.ump"
@Entity
public class Promotion
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Promotion Attributes
  @Id
  private int idNumber;
  private String name;
  private int quantity;
  private float price;
  private float totalPrice;

  //Promotion Associations
  @ManyToOne
  private ProductType productType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Promotion(int aIdNumber, String aName, int aQuantity, float aPrice, float aTotalPrice, ProductType aProductType)
  {
    idNumber = aIdNumber;
    name = aName;
    quantity = aQuantity;
    price = aPrice;
    totalPrice = aTotalPrice;
    if (!setProductType(aProductType))
    {
      throw new RuntimeException("Unable to create Promotion due to aProductType. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(int aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
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

  public boolean setTotalPrice(float aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
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

  /**
   * quantity needed for promo
   */
  public int getQuantity()
  {
    return quantity;
  }

  public float getPrice()
  {
    return price;
  }

  public float getTotalPrice()
  {
    return totalPrice;
  }
  /* Code from template association_GetOne */
  public ProductType getProductType()
  {
    return productType;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setProductType(ProductType aNewProductType)
  {
    boolean wasSet = false;
    if (aNewProductType != null)
    {
      productType = aNewProductType;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    productType = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "name" + ":" + getName()+ "," +
            "quantity" + ":" + getQuantity()+ "," +
            "price" + ":" + getPrice()+ "," +
            "totalPrice" + ":" + getTotalPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null");
  }
}