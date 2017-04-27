package Database;

import Model.Product;

import java.util.ArrayList;

/**
 * Mock database
 */
public class Database {
    ArrayList<Product> productsDatabase;

    public Database() {
        this.productsDatabase = new ArrayList<Product>();
    }

    public void addProductToDatabase(Product product) {
        this.productsDatabase.add(product);
    }

    public Product findProductByBarcode(String barcode) {
        for (Product p: productsDatabase) {
            if(p.getBarcode().equals(barcode)) {
                return p;
            }
        }
        return null;
    }
}
