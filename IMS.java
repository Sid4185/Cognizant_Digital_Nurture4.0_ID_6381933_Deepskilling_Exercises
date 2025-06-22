import java.util.*;

class Product {
    String productId, productName;
    int quantity;
    double price;

    Product(String id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

class Inventory {
    private Map<String, Product> stock = new HashMap<>();

    public void add(Product p) {
        stock.put(p.productId, p);
    }

    public void update(String id, int qty, double price) {
        if (stock.containsKey(id)) {
            Product p = stock.get(id);
            p.quantity = qty;
            p.price = price;
        }
    }

    public void delete(String id) {
        stock.remove(id);
    }

    public void showAll() {
        for (Product p : stock.values())
            System.out.println(p.productId + " " + p.productName + " " + p.quantity + " " + p.price);
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.add(new Product("P101", "Pen", 50, 5.0));
        inv.update("P101", 70, 4.5);
        inv.showAll();
        inv.delete("P101");
    }
}
