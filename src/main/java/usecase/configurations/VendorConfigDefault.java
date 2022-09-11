package usecase.configurations;

import interfaces.IdGenerator;
import interfaces.VendorConfig;
import interfaces.VendorRepository;
import usecase.vendor.VendorCreate;
import usecase.vendor.VendorFind;

public class VendorConfigDefault implements VendorConfig {
    private final VendorRepository repository;
    private final IdGenerator idGenerator;

    public VendorConfigDefault(VendorRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public VendorCreate createVendor() {
        return new VendorCreate(repository, idGenerator);
    }

    @Override
    public VendorFind findVendor() {
        return new VendorFind(repository);
    }
}
