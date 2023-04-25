package module_17_multithreading._17_10_lecture_wait_notify;

public class WaitAndNotify {
    public WaitAndNotify() {
        // см Parking класс
        Parking parking = new Parking();

        Thread thread1 = new Thread(new Producer(parking)); // in
        Thread thread2 = new Thread(new Consumer(parking)); // out

        thread1.start();
        thread2.start();
    }
}
