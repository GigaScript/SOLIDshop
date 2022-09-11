package usecase.configurations;

import entity.Product;
import interfaces.IdGenerator;
import interfaces.ProductConfig;
import interfaces.ProductRepository;
import interfaces.VendorRepository;
import usecase.product.*;

public class ProductConfigDefault implements ProductConfig {
    private final ProductRepository repository;
    private final IdGenerator idGenerator;

    public ProductConfigDefault(ProductRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public ProductChangeQuantity changeQuantity(Product product, int newQuantity) {
        return new ProductChangeQuantity(product, newQuantity);
    }


    @Override
    public ProductCreate createProduct() {
        return new ProductCreate(repository, idGenerator);
    }

    @Override
    public ProductFiltered filteredProduct() {
        return new ProductFiltered(repository);
    }

    @Override
    public ProductFind findProduct() {
        return new ProductFind(repository);
    }

    @Override
    public ProductFindCategory findCategory() {
        return new ProductFindCategory(repository);
    }
}
