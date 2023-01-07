package module_8_numbers_and_dates;

public class _8_main {
    public static void main(String[] args) {
        // Лекция 8.2
        System.out.println("Лекция 8.2");
        module_8_numbers_and_dates._8_2_lecture_operations_with_numbers numbers =
            new module_8_numbers_and_dates._8_2_lecture_operations_with_numbers();
        System.out.println("-");

        /**/

        // Задание 8.2 - 1 (лекционное)
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(1999) + " шт.");
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(2000) + " шт.");
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(2001) + " шт.");
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(2500) + " шт.");
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(4000) + " шт.");
        System.out.println("Количество кассет: " +
            _8_2_task_1_MoneyCalculator.calculateCassetteCount(4001) + " шт.");
        System.out.println("-");

        /**/

        // Задание 8.2 - 2 (лекционное)
        System.out.println("Задание 8.2 - 2 (лекционное)");
        System.out.println("getCircleSquare: " +
            _8_2_task_2_GeometryCalculator.getCircleSquare(15));

        System.out.println("getCircleSquare: " +
            _8_2_task_2_GeometryCalculator.getCircleSquare(-5));

        System.out.println("getSphereVolume: " +
            _8_2_task_2_GeometryCalculator.getSphereVolume(5));

        System.out.println("getTriangleSquare: " +
            _8_2_task_2_GeometryCalculator.getTriangleSquare(3, 4, 5));

        System.out.println("---");


        /* ----------------------------------------------------------------- */

        // Лекция 8.3
        System.out.println("Лекция 8.3");
        _8_3_lecture_increment_and_decrement incDecr = new _8_3_lecture_increment_and_decrement();

        System.out.println("-");

        // Задание 8.3 - 1 (лекционное)
        System.out.println("Задание 8.3 - 1 (лекционное)");
        _8_3_task_UsageAnalytics analytics = new _8_3_task_UsageAnalytics();
        analytics.countVisit();
        analytics.countVisit();
        int visits = analytics.countVisit();
        System.out.println("Всего посещений: " + visits);
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        // Лекция 8.4
        System.out.println("Лекция 8.4");
        _8_4_lecture_RemoteControl control = new _8_4_lecture_RemoteControl();

        // преобразование типов - явный
        int temp = (int) control.getTemperature();

        _8_4_lecture_AirConditioner conditioner = new _8_4_lecture_AirConditioner();
        conditioner.setTemperature(temp);
        System.out.println("-");

        long now = System.currentTimeMillis();
        int seconds = (int) (now / 1000);
        System.out.println(seconds); // секунд прошло с 1 января 1970гг

        /**
         * из за не явного преобразавания тк не контролируем размер значения
         * результат не предсказуем
         */
        long value = 1_000_000_000_000L;
        System.out.println((int) value);
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        // Лекция 8.5
        System.out.println("Лекция 8.5");
        _8_5_lecture_accuracy_of_calculations calc = new _8_5_lecture_accuracy_of_calculations();
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        // Лекция 8.6
        System.out.println("Лекция 8.6");
        _8_6_lecture_large_and_accurate_numbers largeAccNumbers = new _8_6_lecture_large_and_accurate_numbers();

        /* ----------------------------------------------------------------- */

        // Лекция 8.7
        System.out.println("Лекция 8.7");
        _8_7_lecture_date_and_time dateTime = new _8_7_lecture_date_and_time();
        System.out.println("-");

        /**/

        // Задание 8.7 - 1 (лекционное)
        System.out.println("Задание 8.7 - 1 (лекционное)");
        _8_7_task_NumberAndDateExperiments task_8_7_1 = new _8_7_task_NumberAndDateExperiments();
        System.out.println("-");

        /* ----------------------------------------------------------------- */

        // Лекция 8.8
        System.out.println("Лекция 8.8");
        _8_8_lecture_timestamp timestamp = new _8_8_lecture_timestamp();
        System.out.println("-");
    }
}
