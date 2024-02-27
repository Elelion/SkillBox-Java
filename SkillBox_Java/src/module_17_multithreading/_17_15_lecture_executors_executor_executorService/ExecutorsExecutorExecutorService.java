package module_17_multithreading._17_15_lecture_executors_executor_executorService;

import java.util.concurrent.*;

public class ExecutorsExecutorExecutorService {
    public ExecutorsExecutorExecutorService() {
        /**
         * Пуллы потоков
         * бесконтрольное создание потоков может повлиять на производительноть
         * системы
         *
         * можно создавать задачи и отдавать их пуллам потоков, которые будут
         * запускать их поочереди так, что бы работало оптимальное кол-во потоков
         *
         * Пуллы потоков НЕ завершаются сами, их надо специально завершать
         * командой Shutdown.
         */

        // Executor & Executors - использует Runnable
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + (int) (Math.random() * 20));
            }
        });
        // будет ошибка, метод есть только у ExecutorService
        // executor.shutdown();

        // ExecutorService - использует Callable
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Double> future = service.submit(() -> {
            double sum = 0;

            for (int i = 0; i < 10; i++) {
                sum += Math.random();
            }

            return sum;
        });

        // Exceptions возникают если вдруг поток прервало
        try {
            System.out.println("ExecutorService: " + future.get());
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
