package module_3;

import java.util.Scanner;

public class _3_3_while_lecture {
    public static void main(String[] args) {
        // пример №1
        // бесконечный цикл
        /*
        while(true) {
            System.out.println("infinity....");
        }
        */

        /**/

        // пример №2
        int sum = 0;
        int value = -1;
        while (value != 0) {
            System.out.println("Введите целое число (для завершения введите - 0): ");
            value = new Scanner(System.in).nextInt();
            sum += value;
        }

        System.out.println("Сумма введенных чисел: " + sum);

        /**/

        // пример №3
        int secretPinCode = 1234;
        int pinCode = -1;

        // scanner - считывает введенные значения в консоль
        Scanner scanner = new Scanner(System.in);

        // выолнять до тех пор, пока введенный код НЕ равен указанному
        while (pinCode != secretPinCode) {
            if (pinCode == -1) {
                // выведится один раз
                System.out.println("Введите пароль:");
            } else {
                // выведится все последующие разы
                System.out.println("Пароль введён неверно. Введите верный пароль:");
            }

            // запрос на ввод строки из консоли, аналогично "cin >> ..." из С++
            pinCode = scanner.nextInt();
        }

        System.out.println("Пароль введён верно!!!");

        /**/

        // пример №4
        // do... while. Начала выполняет код, а потом проверяет условие
        // почти не используется

        // Пример: бесконечный цикл
        /*
        do {
            System.out.println("do");
        } while (true);
        */

        /**/

        /**
         * TODO: Задача 3.3.1
         * Напишите код, который будет складывать вводимые пользователем
         * в консоль числа и выводить сумму.
         */

        // 1.) В созданном проекте с именем Cycles в методе main создайте переменную
        // sum, равную нулю:
        int sum2 = 0;

        // 2.) Напишите вывод в консоль сообщения о том, что будет делать программа:
        // 3.) Напишите бесконечный цикл, используя оператор while, в теле которого
        // будет запрашиваться число из консоли:
        int val = 0;
        while (val != -1) {
            System.out.println("Введите число и нажмите <Enter>:");
            val = new Scanner(System.in).nextInt();

            // 4.) Затем, тоже в теле цикла, напишите проверку введённого числа.
            // Если введённое число больше нуля, прибавьте его к переменной sum
            // и выведите получившееся значение в консоль:

            if (val > 0) {
                sum += val;
            } else {
                // Если введённое число равно нулю, сбросьте сумму и напишите об этом в консоль
                sum = 0;
                System.out.println("Сумма сброшена. Введите новое число:");
            }

            System.out.println("Сумма: " + sum);
            System.out.println("Введите ещё одно число или 0 для сброса суммы:");
        }
    }
}
