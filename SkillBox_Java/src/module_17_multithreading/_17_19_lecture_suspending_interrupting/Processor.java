package module_17_multithreading._17_19_lecture_suspending_interrupting;

public class Processor extends Thread {
    @Override
    public void run() {
        double sum = 0;

        for (;;) {
            // если поток был прерван, то...
            if (isInterrupted()) {
                System.out.println(sum);
                break;
            }

            sum += Math.random();
        }
    }
}
