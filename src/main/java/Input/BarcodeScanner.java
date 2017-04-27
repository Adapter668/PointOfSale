package Input;

public class BarcodeScanner {
    public String scan(String barcode) {
        if(barcode.length() == 0) {
            return "Invalid bar-code";
        } else {
            return barcode;
        }
    }
}
