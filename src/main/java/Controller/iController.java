package Controller;

import Model.Product;

public interface iController {
    void productFound(Product product);
    void productNotFound();
    void emptyBarcode();
    void exit();
}
