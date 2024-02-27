package module_17_multithreading._17_10_lecture_wait_notify;

public class Consumer implements Runnable {
    private Parking parking;

    public Consumer(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            parking.out();
        }
    }
}
