package usecase.validators;

import entity.Product;
import excption.ProductLowQuantityException;
import excption.ProductNotFindException;
import interfaces.ProductRepository;

public class OrderValidator {
    public static Product quantityInStock(Product productInOrder, ProductRepository productRepository) {
        Product productInStock = productRepository
                .findById(productInOrder.getId())
                .orElseThrow(
                        () -> new ProductNotFindException("Товар с ID " + productInOrder.getId() + "не найден на складе")
                );
        if (productInOrder.getStockQuantity() >= productInStock.getStockQuantity()) {
            return productInOrder;
        }
        throw new ProductLowQuantityException("Товар с ID " + productInOrder.getId() + "в заказе меньше, чем есть на складе");
    }
}
