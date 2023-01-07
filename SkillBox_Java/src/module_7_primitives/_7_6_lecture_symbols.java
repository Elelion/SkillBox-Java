package module_7_primitives;

public class _7_6_lecture_symbols {
    public _7_6_lecture_symbols() {
        /**
         * в macOs + Linux для перехода на новую строку используется «\n» а в
         * Windows используется «\r\n», где \r - возврат коретки, а \n - переход
         * на новую строку. НО если мы хотим использовать универсальный переход
         * на новую строку который будет работать и на Win + macOS + Linux, то
         * мы используем System.lineSeparator();
         */
        System.out.print("test str" + System.lineSeparator());
        System.out.print("---" + System.lineSeparator());
        System.out.print("test str" + System.lineSeparator());
        System.out.println("---");

        /**/

        // \t - tab
        System.out.println("1st    2st");
        System.out.println("3st \t 4st");

        char tab = '\t';
        int tabCode = tab;
        System.out.println(tabCode); // выведет код табуляции

        char tab2 = (char) 9; // указываем тип к которому мы приводим число
        System.out.println(tab2); // выведет отсуп табуляции
//        System.out.println("---");

        /**/

        // выведет все символы
        for (int i = 0; i < 65536; i++) {
            char c = (char) i;
            // System.out.println(i + " - " + c);
        }

    }
}
