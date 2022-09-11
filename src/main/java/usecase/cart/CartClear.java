package usecase.cart;

import entity.Cart;
import entity.User;
import interfaces.CartRepository;

public class CartClear {

    public static void clearCartByUser(User user, CartRepository cartRepository) {
        Cart cart = cartRepository.findByUser(user);
        if (cart.getAllItems().size() > 0) {
            cart.getAllItems().clear();
        }
    }
}
