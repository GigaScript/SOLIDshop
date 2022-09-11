package repositorys;

import entity.Cart;
import entity.User;
import interfaces.CartRepository;

import java.util.*;

public class CartRepositoryInMemory implements CartRepository {
    private final Map<User, Cart> cartRepository = new HashMap<>();

    @Override
    public Cart findByUser(User user) {
        if (cartRepository.containsKey(user)) {
            return cartRepository.get(user);
        } else {
            return addCart(user);
        }
    }

    @Override
    public Cart addCart(User user) {
        if (cartRepository.containsKey(user)) {
            return cartRepository.get(user);
        } else {
            Cart cart = new Cart("руб");
            return cartRepository.put(user, cart);
        }
    }
}
