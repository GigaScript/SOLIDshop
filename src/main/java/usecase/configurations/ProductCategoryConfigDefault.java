package usecase.configurations;

import interfaces.IdGenerator;
import interfaces.ProductCategoryConfig;
import interfaces.ProductCategoryRepository;
import usecase.productCategory.ProductCategoryCreate;
import usecase.productCategory.ProductCategoryFind;

public class ProductCategoryConfigDefault implements ProductCategoryConfig {
    private final ProductCategoryRepository repository;
    private final IdGenerator idGenerator;

    public ProductCategoryConfigDefault(ProductCategoryRepository repository, IdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }

    @Override
    public ProductCategoryCreate createProductCategory() {
        return new ProductCategoryCreate(repository, idGenerator);
    }

    @Override
    public ProductCategoryFind findProductCategory() {
        return new ProductCategoryFind(repository);
    }
}
