package usecase.product;

import entity.Product;
import interfaces.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductFind {
    private final ProductRepository repository;

    public ProductFind(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAllProduct() {
        return repository.getAllProduct();
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> findByKeyWord(String name) {
        return repository.findByKeyWord(name);
    }
}
