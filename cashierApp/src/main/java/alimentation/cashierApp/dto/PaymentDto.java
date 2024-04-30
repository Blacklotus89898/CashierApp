package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Payment;

public class PaymentDto {

    private int idNumber;
    private String paymentType;
    private int amount;
    private int transactionId;

    public PaymentDto() {
    }

    public PaymentDto(int idNumber, String paymentType, int amount, int transactionId) {
        this.idNumber = idNumber;
        this.paymentType = paymentType;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public PaymentDto(Payment payment) {
        this.idNumber = payment.getIdNumber();
        this.paymentType = payment.getPaymenttype().toString();
        this.amount = payment.getAmount();
        this.transactionId = payment.getTransaction().getIdNumber();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}