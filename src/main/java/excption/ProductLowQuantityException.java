package excption;

public class ProductLowQuantityException extends RuntimeException {
    public ProductLowQuantityException(String message) {
        super(message);
    }
}
