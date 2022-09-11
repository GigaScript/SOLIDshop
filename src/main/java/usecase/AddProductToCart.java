package usecase;

import entity.Cart;
import entity.Product;
import entity.User;
import interfaces.CartRepository;

public class AddProductToCart {
    public AddProductToCart(CartRepository cartRepository, User user, Product product, int quantity) {
        Cart cart = cartRepository.findByUser(user);
        if (cart.getAllItems().containsKey(product)) {
            Integer newQuantity = cart.getAllItems().get(product) + quantity;
            cart.getAllItems().put(product, newQuantity);
        } else {
            cart.getAllItems().put(product, quantity);
        }
    }
}
