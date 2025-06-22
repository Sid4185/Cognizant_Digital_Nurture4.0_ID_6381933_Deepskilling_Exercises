interface Observer {
    void update(float price);
}

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyAllObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private float price;
    public void setPrice(float price) {
        this.price = price;
        notifyAllObservers();
    }
    public void register(Observer o) { observers.add(o); }
    public void deregister(Observer o) { observers.remove(o); }
    public void notifyAllObservers() {
        for (Observer o : observers) o.update(price);
    }
}

class MobileApp implements Observer {
    public void update(float price) { System.out.println("Mobile price update: " + price); }
}

class WebApp implements Observer {
    public void update(float price) { System.out.println("Web price update: " + price); }
}

public class Main7 {
    public static void main(String[] args) {
        StockMarket stock = new StockMarket();
        stock.register(new MobileApp());
        stock.register(new WebApp());
        stock.setPrice(100.5f);
    }
}
