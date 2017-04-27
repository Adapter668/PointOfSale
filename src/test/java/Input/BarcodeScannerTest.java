package Input;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeScannerTest {
    private BarcodeScanner barcodeScanner;

    @Before
    public void setUp() {
        barcodeScanner = new BarcodeScanner();
    }

    @Test
    public void testEmptyScan() {
        String output = barcodeScanner.scan("");
        assertTrue(output.equals("Invalid bar-code"));
    }

    @Test
    public void testExitScan() {
        String output = barcodeScanner.scan("exit");
        assertTrue(output.equals("exit"));
    }

    @Test
    public void testScan() {
        String input = "123456789";
        String output = barcodeScanner.scan(input);
        assertTrue(output.equals(input));
    }

}