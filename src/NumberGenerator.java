public class NumberGenerator implements Runnable{

    @Override
    public void run() {
        for (int i = 1; 1 <= 10; i++){
            System.out.println("Thread ID: " + Thread.currentThread().getId() +
            " - Number: " + i + " - HashCode: " + this.hashCode());

            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        NumberGenerator  generator1 = new NumberGenerator();
        NumberGenerator  generator2 = new NumberGenerator();

        Thread thread1 = new Thread(generator1);
        Thread thread2 = new Thread(generator2);

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
     }
}
