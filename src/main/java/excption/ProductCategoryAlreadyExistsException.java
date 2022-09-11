package excption;

public class ProductCategoryAlreadyExistsException extends RuntimeException {
    public ProductCategoryAlreadyExistsException (String message) {
        super(message);
    }
}
