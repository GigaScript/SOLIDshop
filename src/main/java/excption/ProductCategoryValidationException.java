package excption;

public class ProductCategoryValidationException extends RuntimeException {
    public ProductCategoryValidationException(String message) {
        super(message);
    }
}
