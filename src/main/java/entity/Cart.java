package entity;

import java.util.LinkedHashMap;

public class Cart {
    private final String priceSuffix;
    private final LinkedHashMap<Product, Integer> cart = new LinkedHashMap<Product, Integer>();

    public Cart(String priceSuffix) {
        this.priceSuffix = priceSuffix;
    }

    public String getPriceSuffix() {
        return this.priceSuffix;
    }

    public LinkedHashMap<Product, Integer> getAllItems() {
        return this.cart;
    }

}
