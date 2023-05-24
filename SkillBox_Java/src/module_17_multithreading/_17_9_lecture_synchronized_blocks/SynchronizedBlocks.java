package module_17_multithreading._17_9_lecture_synchronized_blocks;

import java.util.ArrayList;

public class SynchronizedBlocks {
    private static ArrayList<Double> numbers = new ArrayList<>();

    public SynchronizedBlocks() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(SynchronizedBlocks::someHeavyMethod ));
        }

        System.out.println("Size: " + threads.size());

        threads.forEach(t -> t.start());
    }

    private static void someHeavyMethod() {
        for (int i = 0; i < 1_000_000; i++) {

            /**
             * иногда эта строка может вызывать ошибки при работе потоков
             * что бы обезапасить именно эту строку, и оставить наше поведение
             * работы программы - мы можем
             *
             * synchronized() - в нутри пишем объект по которому мы
             * синхронизируемся
             *
             * если numbers используется где то еще, то его то же нужно
             * обрамить в блок synchronized()
             *
             * можем за место переменной синхронизировать целый класс,
             * например так: SynchronizedBlocks.class
             */
            //synchronized(SynchronizedBlocks.class) {
            synchronized(numbers) {
                numbers.add(Math.random() / Math.random());
            }

        }

        System.out.println(numbers.size());
        numbers.clear();
    }

}
