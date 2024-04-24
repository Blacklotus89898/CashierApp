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

  public Payment(int aIdNumber, PaymentType aPaymenttype, int aAmount, Transaction aTransaction)
  {
    idNumber = aIdNumber;
    paymenttype = aPaymenttype;
    amount = aAmount;
    boolean didAddTransaction = setTransaction(aTransaction);
    if (!didAddTransaction)
    {
      throw new RuntimeException("Unable to create payment due to transaction. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
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
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setTransaction(Transaction aTransaction)
  {
    boolean wasSet = false;
    //Must provide transaction to payment
    if (aTransaction == null)
    {
      return wasSet;
    }

    if (transaction != null && transaction.numberOfPayments() <= Transaction.minimumNumberOfPayments())
    {
      return wasSet;
    }

    Transaction existingTransaction = transaction;
    transaction = aTransaction;
    if (existingTransaction != null && !existingTransaction.equals(aTransaction))
    {
      boolean didRemove = existingTransaction.removePayment(this);
      if (!didRemove)
      {
        transaction = existingTransaction;
        return wasSet;
      }
    }
    transaction.addPayment(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Transaction placeholderTransaction = transaction;
    this.transaction = null;
    if(placeholderTransaction != null)
    {
      placeholderTransaction.removePayment(this);
    }
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