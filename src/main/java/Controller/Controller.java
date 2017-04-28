package Controller;

import Database.Database;
import Input.BarcodeScanner;
import Model.Product;
import Model.Receipt;
import Output.LCDDisplay;
import Output.Printer;

public class Controller implements iController {
    private Database database;
    private BarcodeScanner barcodeScanner;
    private Printer printer;
    private LCDDisplay lcdDisplay;
    private Receipt receipt;

    public Controller(Database database, BarcodeScanner barcodeScanner, Printer printer, LCDDisplay lcdDisplay, Receipt receipt) {
        this.database = database;
        this.barcodeScanner = barcodeScanner;
        this.printer = printer;
        this.lcdDisplay = lcdDisplay;
        this.receipt = receipt;
    }

    public Controller(Database database) {
        this.database = database;
        this.barcodeScanner = new BarcodeScanner();
        this.printer = new Printer();
        this.lcdDisplay = new LCDDisplay();
        this.receipt = new Receipt();
    }

    public void productFound(Product product) {
        lcdDisplay.display(product.getDisplay());
        receipt.addProduct(product);
    }

    public void productNotFound() {
        lcdDisplay.display("Product not found");
    }

    public void emptyBarcode() {
        lcdDisplay.display("Invalid bar-code");
    }

    public void exit() {
        printer.print(receipt);
        lcdDisplay.display(String.valueOf(receipt.getTotal()));
    }

    public Boolean startScanning(String input) {
        if (input.equals("exit")) {
            exit();
            return false;
        }
        else {
            String scannedInput = barcodeScanner.scan(input);
            if (scannedInput.equals("Invalid bar-code")) emptyBarcode();
            else {
                Product product = database.findProductByBarcode(scannedInput);
                if(product == null) productNotFound();
                else productFound(product);
            }
        }
        return true;
    }
}
