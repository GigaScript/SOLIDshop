package repositorys;

import entity.Order;
import entity.User;
import interfaces.OrderRepository;

import java.util.*;

public class OrderRepositoriesInMemory implements OrderRepository {
    private final Map<User, List<Order>> orderRepository = new HashMap<>();

    @Override
    public List<Order> findByUser(User user) {
        return new ArrayList<>(orderRepository.get(user));
    }

    @Override
    public Optional<Order> findById(String orderId) {
        for (Map.Entry<User, List<Order>> maps : orderRepository.entrySet()) {
            for (Order order : maps.getValue()) {
                if (order.getId().equals(orderId)) {
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> findByStatus(String status) {
        for (Map.Entry<User, List<Order>> maps : orderRepository.entrySet()) {
            for (Order order : maps.getValue()) {
                if (order.getStatus().equals(status)) {
                    return Optional.of(order);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Order> addOrder(User user, Order order) {
        if (orderRepository.containsKey(user)) {
            orderRepository.get(user).add(order);
        } else {
            Objects.requireNonNull(orderRepository.put(user, new ArrayList<Order>())).add(order);
        }
        return Optional.of(order);
    }
}
