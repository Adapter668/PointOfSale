package Model;

import java.util.ArrayList;

public class Receipt {
    private ArrayList<Product> products;
    private double total;

    public Receipt() {
        this.products = new ArrayList<Product>();
        this.total = 0;
    }

    public double getTotal() {
        return this.total;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
        this.total += product.getPrice();
    }

    public void deleteProduct(Product product) {
        this.products.remove(product);
        this.total -= product.getPrice();
    }

    public void clearReceipt() {
        this.products = new ArrayList<Product>();
        this.total = 0;
    }
}
