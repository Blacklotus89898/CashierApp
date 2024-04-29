package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Product;

public class ProductDto {

    private int idNumber;
    private int quantity;
    private float currentPrice;

    private int productTypeId;
    private int transactionId;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.idNumber = product.getIdNumber();
        this.quantity = product.getQuantity();
        this.currentPrice = product.getCurrentPrice();
        this.productTypeId = product.getProductType().getIdNumber();
        this.transactionId = product.getTransaction().getIdNumber();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

}