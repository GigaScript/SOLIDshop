package usecase.product;

import entity.ProductCategory;
import interfaces.ProductRepository;

import java.util.Set;

public class ProductFindCategory {
    private final ProductRepository repository;

    public ProductFindCategory(ProductRepository repository) {
        this.repository = repository;
    }

    public Set<ProductCategory> getAllCategory() {
        return repository.getAllCategory();
    }
}
