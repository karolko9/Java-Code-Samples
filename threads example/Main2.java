import java.util.Random;

class MyThread1 extends Thread {
    public static int count = 0;

    public static synchronized void increment(){
        count++;
    }
    public static synchronized void decrement(){
        count--;
    }
    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = random.nextInt(1000);

        System.out.println("Wątek został uruchomiony. Czas trwania: " + sleepTime + " mS");

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wątek zakończył działanie.");
        decrement();
    }
}

public class Main2 {
    public static void main(String[] args) {
        int n = 5;

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new MyThread1();
            threads[i].start();
            MyThread1.increment();
        }

//        for (Thread thread : threads) { // czekanie na skończenie się każego wątku jeden po drugim
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while (MyThread1.count > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Oczekiwanie, aż liczba aktywnych wątków będzie wynosić zero
        }

        System.out.println("Główny program zakończył działanie po zakończeniu wszystkich wątków.");
    }
}
