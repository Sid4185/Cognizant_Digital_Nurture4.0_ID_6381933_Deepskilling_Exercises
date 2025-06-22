interface Notifier {
    void send();
}

class EmailNotifier implements Notifier {
    public void send() { System.out.println("Email sent"); }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier) { this.notifier = notifier; }
}

class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) { super(notifier); }
    public void send() {
        notifier.send();
        System.out.println("SMS sent");
    }
}

class SlackNotifier extends NotifierDecorator {
    public SlackNotifier(Notifier notifier) { super(notifier); }
    public void send() {
        notifier.send();
        System.out.println("Slack sent");
    }
}

public class Main5 {
    public static void main(String[] args) {
        Notifier notify = new SlackNotifier(new SMSNotifier(new EmailNotifier()));
        notify.send();
    }
}
