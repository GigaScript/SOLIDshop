package usecase.product;

import entity.Product;

public class ProductChangeQuantity {
    public ProductChangeQuantity(Product product, int newQuantity) {
        product.setStockQuantity(newQuantity);
    }
}
