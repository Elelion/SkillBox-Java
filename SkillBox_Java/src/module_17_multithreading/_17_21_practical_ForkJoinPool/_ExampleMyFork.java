package module_17_multithreading._17_21_practical_ForkJoinPool;

import java.util.concurrent.RecursiveTask;

public class _ExampleMyFork extends RecursiveTask<Long> {
    long from, to;

    public _ExampleMyFork(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Long compute() {
        int coresCPU = Runtime.getRuntime().availableProcessors();

        /**
         * 10_000_000_000 / 8 = 1_250_000_000
         *
         * if: если операция разбита на достаточное кол-во частей,
         * выполняем операцию
         *
         * else: разбиваем на части по меньше
         */
        if ((to - from) <= 10_000_000_000L / coresCPU) {
            long j = 0;
            for (long i = from; i < to; i++) {
                j += i;
            }

            return j;
        } else {
            long middle = (to + from) / 2;

            /**
             * middle: 5_000_000_000
             * middle: 7_500_000_000
             * middle: 8_750_000_000
             * middle: 2_500_000_000
             * middle: 3_750_000_000
             * middle: 6_250_000_000
             * middle: 1_250_000_000
             */
            System.out.println("middle: " + middle);

            _ExampleMyFork firstHalf = new _ExampleMyFork(from, middle);
            firstHalf.fork();

            _ExampleMyFork secondHalf = new _ExampleMyFork(middle + 1, to);
            long secondValue = secondHalf.compute();

            return firstHalf.join() + secondValue;
        }
    }
}
