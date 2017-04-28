package Database;

import Model.Product;

public class Seeder {
    private Database database;

    public Seeder(Database database) {
        this.database = database;
    }

    public Database seed() {
        database.add(new Product("5904017128533", "notebook", 2.55));
        database.add(new Product("9788374807289", "Mitologia Nordycka", 29.00));
        database.add(new Product("4009900018784", "gum", 2.99));
        database.add(new Product("3574660412277", "handcream", 9.99));
        return database;
    }
}
