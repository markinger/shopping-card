package productsummary;

import product.Product;

public class ProductSummary {
    private Product product;
    private final int quantity;
    private final int totalPrice;

    public ProductSummary(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return product.getName() + " " + quantity + " x " + product.getPrice() + " = " + totalPrice + " грн";
    }
}
