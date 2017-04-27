package Output;

import Model.Product;
import Model.Receipt;

public class Printer {
    public void print(Receipt receipt) {
        System.out.println("Receipt:");
        for (Product p: receipt.getProducts()) {
            System.out.println(p.getName() + "\t" + p.getPrice());
        }
        System.out.println("\nTotal:\t" + receipt.getTotal());
    }
}
