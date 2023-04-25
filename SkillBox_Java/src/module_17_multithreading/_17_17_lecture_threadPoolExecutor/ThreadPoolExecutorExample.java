package module_17_multithreading._17_17_lecture_threadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExample {
    public ThreadPoolExecutorExample() {
        /**
         * ThreadPoolExecutor - расширяемый пулл потоков со множеством параметров
         * с помощью которых можно регулировать этот пулл поток
         */
        // пример №1
        ThreadPoolExecutor executor1 =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(5);


        /**/


        // пример №2
        // Создание пула потоков с фиксированным количеством потоков
        ExecutorService executor2 = Executors.newFixedThreadPool(5);

        // Получение экземпляра ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor2;

        /**
         * setCorePoolSize - задает кол-во потоков, мы их уже задали выше, если
         * потоки все заняты то потоки будут увеличиваться до
         * параметра - setMaximumPoolSize
         *
         * setCorePoolSize - задает максимальное кол-во потоков, до которого
         * можно увеличиваться
         *
         * setKeepAliveTime - задает время, в течении которого потоки могут
         * находиться в состоянии бездействия
         */
//        threadPoolExecutor.setCorePoolSize();
//        threadPoolExecutor.setMaximumPoolSize(50);
//        threadPoolExecutor.setKeepAliveTime();

        // распечатать размер очереди потоков, который ждут своего выполнения
        threadPoolExecutor.getQueue().size();

        // получить кол-во активных потоков
        threadPoolExecutor.getActiveCount();

        threadPoolExecutor.shutdown();
    }
}
