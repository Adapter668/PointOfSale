import Controller.Controller;
import Database.Database;
import Input.BarcodeScanner;
import Model.Product;
import Model.Receipt;
import Output.LCDDisplay;
import Output.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointOfSaleApplication {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        database.addProductToDatabase(new Product("5904017128533", "notebook", 2.55));
        database.addProductToDatabase(new Product("9788374807289", "Mitologia Nordycka", 29.0));
        database.addProductToDatabase(new Product("4009900018784", "gum", 2.99));
        database.addProductToDatabase(new Product("3574660412277", "handcream", 9.99));

        Controller controller = new Controller(database, new BarcodeScanner(), new Printer(), new LCDDisplay(), new Receipt());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Enter barcode:");
            String input = br.readLine();
            controller.startScanning(input);
            if(input.equals("exit")) {
                break;
            }
        }
    }
}
