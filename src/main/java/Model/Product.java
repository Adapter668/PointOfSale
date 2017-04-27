package Model;

public class Product {
    private String barcode;
    private String name;
    private double price;

    public Product(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public Product setBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return this.price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getDisplay() {
        return this.name + "\t" + this.price;
    }
}
