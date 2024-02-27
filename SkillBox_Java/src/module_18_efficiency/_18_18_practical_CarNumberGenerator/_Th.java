package module_18_efficiency._18_18_practical_CarNumberGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class _Th {
    double[] arrTemp;
    private final int N = 100_000_000;
    int cores = Runtime.getRuntime().availableProcessors();

    public _Th() throws FileNotFoundException, InterruptedException {
        long start = System.currentTimeMillis();

        arrTemp = new double[N];
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new ForkThread(0, N)));

        System.out.println("arrTemp.size: " + arrTemp.length);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    public class ForkThread extends RecursiveAction {
        private int from;
        private int to; // n

        public ForkThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected void compute() {
            /**
             * n(100_000_000) - 0 / cores(8) = 12_500_000
             * те если число будет равно = 12_500_000
             * то оно выполниться в один поток, а ЕСЛИ нет, ТО
             * будет разбиток столько раз, пока не станет равно 12_500_000
             */
            if (to - from <= N / cores ) {
                for (int i = from; i < to; i++) {
                    double t = (i * 3) + i + 3 + (i * 7);
                    arrTemp[i] = t;
                }
            } else {
                int middle = (to + from) / 2;
                ForkThread firstHalf = new ForkThread(from, middle);
                ForkThread secondHalf = new ForkThread(middle, to);

                /**
                 * invokeAll() - это метод класса ForkJoinTask, который позволяет
                 * выполнить все задачи, переданные в виде списка, с помощью
                 * фреймворка Fork-Join. Каждая задача из списка будет выполнена
                 * асинхронно в своем потоке, а метод invokeAll() будет блокировать
                 * текущий поток до тех пор, пока все задачи не будут выполнены.
                 *
                 * Метод invokeAll() возвращает список результатов выполнения каждой
                 * задачи в порядке, в котором они были переданы в список. Если
                 * задача не возвращает результат, то в качестве результата ей
                 * будет присвоено значение null.
                 *
                 * Использование метода invokeAll() особенно полезно в тех случаях,
                 * когда нужно распараллелить выполнение большого количества задач.
                 */
                invokeAll(firstHalf, secondHalf);
            }
        }
    }
}

