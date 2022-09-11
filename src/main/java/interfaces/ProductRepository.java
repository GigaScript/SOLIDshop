package interfaces;

import entity.Product;
import entity.ProductCategory;
import entity.Vendor;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductRepository {
    Optional<Product> findById(String id);

    Optional<Product> findByName(String name);

    List<Product> findByKeyWord(String name);

    List<Product> filteredByCategory(ProductCategory category);

    List<Product> filteredByVendor(Vendor vendor);

    List<Product> filteredToUpPrice(ProductCategory category);

    List<Product> filteredToDownPrice(ProductCategory category);

    List<Product> getAllProduct();

    Set<ProductCategory> getAllCategory();

    Product addProductInRepository(Product productToSave, ProductCategory category);

    void addCategory(ProductCategory category);
}
