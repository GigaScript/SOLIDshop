package usecase.vendor;

import entity.Vendor;
import excption.UserAlreadyExistsException;
import interfaces.IdGenerator;
import interfaces.VendorRepository;
import usecase.validators.VendorValidator;

public class VendorCreate {
    private final VendorRepository repository;
    private final IdGenerator idGenerator;

    public VendorCreate(VendorRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Vendor create(final Vendor vendor) {
        VendorValidator.validateCreateVendor(vendor);
        if (repository.getVendorByName(vendor.getName()).isPresent()) {
            throw new UserAlreadyExistsException("Бренд с именем "+vendor.getName()+" уже существует");
        }
        String description = vendor.getDescription();
        if (description.isEmpty()) {
            description = " ";
        }
        Vendor vendorToSave = Vendor.builder()
                .setId(idGenerator.generate())
                .setName(vendor.getName())
                .setDescription(description)
                .build();
        return repository.addVendor(vendorToSave);
    }
}
