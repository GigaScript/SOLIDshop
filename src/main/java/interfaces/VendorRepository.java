package interfaces;

import entity.Vendor;

import java.util.List;
import java.util.Optional;

public interface VendorRepository {
    List<Vendor> getAllVendors();

    Optional<Vendor> getVendorById(String vendorId);

    Optional<Vendor> getVendorByName(String vendorName);

    Vendor addVendor(Vendor productVendor);
}
