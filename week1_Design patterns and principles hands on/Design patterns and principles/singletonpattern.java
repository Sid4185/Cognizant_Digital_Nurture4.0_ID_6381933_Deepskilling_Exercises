public class Logger {
    private static Logger instance;
    private Logger() {}
    public static synchronized Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Logger a = Logger.getInstance();
        Logger b = Logger.getInstance();
        a.log("Started Application");
        System.out.println(a == b);
    }
}
