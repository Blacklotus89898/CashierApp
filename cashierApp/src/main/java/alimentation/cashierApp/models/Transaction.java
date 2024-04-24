/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

package alimentation.cashierApp.models;

import java.sql.Time;
import java.util.*;

import alimentation.cashierApp.models.Payment.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

// line 23 "t.ump"
@Entity
public class Transaction
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum TransactionType { Payment, Cancellation }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Transaction Attributes
  @Id
  private int idNumber;
  private Time time;
  private TransactionType transactiontype;

  //Transaction Associations
  @OneToMany
  private List<Product> products;
  @OneToMany
  private List<Payment> payments;
  @ManyToOne
  private Report report;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Transaction(int aIdNumber, Time aTime, TransactionType aTransactiontype, Report aReport, Product... allProducts)
  {
    idNumber = aIdNumber;
    time = aTime;
    transactiontype = aTransactiontype;
    products = new ArrayList<Product>();
    boolean didAddProducts = setProducts(allProducts);
    if (!didAddProducts)
    {
      throw new RuntimeException("Unable to create Transaction, must have at least 1 products. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    payments = new ArrayList<Payment>();
    boolean didAddReport = setReport(aReport);
    if (!didAddReport)
    {
      throw new RuntimeException("Unable to create transaction due to report. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setTime(Time aTime)
  {
    boolean wasSet = false;
    time = aTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTransactiontype(TransactionType aTransactiontype)
  {
    boolean wasSet = false;
    transactiontype = aTransactiontype;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public Time getTime()
  {
    return time;
  }

  public TransactionType getTransactiontype()
  {
    return transactiontype;
  }
  /* Code from template association_GetMany */
  public Product getProduct(int index)
  {
    Product aProduct = products.get(index);
    return aProduct;
  }

  public List<Product> getProducts()
  {
    List<Product> newProducts = Collections.unmodifiableList(products);
    return newProducts;
  }

  public int numberOfProducts()
  {
    int number = products.size();
    return number;
  }

  public boolean hasProducts()
  {
    boolean has = products.size() > 0;
    return has;
  }

  public int indexOfProduct(Product aProduct)
  {
    int index = products.indexOf(aProduct);
    return index;
  }
  /* Code from template association_GetMany */
  public Payment getPayment(int index)
  {
    Payment aPayment = payments.get(index);
    return aPayment;
  }

  public List<Payment> getPayments()
  {
    List<Payment> newPayments = Collections.unmodifiableList(payments);
    return newPayments;
  }

  public int numberOfPayments()
  {
    int number = payments.size();
    return number;
  }

  public boolean hasPayments()
  {
    boolean has = payments.size() > 0;
    return has;
  }

  public int indexOfPayment(Payment aPayment)
  {
    int index = payments.indexOf(aPayment);
    return index;
  }
  /* Code from template association_GetOne */
  public Report getReport()
  {
    return report;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfProducts()
  {
    return 1;
  }
  /* Code from template association_AddUnidirectionalMStar */
  public boolean addProduct(Product aProduct)
  {
    boolean wasAdded = false;
    if (products.contains(aProduct)) { return false; }
    products.add(aProduct);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeProduct(Product aProduct)
  {
    boolean wasRemoved = false;
    if (!products.contains(aProduct))
    {
      return wasRemoved;
    }

    if (numberOfProducts() <= minimumNumberOfProducts())
    {
      return wasRemoved;
    }

    products.remove(aProduct);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMStar */
  public boolean setProducts(Product... newProducts)
  {
    boolean wasSet = false;
    ArrayList<Product> verifiedProducts = new ArrayList<Product>();
    for (Product aProduct : newProducts)
    {
      if (verifiedProducts.contains(aProduct))
      {
        continue;
      }
      verifiedProducts.add(aProduct);
    }

    if (verifiedProducts.size() != newProducts.length || verifiedProducts.size() < minimumNumberOfProducts())
    {
      return wasSet;
    }

    products.clear();
    products.addAll(verifiedProducts);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addProductAt(Product aProduct, int index)
  {  
    boolean wasAdded = false;
    if(addProduct(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveProductAt(Product aProduct, int index)
  {
    boolean wasAdded = false;
    if(products.contains(aProduct))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfProducts()) { index = numberOfProducts() - 1; }
      products.remove(aProduct);
      products.add(index, aProduct);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addProductAt(aProduct, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfPaymentsValid()
  {
    boolean isValid = numberOfPayments() >= minimumNumberOfPayments();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPayments()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Payment addPayment(int aIdNumber, PaymentType aPaymenttype, int aAmount)
  {
    Payment aNewPayment = new Payment(aIdNumber, aPaymenttype, aAmount, this);
    return aNewPayment;
  }

  public boolean addPayment(Payment aPayment)
  {
    boolean wasAdded = false;
    if (payments.contains(aPayment)) { return false; }
    Transaction existingTransaction = aPayment.getTransaction();
    boolean isNewTransaction = existingTransaction != null && !this.equals(existingTransaction);

    if (isNewTransaction && existingTransaction.numberOfPayments() <= minimumNumberOfPayments())
    {
      return wasAdded;
    }
    if (isNewTransaction)
    {
      aPayment.setTransaction(this);
    }
    else
    {
      payments.add(aPayment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePayment(Payment aPayment)
  {
    boolean wasRemoved = false;
    //Unable to remove aPayment, as it must always have a transaction
    if (this.equals(aPayment.getTransaction()))
    {
      return wasRemoved;
    }

    //transaction already at minimum (1)
    if (numberOfPayments() <= minimumNumberOfPayments())
    {
      return wasRemoved;
    }

    payments.remove(aPayment);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaymentAt(Payment aPayment, int index)
  {  
    boolean wasAdded = false;
    if(addPayment(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
      payments.remove(aPayment);
      payments.add(index, aPayment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaymentAt(Payment aPayment, int index)
  {
    boolean wasAdded = false;
    if(payments.contains(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayments()) { index = numberOfPayments() - 1; }
      payments.remove(aPayment);
      payments.add(index, aPayment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPaymentAt(aPayment, index);
    }
    return wasAdded;
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
      existingReport.removeTransaction(this);
    }
    report.addTransaction(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    products.clear();
    while (payments.size() > 0)
    {
      Payment aPayment = payments.get(payments.size() - 1);
      aPayment.delete();
      payments.remove(aPayment);
    }
    
    Report placeholderReport = report;
    this.report = null;
    if(placeholderReport != null)
    {
      placeholderReport.removeTransaction(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "time" + "=" + (getTime() != null ? !getTime().equals(this)  ? getTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "transactiontype" + "=" + (getTransactiontype() != null ? !getTransactiontype().equals(this)  ? getTransactiontype().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "report = "+(getReport()!=null?Integer.toHexString(System.identityHashCode(getReport())):"null");
  }
}