package alimentation.cashierApp.dto;

import alimentation.cashierApp.models.ProductType;

public class ProductTypeDto {

    private int idNumber;
    private String name;
    private String description;
    private String productType;
    private float price;

    public ProductTypeDto() {
    }

    public ProductTypeDto(int idNumber, String name, String description, String productType, float price) {
        this.idNumber = idNumber;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.price = price;
    }

    public ProductTypeDto(ProductType productType) {
        this.idNumber = productType.getIdNumber();
        this.name = productType.getName();
        this.description = productType.getDescription();
        this.productType = productType.getProductType();
        this.price = productType.getPrice();
    }

    // getters and setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType toProductType() {
        ProductType productType = new ProductType();
        productType.setIdNumber(this.idNumber);
        productType.setName(this.name);
        productType.setDescription(this.description);
        productType.setProductType(this.productType);
        productType.setPrice(this.price);
        return productType;
    }
}