package BT_Optional;

public class OptimizedPrimeFactorization implements Runnable {
    private int number;

    public OptimizedPrimeFactorization(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.println("OptimizedPrimeFactorization: " + i);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
