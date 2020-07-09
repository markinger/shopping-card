package shoppingcenter;

import product.Product;
import shoppingcart.ShoppingCart;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCenter {
    private final Scanner scanner = new Scanner(System.in);

    public void startShopping() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Map<Integer, Product> availableProducts = getAvailableProducts();
        do {
            availableProducts.keySet()
                    .forEach(id -> System.out.println("[" + id + "]" + " " + availableProducts.get(id).toString()));
            System.out.println("[r] - показати кошик");
            switch (scanner.next()) {
                case "1":
                    shoppingCart.addProduct(availableProducts.get(1));
                    break;
                case "2":
                    shoppingCart.addProduct(availableProducts.get(2));
                    break;
                case "3":
                    shoppingCart.addProduct(availableProducts.get(3));
                    break;
                case "r":
                    shoppingCart.getProductsSummary().forEach(System.out::println);
                    System.out.println("Всього: " + shoppingCart.getTotalAmountOfProducts() +
                            " Сума: " + shoppingCart.getTotalPrice() + " грн");
                    return;
            }
        } while (true);
    }

    private Map<Integer, Product> getAvailableProducts() {
        Map<Integer, Product> availableProducts = new HashMap<>();
        availableProducts.put(1, new Product("Яблука", 50));
        availableProducts.put(2, new Product("Ковбаса", 10));
        availableProducts.put(3, new Product("Квас", 30));
        return availableProducts;
    }
}
