package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptTest {
    private Receipt receipt;

    @Before
    public void setUp() throws Exception {
        receipt = new Receipt();
    }

    @Test
    public void testAddProduct() throws Exception {
        Product test1 = new Product("12345", "asdf", 12.99);
        receipt.addProduct(test1);
        assertTrue(receipt.getProducts().contains(test1));
        assertEquals(12.99, receipt.getTotal(),0);

        Product test2 = new Product("54321", "fdsa", 3.21);
        receipt.addProduct(test2);
        assertTrue(receipt.getProducts().contains(test1) && receipt.getProducts().contains(test2));
        assertEquals(16.20, receipt.getTotal(),0);
    }

}