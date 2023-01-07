package module_3;

import java.text.NumberFormat;
import java.util.Scanner;

public class _3_8_1_practical_FactorialCalculator {
    public static void main(String[] args) {
        /**
         * TODO: Задача 3.8 - 1
         * - Создайте новый проект и назовите его FactorialCalculator.
         *
         * - Создайте класс Main и метод main.
         *
         * - Создайте переменную типа int и получите её значение из консоли:
         * int value = new Scanner(System.in).nextInt();
         *
         * - Напишите программу, которая будет считать факториал переданного в
         * консоли числа. Факториал целого числа — это произведение этого целого
         * числа на все целые положительные числа меньше него. Обозначается
         * восклицательным знаком. Вот примеры расчётов факториала для некоторых чисел:
         * 3! = 1 × 2 × 3 = 6
         * 5! = 1 × 2 × 3 × 4 × 5 = 120
         * Для проверки кода используйте числа от 1 до 12.
         */

        // для разделения разрядов
        NumberFormat formatNum = NumberFormat.getInstance();
        int sum = 1;

        System.out.println("Введите целое число для расчета факториала:");
        int value = new Scanner(System.in).nextInt();

        for (int i = 1; i < value; i++) {
            sum += sum * i;
        }

        System.out.println(value + "! = " + formatNum.format(sum));
    }
}
