package usecase.validators;

import entity.Vendor;
import excption.VendorValidationException;

public final class VendorValidator {
    public static void validateCreateVendor(final Vendor vendor) {
        if (vendor == null) {
            throw new VendorValidationException("Объект Vendor не найден");
        } else if (vendor.getId() == null) {
            throw new VendorValidationException("Ошибка Vendor ID, не указан");
        } else if (vendor.getName().isEmpty()) {
            throw new VendorValidationException("Ошибка Vendor имя отсутствует");
        }
    }

    private VendorValidator() {
    }
}
