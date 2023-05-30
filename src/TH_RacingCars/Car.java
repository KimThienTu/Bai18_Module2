package TH_RacingCars;

import java.util.Random;

public class Car implements Runnable{
    // Khai báo tên của xe đua.
    private String name;

    public Car(String name){
        this.name = name;
    }

    @Override
    public void run(){
        // Khởi tạo điểm start.
        int runDistance = 0;
        // Khởi tạo time bắt đầu cuộc đua.
        long startTime = System.currentTimeMillis();
        // Kiểm tra chừng nào còn xe chưa hoàn thành cuộc đua.
        while (runDistance < DISTANCE){
            try {
                // Random tô độ km/h.
                int speed = (new Random()).nextInt(20);
                // Tính toán khoảng cách đã đi được.
                runDistance += speed;
                // Vẽ đường đã đi của xe.
                String log = " ";
                int percentTravel = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i += STEP){
                    if (percentTravel >= i + STEP){
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + STEP){
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("Car" + this.name + " : " + log + " " + Math.min(DISTANCE, runDistance) + "Km");
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Car" + this.name + " broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
    }

    public static int DISTANCE = 100;
    public static int STEP = 2;

    public static void main(String[] args) {
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        Thread thread1 = new Thread(carA);
        Thread thread2 = new Thread(carB);
        Thread thread3 = new Thread(carC);

        System.out.println("Distance: 100Km");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
