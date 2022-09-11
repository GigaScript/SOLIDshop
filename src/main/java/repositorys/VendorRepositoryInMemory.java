package repositorys;

import entity.Vendor;
import interfaces.VendorRepository;

import java.util.*;

public class VendorRepositoryInMemory implements VendorRepository {
    private final Map<String, Vendor> vendorRepository = new HashMap<>();


    @Override
    public List<Vendor> getAllVendors() {
        return new ArrayList<>(vendorRepository.values());
    }

    @Override
    public Optional<Vendor> getVendorById(String vendorId) {
        return vendorRepository.values().stream()
                .filter(vendor -> vendor.getId().equals(vendorId))
                .findAny();
    }

    @Override
    public Optional<Vendor> getVendorByName(String vendorName) {
        return vendorRepository.values().stream()
                .filter(vendor -> vendor.getName().equals(vendorName))
                .findAny();
    }

    @Override
    public Vendor addVendor(Vendor productVendor) {
        vendorRepository.put(productVendor.getId(), productVendor);
        return productVendor;
    }
}
