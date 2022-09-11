package usecase.productCategory;

import entity.ProductCategory;
import entity.Vendor;
import excption.ProductCategoryAlreadyExistsException;
import interfaces.IdGenerator;
import interfaces.ProductCategoryRepository;
import usecase.validators.ProductCategoryValidator;

public class ProductCategoryCreate {
    private final ProductCategoryRepository repository;
    private final IdGenerator idGenerator;

    public ProductCategoryCreate(ProductCategoryRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    public ProductCategory create(final ProductCategory productCategory) {
        ProductCategoryValidator.validateCreateProductCategory(productCategory);
        if (repository.getCategoryByName(productCategory.getName()).isPresent()) {
            throw new ProductCategoryAlreadyExistsException("Категория с именем " + productCategory.getName() + " уже существует");
        }
        String description = productCategory.getDescription();
        if (description.isEmpty()) {
            description = " ";
        }
        ProductCategory productCategoryToSave = ProductCategory.builder()
                .setId(idGenerator.generate())
                .setName(productCategory.getName())
                .setDescription(description)
                .build();
        return repository.addCategory(productCategoryToSave);
    }
}
