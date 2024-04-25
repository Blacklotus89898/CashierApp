/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package alimentation.cashierApp.models;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// line 4 "t.ump"
@Entity
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  @Id
  private int idNumber;
  private int quantity;

  //Product Associations
  @ManyToOne
  private ProductType productType;
  @ManyToOne
  private Transaction transaction;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(int aIdNumber, int aQuantity, ProductType aProductType, Transaction aTransaction)
  {
    idNumber = aIdNumber;
    quantity = aQuantity;
    if (!setProductType(aProductType))
    {
      throw new RuntimeException("Unable to create Product due to aProductType. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setTransaction(aTransaction))
    {
      throw new RuntimeException("Unable to create Product due to aTransaction. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Product() {
    //TODO Auto-generated constructor stub
}

public boolean setIdNumber(int aIdNumber)
  {
    boolean wasSet = false;
    idNumber = aIdNumber;
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

  public int getIdNumber()
  {
    return idNumber;
  }

  public int getQuantity()
  {
    return quantity;
  }
  /* Code from template association_GetOne */
  public ProductType getProductType()
  {
    return productType;
  }
  /* Code from template association_GetOne */
  public Transaction getTransaction()
  {
    return transaction;
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
  /* Code from template association_SetUnidirectionalOne */
  public boolean setTransaction(Transaction aNewTransaction)
  {
    boolean wasSet = false;
    if (aNewTransaction != null)
    {
      transaction = aNewTransaction;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    productType = null;
    transaction = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "quantity" + ":" + getQuantity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "productType = "+(getProductType()!=null?Integer.toHexString(System.identityHashCode(getProductType())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "transaction = "+(getTransaction()!=null?Integer.toHexString(System.identityHashCode(getTransaction())):"null");
  }
}