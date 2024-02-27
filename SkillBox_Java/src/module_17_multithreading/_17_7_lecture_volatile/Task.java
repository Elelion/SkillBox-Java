package module_17_multithreading._17_7_lecture_volatile;

public class Task implements Runnable {
    private long counter;

    /**
     * если мы уберем слово volatile, то строка
     * System.out.println("Task: " + counter)
     * не когда не выполниться
     *
     * объясняется это тем, что при отсутствии синхронизации JVM может
     * преобразовать код:
     * while (isRunning) {}
     *
     * в код:
     * if (isRunning)
     * while (true) {}
     *
     * эти преобразования делаются ради оптимизации. И программа никогда не
     * заканчивается.
     * исправить ситуацию может уже упомянутая синхронизация либо ключевое
     * слово volatile.
     */
    private volatile boolean isRunning;

    public Task() {
        isRunning = true;
    }

    @Override
    public void run() {
        while (isRunning) {
            counter++;
        }

        System.out.println("Task: " + counter);
    }

    public void stop() {
        isRunning = false;
    }

    public long getCounterValue() {
        return counter;
    }
}
