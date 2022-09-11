package usecase.product;

import entity.Product;
import entity.ProductCategory;
import entity.Vendor;
import interfaces.ProductRepository;

import java.util.List;

public class ProductFiltered {
    private final ProductRepository repository;

    public ProductFiltered(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> filteredByCategory(ProductCategory category) {
        return repository.filteredByCategory(category);
    }

    public List<Product> filteredByVendor(Vendor vendor) {
        return repository.filteredByVendor(vendor);
    }

    public List<Product> filteredToUpPrice(ProductCategory category) {
        return repository.filteredToUpPrice(category);
    }

    public List<Product> filteredToDownPrice(ProductCategory category) {
        return repository.filteredToUpPrice(category);
    }
}
