package interfaces;

import usecase.productCategory.ProductCategoryCreate;
import usecase.productCategory.ProductCategoryFind;

public interface ProductCategoryConfig {
    ProductCategoryCreate createProductCategory();

    ProductCategoryFind findProductCategory();
}
