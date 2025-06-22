interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() { System.out.println("Paid with Credit Card"); }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() { System.out.println("Paid with PayPal"); }
}

class PaymentContext {
    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) { this.strategy = strategy; }
    public void processPayment() { strategy.pay(); }
}

public class Main8 {
    public static void main(String[] args) {
        new PaymentContext(new CreditCardPayment()).processPayment();
        new PaymentContext(new PayPalPayment()).processPayment();
    }
}
