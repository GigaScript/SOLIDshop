package excption;

public class ProductNotFindException extends RuntimeException {
    public ProductNotFindException(String message) {
        super(message);
    }
}
