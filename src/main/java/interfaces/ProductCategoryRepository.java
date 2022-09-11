package interfaces;

import entity.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository {
    List<ProductCategory> getAllCategory();

    Optional<ProductCategory> getCategoryById(String categoryId);

    Optional<ProductCategory> getCategoryByName(String categoryName);

    ProductCategory addCategory(ProductCategory productCategory);

}
