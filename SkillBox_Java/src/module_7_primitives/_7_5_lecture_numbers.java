package module_7_primitives;

public class _7_5_lecture_numbers {
    public _7_5_lecture_numbers() {
        byte b = 127;
        b++;

        /**
         * byte содержит значение от 0 до 127, при инкременте, произойдет
         * переполнение переменной, и результат будет 128, НО
         * со знаком минус. Те будет цикличность как показан ниже:
         *
         * + => -128 => -127 => -1 => 0 => 1 => 126 => 127 +
         * |                                               |
         * +-----<------------------------------------<----+
         */
        System.out.println(b); // -128
        System.out.println("---");

        /**/

        // в Java разрешено разделять дестяки нижним подчеркиванием
        int aComparison = 2_000_000_000;
        int bComparison = -1_500_000_000;
        int comparison = aComparison - bComparison;

        /**
         * из за того что будет переполнение, то результат будет противоположный
         * ожидаемому...
         */
        if (comparison > 0) {
            System.out.println("a > b");
        } else {
            System.out.println("b > a");
        }
        System.out.println("---");

        /**/

        /**
         * float представлено в следующем порядке
         * знак(1 бит) - порядок(8 бит) - мантисса(23 бит)
         */
        double d = 23_400_000_000_000.0;
        double d1 = 0.000_000_000_000_234;
        System.out.println(d);
        System.out.println(d1);

        /**/

        // long - надо помечать в конце "L"
        long value = 12_345_678_901L;
        System.out.println(value);
    }
}
