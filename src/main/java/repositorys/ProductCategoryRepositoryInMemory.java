package repositorys;

import entity.ProductCategory;
import interfaces.ProductCategoryRepository;

import java.util.*;

public class ProductCategoryRepositoryInMemory implements ProductCategoryRepository {
    private final Map<String, ProductCategory> productCategoryRepository = new HashMap<>();

    @Override
    public List<ProductCategory> getAllCategory() {
        return new ArrayList<>(productCategoryRepository.values());
    }

    @Override
    public Optional<ProductCategory> getCategoryById(String categoryId) {
        return productCategoryRepository.values().stream()
                .filter(category -> category.getId().equals(categoryId))
                .findAny();
    }

    @Override
    public Optional<ProductCategory> getCategoryByName(String categoryName) {
        return productCategoryRepository.values().stream()
                .filter(category -> category.getName().equals(categoryName))
                .findAny();
    }

    @Override
    public ProductCategory addCategory(ProductCategory productCategory) {
        productCategoryRepository.put(productCategory.getName(), productCategory);
        return productCategory;
    }
}
