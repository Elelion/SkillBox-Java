package module_17_multithreading._17_5_lecture_race_status_critical_sections;

public class CriticalSections {
    public CriticalSections() {
        ValueStorage valueStorage = new ValueStorage();

        for (int i = 0; i < 4; i++) {

            /**
             * запускаем 4 одинаковых потока, где каждый из которых
             * N раз вызывает метод incrementValue
             *
             * и после цикла печатает значение
             */
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {

                    /**
                     * чем больше мы задаем число в цикле
                     * тем больше борьба происходит за метод incrementValue
                     *
                     * те создаются параллельные потоки
                     * в одном потоке 1 может уже прибавилась
                     * а в другом потоке она еще не прибавилась и по этому
                     * значения каждый раз будут разными
                     *
                     * те incrementValue - не является атомарным
                     *
                     * так же данный метод является - критической секцией - тк
                     * за него постоянно происходит конкурентная борьба
                     * между потоками
                     */
                    valueStorage.incrementValue();
                }

                System.out.println(valueStorage.getValue());
            }).start();
        }
    }
}
