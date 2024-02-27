package module_3;

import java.util.Scanner;

public class _3_8_2_practical_ForCycle {
    public static void main(String[] args) {
        /**
         * TODO: Задача 3.8 - 2
         * - Создайте новый проект и назовите его ForCycle.
         *
         * - Создайте класс Main и метод main.
         *
         * - Создайте переменную типа int и получите её значение из консоли:
         * int value = new Scanner(System.in).nextInt();
         *
         * - Напишите программу, которая будет находить все пары положительных
         * целых чисел, произведение которых будет равно значению value.
         * Например, если ввести число 6, программа должна выдать следующий результат:
         * 1*6
         * 2*3
         * 3*2
         * 6*1
         *
         * - Рекомендации по выполнению
         * Для написания программы используйте два цикла for — один, вложенный в другой.
         */

        System.out.println("Введите целое число для нахождение пар чисел:");
        int value = new Scanner(System.in).nextInt();

        /**/

        for (int i = value; i >= 0; i--) {
            for (int j = value; j >= i; j--) {
                if (i * j == value) {
                    System.out.println("Пара: " + i + "|" + j);
                }
            }
        }

        // комментарии оставил для отладки что бы видеть наглядно что происходит
        for (int i = 1; i <= value; i++) {
            // System.out.println("i: " + i);
            for (int j = 1; j <= i; j++) {
                if (i * j == value) {
                    System.out.println("Пара: " + i + "|" + j);
                }
                // System.out.println("j: " + j);
            }
            // System.out.println("-");
        }


    }
}
