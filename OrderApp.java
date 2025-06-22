class Order {
    String orderId, customerName;
    double totalPrice;

    Order(String id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

class OrderSorter {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order t = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = t;
                }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low;
        for (int j = low; j < high; j++)
            if (orders[j].totalPrice < pivot) {
                Order t = orders[i];
                orders[i] = orders[j];
                orders[j] = t;
                i++;
            }
        Order t = orders[i];
        orders[i] = orders[high];
        orders[high] = t;
        return i;
    }
}

public class OrderApp {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O1", "Alice", 450),
            new Order("O2", "Bob", 300),
            new Order("O3", "Zara", 600)
        };
        OrderSorter.quickSort(orders, 0, orders.length - 1);
        for (Order o : orders) System.out.println(o.orderId + " " + o.totalPrice);
    }
}

