package usecase;

import entity.Cart;
import entity.Order;
import entity.Product;
import entity.User;
import interfaces.CartRepository;
import interfaces.OrderRepository;
import interfaces.ProductRepository;
import usecase.cart.CartClear;
import usecase.validators.OrderValidator;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateOrder {
    public CreateOrder(User user, OrderRepository orderRepository,
                       CartRepository cartRepository, ProductRepository productRepository,
                       AnyIdGenerator idGenerator) {
        Cart cart = cartRepository.findByUser(user);
        Order orderToVerify = new Order(idGenerator.generate(), user.getEmail());
        int cartListSize = cart.getAllItems().size();
        if (cartListSize > 0) {
            LinkedHashMap<Product, Integer> productInCart = cart.getAllItems();
            LinkedHashMap<Product, Integer> productInOrder = orderToVerify.getOrderList();
            BigDecimal total = new BigDecimal(0);
            BigDecimal totalPurchase = new BigDecimal(0);
            BigDecimal price;
            BigDecimal purchasePrice;
            Integer quantityInCart = 0;
            for (Map.Entry<Product, Integer> product : productInCart.entrySet()) {
                price = product.getKey().getPrice();
                purchasePrice = product.getKey().getPurchasePrice();
                quantityInCart = product.getValue();
                productInOrder.put(product.getKey(), product.getValue());
                OrderValidator.quantityInStock((Product) product, productRepository);
                total.add(price.multiply(BigDecimal.valueOf(quantityInCart)));
                totalPurchase.add(purchasePrice.multiply(BigDecimal.valueOf(quantityInCart)));
            }
            orderToVerify.setTotalCost(total);
            orderToVerify.setTotalCost(totalPurchase);
            saveOrder(orderToVerify, orderRepository, cartRepository, user);
        }
    }

    private void saveOrder(Order orderToSave, OrderRepository orderRepository, CartRepository cartRepository, User user) {
        orderRepository.addOrder(user, orderToSave);
        CartClear.clearCartByUser(user, cartRepository);
    }

}
