package module_17_multithreading._17_10_lecture_wait_notify;

public class Parking {
    private int parkingSize = 500;
    private int carCount = 0;

    /**
     * без доп методов потоки будут хаотично брать наши методы, по этому
     * результат будет не предсказуемым
     *
     * wait() - освобождает монитор и переводит вызывающий поток в состояние
     * ожидания, до тех пор, пока другой поток не вызовит метод notify() у
     * того же объекта.
     *
     * notify() - продолжает работу потока у которого ранее был вызван метод wait()
     *
     * notifyAll() - возобновляет работу всех потоков, у которых ранее
     * был вызван метод wait()
     */
    public synchronized void in() {
        // делаем проверку что бы машин не стало больше парковочных мест
        if (carCount == parkingSize) {
            /**
             * останавливаем поток тем самым мы ждем пока другие потоки
             * убавят кол-во машин (те отработает метод out()) что бы появились
             * свободные места
             */
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount++;
        System.out.println("Автомобиль завезен");
        System.out.println("Свободных мест: " + (parkingSize - carCount));

        /**
         * продолжаем работу потока
         * как только у нас появятся свободные места, те другие потоки отработают
         * метод out() то мы возобновляем работу потоков которые ждут свободные
         * места
         */
        notify();
    }

    public synchronized void out() {
        // делаем проверку что бы не уйти в минус
        if (carCount == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        carCount--;
        System.out.println("Автомобиль вывезен");
        System.out.println("Свободных мест: " + (parkingSize - carCount));
        notify();
    }
}
