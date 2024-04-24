/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

// line 4 "t.ump"
public class Product
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Product Attributes
  private int idNumber;
  private String name;
  private String description;
  private String productType;
  private float price;

  //Product Associations
  private List<Promotion> promotions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Product(int aIdNumber, String aName, String aDescription, String aProductType, float aPrice)
  {
    idNumber = aIdNumber;
    name = aName;
    description = aDescription;
    productType = aProductType;
    price = aPrice;
    promotions = new ArrayList<Promotion>();
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
  /* Code from template association_GetMany */
  public Promotion getPromotion(int index)
  {
    Promotion aPromotion = promotions.get(index);
    return aPromotion;
  }

  public List<Promotion> getPromotions()
  {
    List<Promotion> newPromotions = Collections.unmodifiableList(promotions);
    return newPromotions;
  }

  public int numberOfPromotions()
  {
    int number = promotions.size();
    return number;
  }

  public boolean hasPromotions()
  {
    boolean has = promotions.size() > 0;
    return has;
  }

  public int indexOfPromotion(Promotion aPromotion)
  {
    int index = promotions.indexOf(aPromotion);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPromotions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Promotion addPromotion(int aIdNumber, String aName, int aQuantity, float aPrice, float aTotalPrice)
  {
    return new Promotion(aIdNumber, aName, aQuantity, aPrice, aTotalPrice, this);
  }

  public boolean addPromotion(Promotion aPromotion)
  {
    boolean wasAdded = false;
    if (promotions.contains(aPromotion)) { return false; }
    Product existingProduct = aPromotion.getProduct();
    boolean isNewProduct = existingProduct != null && !this.equals(existingProduct);
    if (isNewProduct)
    {
      aPromotion.setProduct(this);
    }
    else
    {
      promotions.add(aPromotion);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePromotion(Promotion aPromotion)
  {
    boolean wasRemoved = false;
    //Unable to remove aPromotion, as it must always have a product
    if (!this.equals(aPromotion.getProduct()))
    {
      promotions.remove(aPromotion);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPromotionAt(Promotion aPromotion, int index)
  {  
    boolean wasAdded = false;
    if(addPromotion(aPromotion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPromotions()) { index = numberOfPromotions() - 1; }
      promotions.remove(aPromotion);
      promotions.add(index, aPromotion);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePromotionAt(Promotion aPromotion, int index)
  {
    boolean wasAdded = false;
    if(promotions.contains(aPromotion))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPromotions()) { index = numberOfPromotions() - 1; }
      promotions.remove(aPromotion);
      promotions.add(index, aPromotion);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPromotionAt(aPromotion, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while (promotions.size() > 0)
    {
      Promotion aPromotion = promotions.get(promotions.size() - 1);
      aPromotion.delete();
      promotions.remove(aPromotion);
    }
    
  }


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