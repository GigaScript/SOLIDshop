package repositorys;

import entity.Product;
import entity.ProductCategory;
import entity.Vendor;
import interfaces.ProductRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ProductRepositoryInMemory implements ProductRepository {
    private final Map<ProductCategory, List<Product>> productRepository = new HashMap<>();
    private final ProductCategory defaultCategory;

    public ProductRepositoryInMemory() {
        this.defaultCategory = new ProductCategory("0", "Все товары", " ");
        productRepository.put(defaultCategory, new ArrayList<>());
    }

    @Override
    public Optional<Product> findById(String id) {
        return productRepository
                .get(defaultCategory)
                .stream()
                .filter(
                        productList -> productList.getId().equals(id)
                )
                .findAny();
    }

    public Optional<Product> findByName(String name) {
        return productRepository
                .get(defaultCategory)
                .stream()
                .filter(
                        productList -> productList.getName().equals(name)
                )
                .findAny();
    }

    @Override
    public List<Product> findByKeyWord(String name) {
        return productRepository.get(defaultCategory)
                .stream()
                .filter(
                        product -> product.getName().contains(name)
                                || product.getVendor().getName().contains(name)
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> filteredByCategory(ProductCategory category) {
        return productRepository.get(category);
    }

    @Override
    public List<Product> filteredByVendor(Vendor vendor) {
        return productRepository.get(defaultCategory)
                .stream()
                .filter(
                        product -> product.getVendor().getName().equals(vendor.getName())
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> filteredToUpPrice(ProductCategory category) {
        return productRepository.get(category)
                .stream()
                .sorted(
                        (product1, product2) -> product1.compareToPrice(product2)
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<Product> filteredToDownPrice(ProductCategory category) {
        return productRepository.get(category)
                .stream()
                .sorted(
                        (product1, product2) -> product2.compareToPrice(product1)
                )
                .collect(
                        Collectors.toList()
                );
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.get(defaultCategory);
    }

    @Override
    public Set<ProductCategory> getAllCategory() {
        return productRepository.keySet();
    }

    @Override
    public Product addProductInRepository(Product productToSave, ProductCategory category) {
        productRepository.get(defaultCategory).add(productToSave);
        if (category != null) {
            addCategory(category);
            List<Product> productList = productRepository.get(category);
            if (!productList.contains(productToSave)) {
                productList.add(productToSave);
            }
        }
        return productToSave;
    }

    @Override
    public void addCategory(ProductCategory category) {
        if (!productRepository.containsKey(category)) {
            List<Product> list = new ArrayList<>();
            productRepository.put(category, list);
        }
    }
}
