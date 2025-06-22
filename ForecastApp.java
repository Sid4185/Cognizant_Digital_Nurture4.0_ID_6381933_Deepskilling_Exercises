class Forecast {
    public static double predict(double base, double rate, int years) {
        if (years == 0) return base;
        return rate * predict(base, rate, years - 1);
    }

    public static double predictOptimized(double base, double rate, int years) {
        double result = base;
        for (int i = 0; i < years; i++)
            result *= rate;
        return result;
    }
}

public class ForecastApp {
    public static void main(String[] args) {
        System.out.println(Forecast.predict(1000, 1.1, 3));
        System.out.println(Forecast.predictOptimized(1000, 1.1, 3));
    }
}
