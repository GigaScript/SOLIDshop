package usecase.vendor;

import entity.Vendor;
import interfaces.VendorRepository;

import java.util.List;
import java.util.Optional;

public class VendorFind {
    private final VendorRepository repository;

    public VendorFind(VendorRepository repository) {
        this.repository = repository;
    }

    public List<Vendor> getAllVendors() {
        return repository.getAllVendors();
    }

    public Optional<Vendor> getVendorById(String vendorId) {
        return repository.getVendorById(vendorId);
    }

    public Optional<Vendor> getVendorByName(String vendorName) {
        return repository.getVendorByName(vendorName);
    }
}
