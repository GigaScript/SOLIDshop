package entity;

import repositorys.TaxSystemRepository;

import java.math.BigDecimal;

public class Product {
    private String id;
    private String name;
    private Vendor vendor;
    private Enum<TaxSystemRepository> taxSystem;
    private BigDecimal price;
    private BigDecimal purchasePrice;
    int stockQuantity = 0;

    public Product(String id, String name, Vendor vendor, Enum<TaxSystemRepository> taxSystem, BigDecimal price, BigDecimal purchasePrice, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.taxSystem = taxSystem;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stockQuantity = stockQuantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setTaxSystem(Enum<TaxSystemRepository> taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Vendor getVendor() {
        return vendor;
    }

    public Enum<TaxSystemRepository> getTaxSystem() {
        return taxSystem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }


    public static Product.Builder builder() {
        return new Product.Builder();
    }

    public int compareToPrice(Product comparableProduct) {
        BigDecimal currentProductPrice = getPrice();
        BigDecimal comparableProductPrice = comparableProduct.getPrice();
        return currentProductPrice.compareTo(comparableProductPrice);
    }

    public static class Builder {
        String id;
        String name;
        Vendor vendor;
        Enum<TaxSystemRepository> taxSystem;
        BigDecimal price;
        BigDecimal purchasePrice;
        int stockQuantity;


        public Builder() {
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setVendor(Vendor vendor) {
            this.vendor = vendor;
            return this;
        }

        public Builder setTaxSystem(Enum<TaxSystemRepository> taxSystem) {
            this.taxSystem = taxSystem;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setPurchasePrice(BigDecimal purchasePrice) {
            this.purchasePrice = purchasePrice;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Product build() {
            return new Product(id, name, vendor, taxSystem, price, purchasePrice, stockQuantity);
        }
    }

}
