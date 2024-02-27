package module_17_multithreading;

import module_17_multithreading._17_21_practical_ForkJoinPool.SiteMapGenerator;
import module_17_multithreading._17_21_practical_ForkJoinPool._ExampleSiteMapGenerator_1;
import module_17_multithreading._17_21_practical_ForkJoinPool._ExampleSiteMapGenerator_2;

import java.io.IOException;
import java.util.concurrent.*;

public class _17_practical_main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Практика 17.4");
//        new Multithreading();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Практика 17.13");
//        new Transactions();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Практика 17.21");


        // задаем кол-во потоков, 8 ядер = 8 потоков
//        int coresCPU = Runtime.getRuntime().availableProcessors();
//        ForkJoinPool pool = new ForkJoinPool(coresCPU);

        /**
         * .invoke(...) - используется для запуска задачи, представленной
         * объектом класса ForkJoinTask, в текущем пуле. Этот метод
         * используется для выполнения задачи в режиме синхронного вызова,
         * то есть пока задача не завершится, метод не вернет результат.
         */
//        System.out.println(pool.invoke(new _MyForkExample(0, 10_000_000_000L)));


        long startProgramExecution = System.currentTimeMillis();

//        try {
            new SiteMapGenerator();
//            new _ExampleSiteMapGenerator_1();
//            new _ExampleSiteMapGenerator_2();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println("Время выполнения: " + (System.currentTimeMillis() - startProgramExecution) + " мс");

        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");
    }

}
