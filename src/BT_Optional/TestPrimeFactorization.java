package BT_Optional;

public class TestPrimeFactorization {
    public static void main(String[] args) {
        int number = 30;

        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization(number);
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization(number);

        Thread lazyThread = new Thread(lazyPrimeFactorization);
        Thread optimizedThread = new Thread(optimizedPrimeFactorization);

        lazyThread.start();
        optimizedThread.start();
    }
}
