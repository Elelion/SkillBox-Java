package module_17_multithreading._17_14_lecture_callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public abstract class Callable {
    public Callable() {
        /**
         * ранее мы вызывали потоки так
         * new Thread(() -> {...}).start();
         *
         * но так же потоки можно вызвать и через callable
         * в нутри callable уже написал Throw exception
         */

        /**
         * Callable - похож на интерфейс Runnable, но Callable позволяет
         * возвращать значение и генерировать исключения, в то время
         * как метод run() в интерфейсе Runnable не возвращает значение и
         * не может генерировать исключения.
         *
         * Так же Callable может быть использован для обработки ошибок в
         * многопоточном программировании. Если исключение возникает в
         * Callable, то оно может быть перехвачено и обработано, в отличие
         * от случая, когда исключение возникает в Runnable, которое не может
         * быть передано обратно в вызывающий поток.
         */
        java.util.concurrent.Callable callable = () -> {
            double sum = 0;
            for (int i = 0; i < 1_000; i++) {
                sum += Math.random();
            }

            if (sum / 1_000 < 0.5) {
                throw new IllegalArgumentException("-> ERR <-");
            }
            return sum / 1_000;
        };

        FutureTask<Double> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            // пишем свой catch для отлова исключения
            System.out.println("-> EXP: <- " + e.getMessage());
        }
    }

    public abstract Void call() throws Exception;
}
