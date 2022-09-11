package usecase.product;

import entity.Product;
import entity.ProductCategory;
import excption.UserAlreadyExistsException;
import interfaces.IdGenerator;
import interfaces.ProductRepository;
import usecase.validators.ProductValidator;

public class ProductCreate {
    private final ProductRepository repository;
    private final IdGenerator idGenerator;

    public ProductCreate(ProductRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public Product create(final Product product, ProductCategory category) {
        ProductValidator.validateCreateProduct(product);
        if (repository.findById(product.getId()).isPresent()) {
            throw new UserAlreadyExistsException("Товар не создан. Товар с ID "+product.getId()+" уже существует");
        } else if (repository.findByName(product.getName()).isPresent()) {
            throw new UserAlreadyExistsException("Товар не создан. Товар с именем "+product.getName()+" уже существует");
        }

        Product productToSave = Product.builder()
                .setId(idGenerator.generate())
                .setName(product.getName())
                .setVendor(product.getVendor())
                .setPrice(product.getPrice())
                .setPurchasePrice(product.getPurchasePrice())
                .setStockQuantity(product.getStockQuantity())
                .setTaxSystem(product.getTaxSystem())
                .build();
        return repository.addProductInRepository(productToSave, category);
    }
}
