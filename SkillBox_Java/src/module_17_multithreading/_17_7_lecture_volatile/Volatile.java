package module_17_multithreading._17_7_lecture_volatile;

import java.util.Scanner;

public class Volatile {

    /**
     * Volatile - Короче говоря, определение переменной с ключевым словом
     * volatile(«изменчивый») означает, что значение переменной будет
     * изменяться разными потоками.
     */
    private volatile int test = 0;

    public Volatile() {
        Task task = new Task(); // isRunning = true;
        new Thread(task).start(); // while (isRunning) {...}

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        task.stop(); // isRunning = false;
        System.out.println("Main: " + task.getCounterValue());
    }
}
