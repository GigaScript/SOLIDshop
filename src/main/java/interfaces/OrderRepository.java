package interfaces;

import entity.Order;
import entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    public List<Order> findByUser(User user);

    public Optional<Order> findById(String orderId);

    public Optional<Order> findByStatus(String status);

    public Optional<Order> addOrder(User user, Order order);

}
