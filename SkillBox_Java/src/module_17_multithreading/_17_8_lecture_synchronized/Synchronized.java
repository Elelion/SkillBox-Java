package module_17_multithreading._17_8_lecture_synchronized;

import java.util.ArrayList;

public class Synchronized {
    private static ArrayList<Double> numbers = new ArrayList<>();

    public Synchronized() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(Synchronized::someHeavyMethod ));
        }

        System.out.println("Size: " + threads.size());

        // пробегаем по нашему списку где хранятся потоки !!! и запускаем каждый
        threads.forEach(t -> t.start());

        // второй тип вызова который то же работает
        // threads.forEach(Thread::start);
    }

    /**
     * если мы его запустим одновременно в нескольких потоках, то произойдут
     * рзные не приятные ошибки... для ошибок нужно запускать код несколько раз
     *
     * что бы ошибок не было - добавляем слово synchronized
     * это как Volatile но для методов
     */
    private static synchronized void someHeavyMethod() {
        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(Math.random() / Math.random());
        }

        System.out.println(numbers.size());
        numbers.clear();
    }

}
