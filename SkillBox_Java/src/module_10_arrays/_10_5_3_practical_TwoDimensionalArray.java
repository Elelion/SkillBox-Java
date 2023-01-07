package module_10_arrays;

public class _10_5_3_practical_TwoDimensionalArray {
    public final static char SYMBOL = 'X';

    public _10_5_3_practical_TwoDimensionalArray() {
        /**
         * TODO: Задание 10.5 - 3
         * - В классе TwoDimensionalArray   реализуйте метод
         * public static char[][] getTwoDimensionalArray(int size) {
         * который должен создать двумерный массив размера size, на диагоналях
         * которого должны быть символы 'X', в остальных ячейках пробел ' '.
         * - Если распечатать массив сформированный методом
         * getTwoDimensionalArray с аргументом 7, то должны получить:
         * X    X
         *  X  X
         *   XX
         *   X
         *   XX
         *  X  X
         * X    X
         */

        getTwoDimensionalArray(7);
    }

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] cross = new char[size][size];

        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross.length; j++) {
                if (j == i || i == cross.length - 1 - j) {
                    cross[i][j] = SYMBOL;
                } else {
                    cross[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < cross.length; j++) {
                System.out.print(cross[i][j] + " ");
            }
            System.out.println();
        }

        return cross;
    }
}
