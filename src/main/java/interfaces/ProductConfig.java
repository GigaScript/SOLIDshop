package interfaces;


import entity.Product;
import usecase.product.*;

public interface ProductConfig {
    ProductChangeQuantity changeQuantity(Product product, int newQuantity);

    ProductCreate createProduct();

    ProductFiltered filteredProduct();

    ProductFind findProduct();

    ProductFindCategory findCategory();
}
