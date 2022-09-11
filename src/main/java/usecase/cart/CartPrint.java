package usecase.cart;

import entity.Product;
import entity.User;
import interfaces.CartRepository;

import java.math.BigDecimal;
import java.util.Map;

public class CartPrint {
    public void print(User user, CartRepository cartRepository) {
        int cartListSize = cartRepository.findByUser(user).getAllItems().size();
        if (cartListSize > 0) {
            String priceSuffix = cartRepository.findByUser(user).getPriceSuffix();
            BigDecimal total = new BigDecimal(0);
            System.out.println("В корзине " + cartListSize + " товаров (" + user.getEmail() + ")\n" +
                    "Содержимое корзины: ");
            for (Map.Entry<Product, Integer> product : cartRepository.findByUser(user).getAllItems().entrySet()) {
                System.out.println(product.getKey().getName()
                        + " " + product.getValue().toString()
                        + " " + product.getKey().getPrice() + " " + priceSuffix
                        + " " + product.getKey().getPrice().multiply(BigDecimal.valueOf(product.getValue())) + " " + priceSuffix

                );
                total.add(product.getKey().getPrice().multiply(BigDecimal.valueOf(product.getValue())));
            }
            System.out.println("Сумма товаров в корзине: " + total.toString());
        } else {
            System.out.println("Корзина пуста");
        }
    }
}
