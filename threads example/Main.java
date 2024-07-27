class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Wątek potomny (Runnable) rozpoczął działanie.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("Wątek potomny (Runnable) zakończył działanie.");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Wątek potomny (Thread) rozpoczął działanie.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("Wątek potomny (Thread) zakończył działanie.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Rozpoczęcie głównego wątku.");

        Thread runnableThread = new Thread(new MyRunnable());
        runnableThread.start();

        MyThread thread = new MyThread();
        thread.start();

        try {
            // czekanie na zakończenie wątków potomnych
            runnableThread.join();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Zakończenie głównego wątku.");
    }
}
