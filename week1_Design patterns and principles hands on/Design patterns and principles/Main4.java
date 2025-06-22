interface PaymentProcessor {
    void processPayment();
}

class OldGateway {
    public void pay() { System.out.println("Paid using OldGateway"); }
}

class OldGatewayAdapter implements PaymentProcessor {
    private OldGateway gateway;
    public OldGatewayAdapter(OldGateway gateway) { this.gateway = gateway; }
    public void processPayment() { gateway.pay(); }
}

public class Main4 {
    public static void main(String[] args) {
        PaymentProcessor processor = new OldGatewayAdapter(new OldGateway());
        processor.processPayment();
    }
}
