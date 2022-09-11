package interfaces;

import entity.Cart;
import entity.User;

import java.util.Optional;

public interface CartRepository {
    public Cart findByUser(User user);

    public Cart addCart(User user);
}
