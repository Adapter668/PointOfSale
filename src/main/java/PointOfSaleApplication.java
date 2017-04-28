import Controller.Controller;
import Database.Database;
import Database.Seeder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PointOfSaleApplication {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        Seeder seeder = new Seeder(database);
        database = seeder.seed();

        Controller controller = new Controller(database);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Boolean running = true;
        while (running) {
            System.out.println("\nEnter barcode:");
            String input = br.readLine();
            running = controller.startScanning(input);
        }
    }
}
