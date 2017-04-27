package Controller;

import static org.mockito.Mockito.*;

import Database.Database;
import Input.BarcodeScanner;
import Model.Product;
import Model.Receipt;
import Output.LCDDisplay;
import Output.Printer;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
    private Controller controller;
    private Database database;
    private BarcodeScanner barcodeScanner;
    private Printer printer;
    private LCDDisplay lcdDisplay;
    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        database = mock(Database.class);
        barcodeScanner = mock(BarcodeScanner.class);
        printer = mock(Printer.class);
        lcdDisplay = mock(LCDDisplay.class);
        receipt = mock(Receipt.class);
        controller = new Controller(database, barcodeScanner, printer, lcdDisplay, receipt);

        when(barcodeScanner.scan("")).thenReturn("Invalid bar-code");
        when(barcodeScanner.scan("4009900018784")).thenReturn("4009900018784");
        when(database.findProductByBarcode("4009900018784")).thenReturn(new Product("4009900018784", "gum", 2.99));
        when(database.findProductByBarcode(anyString())).thenReturn(null);
    }

    @Test
    public void testProductFound() throws Exception {
        controller.productFound(new Product("123456789", "asdf", 99.99));
        verify(lcdDisplay, times(1)).display(anyString());
        verify(receipt, times(1)).addProduct(any(Product.class));
    }

    @Test
    public void testProductNotFound() throws Exception {
        controller.productNotFound();
        verify(lcdDisplay, times(1)).display("Product not found");
    }

    @Test
    public void testEmptyBarcode() throws Exception {
        controller.emptyBarcode();
        verify(lcdDisplay, times(1)).display("Invalid bar-code");
    }

    @Test
    public void testExit() throws Exception {
        controller.exit();
        verify(printer, times(1)).print(receipt);
        verify(lcdDisplay, times(1)).display(String.valueOf(receipt.getTotal()));
    }

    @Test
    public void testEmptyStartScanning() {
        controller.startScanning("");
        verify(barcodeScanner, atLeastOnce()).scan("");
    }

    @Test
    public void testStartScanning() {
        controller.startScanning("4009900018784");
        verify(barcodeScanner, atLeastOnce()).scan("4009900018784");
        verify(database).findProductByBarcode("4009900018784");
    }

}