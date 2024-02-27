package module_17_multithreading._17_11_lecture_thread_safe_classes;

import java.util.ArrayList;
import java.util.Vector;

public class ThreadSafeClasses {

    /**
     * если оставить так, то будет ошибка... тк несколько потоков будут
     * пересекаться:
     *
     * private ArrayList<Double> numbers = new ArrayList<>();
     *
     * что бы сделать безопасную запись, где потоки НЕ будут пересекаться
     * можно сделать как мы уже делали ранее - использовать synchronize итп
     * но так же можно использовать коллекцию которая потоко безопасна
     */
     private Vector<Double> numbers = new Vector<>();

    public ThreadSafeClasses() {
        /**
         * Потокобезопасные классы - нужны для того что бы безопасно работать
         * с данными из нескольких потоков - для этого служит Vector
         */

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    numbers.add(Math.random());
                }

                System.out.println(numbers.size());
            }));

        }

        threads.forEach(Thread::start);
    }
}
