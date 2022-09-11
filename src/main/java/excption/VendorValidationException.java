package excption;

public class VendorValidationException extends RuntimeException {
    public VendorValidationException(final String message) {
        super(message);
    }
}
