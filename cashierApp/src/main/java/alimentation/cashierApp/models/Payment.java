package alimentation.cashierApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/



// line 39 "t.ump"
@Entity
public class Payment
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum PaymentType { Credit, Debit, Cash }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Payment Attributes
  @Id
  private int idNumber;
  private PaymentType paymenttype;
  private int amount;

  //Payment Associations
  @ManyToOne
  private Transaction transaction;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  public Payment()
  {
    //TODO Auto-generated constructor stub
  }
  public Payment(int aIdNumber, PaymentType aPaymenttype, int aAmount, Transaction aTransaction)
  {
    idNumber = aIdNumber;
    paymenttype = aPaymenttype;
    amount = aAmount;
    if (!setTransaction(aTransaction))
    {
      throw new RuntimeException("Unable to create Payment due to aTransaction. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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

  public boolean setPaymenttype(PaymentType aPaymenttype)
  {
    boolean wasSet = false;
    paymenttype = aPaymenttype;
    wasSet = true;
    return wasSet;
  }

  public boolean setAmount(int aAmount)
  {
    boolean wasSet = false;
    amount = aAmount;
    wasSet = true;
    return wasSet;
  }

  public int getIdNumber()
  {
    return idNumber;
  }

  public PaymentType getPaymenttype()
  {
    return paymenttype;
  }

  public int getAmount()
  {
    return amount;
  }
  /* Code from template association_GetOne */
  public Transaction getTransaction()
  {
    return transaction;
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
    transaction = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "idNumber" + ":" + getIdNumber()+ "," +
            "amount" + ":" + getAmount()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "paymenttype" + "=" + (getPaymenttype() != null ? !getPaymenttype().equals(this)  ? getPaymenttype().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "transaction = "+(getTransaction()!=null?Integer.toHexString(System.identityHashCode(getTransaction())):"null");
  }
}