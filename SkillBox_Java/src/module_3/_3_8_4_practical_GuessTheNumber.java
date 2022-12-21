package module_3;

import java.util.Random;
import java.util.Scanner;

public class _3_8_4_practical_GuessTheNumber {
    public static void main(String[] args) {
        /**
         * TODO: Задача 3.8 - 4
         * - Создайте новый проект GuessTheNumber. Напишите в нём программу-игру,
         * в которой пользователь будет угадывать некое число, а программа, если
         * он не угадал, будет сообщать ему, больше или меньше введённое им
         * число, чем загаданное.
         *
         * - В начале программы создайте переменную int с именем value, в которой
         * будет храниться угадываемое число.
         *
         * - Напишите бесконечный цикл с использованием оператора while, в котором
         * вы будете получать введённое пользователем число из консоли.
         * int attempt = new Scanner(System.in).nextInt();
         *
         * - Напишите проверку этого числа: если число равно загаданному,
         * выводите в консоль сообщение «Вы угадали!» и завершайте цикл.
         *
         * - Если пользователь не угадал число, выводите в консоль подсказку:
         * больше или меньше введённое число, чем загаданное.
         * 30 - загаданное число больше
         * 77 - загаданное число меньше
         * 60 - вы угадали
         *
         * - Рекомендации по выполнению
         * Если хотите создать более реальную программу, нужно, чтобы загадываемое число генерировалось случайным образом в диапазоне от 0 до 100:
         * int value = new Random().nextInt(100);
         */

        Scanner scanner = new Scanner(System.in);
        final int secretNumber = new Random().nextInt(100);
        int value = 0;

        System.out.println("Секретное число: " + secretNumber);

        while (true) {
            System.out.println("Угадай загаданное число:");
            value = scanner.nextInt();

            // Вариант №1
            /*
            if (value > secretNumber) {
                System.out.println("загаданное число меньше");
            } else if (value < secretNumber) {
                System.out.println("загаданное число больше");
            } else if (value == secretNumber) {
                System.out.println("вы угадали");
                break;
            }
            */

            // Вариант №2 (по мне хоть он и более громоздкий, зато более читабельный
            int answer = -1;
            if (value > secretNumber) answer = 1;
            if (value < secretNumber) answer = -1;
            if (value == secretNumber) answer = 0;

            switch (answer) {
                case 1 -> System.out.println("загаданное число меньше");
                case -1 -> System.out.println("загаданное число больше");
                case 0 -> System.out.println("вы угадали");
            }

            if (answer == 0) break;
        }
    }
}
