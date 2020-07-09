package shoppingcart;

import product.Product;
import productsummary.ProductSummary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCart {
    private Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }

    public List<ProductSummary> getProductsSummary() {
        return products.keySet().stream()
                .map(product -> new ProductSummary(product, products.get(product)))
                .collect(Collectors.toList());
    }

    public int getTotalPrice() {
        return products.keySet().stream()
                .mapToInt(product -> product.getPrice() * products.get(product))
                .sum();
    }

    public int getTotalAmountOfProducts() {
        return products.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}

