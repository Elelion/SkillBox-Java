package module_17_multithreading._17_19_lecture_suspending_interrupting;

public class Interrupter implements Runnable {
    private Thread thread;

    // передаем в качестве параметра наш поток
    public Interrupter(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // прерываем наш поток, который мы передали - new Processor();
        thread.interrupt();
    }
}
