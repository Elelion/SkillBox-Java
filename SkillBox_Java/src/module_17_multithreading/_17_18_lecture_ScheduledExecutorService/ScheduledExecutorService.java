package module_17_multithreading._17_18_lecture_ScheduledExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {
    public ScheduledExecutorService() {

        /**
         * ScheduledExecutorService - позволяет создавать задчи через которое
         * то время
         */

        // задаем 5 потоков
        java.util.concurrent.ScheduledExecutorService service =
            Executors.newScheduledThreadPool(5);

        service.schedule(() -> System.out.println("YES"), 5000, TimeUnit.MILLISECONDS);

        /**
         * запустить поток через 2 сек и повторять его каждые 3 сек
         * время задаеться от НАЧАЛА задачи
         */
        /*
        service.scheduleAtFixedRate(() ->
            System.out.println("TTT"),
            1000,
            2000,
            TimeUnit.MILLISECONDS);
         */

        // аналогично scheduleAtFixedRate - но время задается от КОНЦА задачи
        service.scheduleWithFixedDelay(() -> System.out.println("AAA"), 1000, 2000, TimeUnit.MILLISECONDS);

        service.scheduleAtFixedRate(() ->
            service.shutdown(),
            8000,
            8000,
            TimeUnit.MILLISECONDS);
    }
}
