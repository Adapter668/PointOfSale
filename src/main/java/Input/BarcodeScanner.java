package Input;

public class BarcodeScanner {
    public String scan(String barcode) {
        if(barcode.equals("")) {
            return "Invalid bar-code";
        } else {
            return barcode;
        }
    }
}
