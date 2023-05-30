public class OddThread extends Thread{
    @Override
    public void run(){
        for (int i = 1; i <= 10; i += 2){
            System.out.println("OddThread: " + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Eventhread extends Thread {
    @Override
    public void run(){
        for (int i = 2; i <= 10; i += 2){
            System.out.println("EvenThread: " + i);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class TestThread {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        Eventhread evenThread = new Eventhread();

        oddThread.start();

        try {
            oddThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        evenThread.start();
    }
}
