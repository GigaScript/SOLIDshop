package usecase.productCategory;

import entity.ProductCategory;
import interfaces.ProductCategoryRepository;

import java.util.List;
import java.util.Optional;

public class ProductCategoryFind {
    private final ProductCategoryRepository repository;

    public ProductCategoryFind(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductCategory> getAllProductCategory() {
        return repository.getAllCategory();
    }

    public Optional<ProductCategory> getCategoryById(String categoryId) {
        return repository.getCategoryById(categoryId);
    }

    public Optional<ProductCategory> getCategoryByName(String categoryName) {
        return repository.getCategoryByName(categoryName);
    }
}
