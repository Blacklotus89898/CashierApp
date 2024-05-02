package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.Promotion;

public class PromotionDto {

    private int idNumber;
    private String name;
    private int quantity;
    private float price;
    private float totalPrice;
    private int productTypeId;

    public PromotionDto() {
    }

    public PromotionDto(int idNumber, String name, int quantity, float price, float totalPrice, int productTypeId) {
        this.idNumber = idNumber;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.productTypeId = productTypeId;
    }

    public PromotionDto(Promotion promotion) {
        this.idNumber = promotion.getIdNumber();
        this.name = promotion.getName();
        this.quantity = promotion.getQuantity();
        this.price = promotion.getPrice();
        this.totalPrice = promotion.getTotalPrice();
        this.productTypeId = promotion.getProductType().getIdNumber();
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }
}