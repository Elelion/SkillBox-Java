package module_17_multithreading._17_19_lecture_suspending_interrupting;

public class SuspendingAndInterrupting extends Thread {
    public SuspendingAndInterrupting() {
        Thread thread = new Processor();
        Thread interrupter = new Thread(new Interrupter(thread));

        thread.start();
        interrupter.start();
    }
}
