package usecase.validators;

import entity.Product;
import excption.ProductValidationException;

import java.math.BigDecimal;

public final class ProductValidator {
    public static void validateCreateProduct(final Product product) {
        if (product == null) {
            throw new ProductValidationException("Ошибка объект товар не найден NULL");
        } else if (product.getId() == null) {
            throw new ProductValidationException("Ошибка параметр ID товара пуст");
        } else if (product.getName().isEmpty()) {
            throw new ProductValidationException("Ошибка имя товара отсутствует");
        } else if (product.getName().length() < 3) {
            throw new ProductValidationException("Ошибка имя товара менее 3х символов");
        } else if (product.getPrice() == null || product.getPrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new ProductValidationException("Ошибка цена товара отсутствует или меньше 0");
        } else if (product.getPurchasePrice() == null || product.getPurchasePrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new ProductValidationException("Ошибка закупочная цена товара отсутствует или меньше 0");
        } else if (product.getPrice().compareTo(product.getPurchasePrice()) <= 0) {
            throw new ProductValidationException("Ошибка закупочная цена товара меньше или равна продажной цене");
        } else if (product.getStockQuantity() < 0) {
            throw new ProductValidationException("Ошибка количество товара должно быть больше 0 или 0");
        } else if (product.getTaxSystem() == null) {
            throw new ProductValidationException("Не указана система налогообложения");
        }
    }

    private ProductValidator() {
    }

}
