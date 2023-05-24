package module_10_arrays;

import java.util.Arrays;

public class _10_5_1_practical_ReverseArray {
    public _10_5_1_practical_ReverseArray() {
        /**
         * TODO: Задание 10.5 - 1
         * - В классе ReverseArray реализуйте метод reverse(), который должен
         * поменять порядок элементов на обратный и вернуть тот же самый массив.
         * - Проверьте ваш код с помощью тестов.
         *
         * Пример
         * • Первоначальный массив: [“a”, “b”, “c”, “d”].
         * • Массив с элементами в обратном порядке: [“d”, “c”, “b”, “a”].
         */

        String[] myArray = {"a", "b"};
        String[] convert = reverse(myArray);

        System.out.print("[");
        String separator = "";
        for (int i = 0; i < convert.length; i++) {
            separator = (i + 1 == convert.length) ? "" : ", ";
            System.out.print(convert[i] + separator);
        }
        System.out.print("]");
        System.out.println("");
    }

    public static String[] reverse(String[] listArray) {

        // копирование массива может быть осуществлено любым способом что ниже:
        //int[] tempArray = new int[listArray.length];
        //int[] tempArray = Arrays.copyOf(listArray, listArray.length);
        String[] tempArray = listArray.clone();

        // способ №1
        /*
        for (int i = listArray.length - 1; i > 0;) {
            for (int j = 0; j < listArray.length; j++) {
                 tempArray[j] = listArray[i];
                 i--;
            }
        }
        */

        /**/

        // способ №2
        for (int i = 0, j = tempArray.length - 1; i < listArray.length; i++, j--) {
             tempArray[j] = listArray[i];
        }

        return tempArray;
    }
}
