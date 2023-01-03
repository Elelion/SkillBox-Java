package module_3;

import java.util.Scanner;

public class _3_2_for_lecture {
    public static void main(String[] args) {
        for (int i = 15; i < 40; i++) {
            // sout - автоподмена на System.out.printLn
            // i - доступна только в теле цикла
            System.out.println(i);

            if (i == 16) {
                System.out.println("Вы можете начинать обучаться вождению");
            }

            if (i == 18) {
                System.out.println("Вы можете получить водительские права");
            }

            if (i == 35) {
                System.out.println("Вы можете балотироваться в президенты");
            }
        }

        /**/

        // бесконечный цикл
        /*
        for (;;) {
            System.out.println("Введите первое число: ");
            int val1 = new Scanner(System.in).nextInt();

            System.out.println("Введите второе число (для выхода введите: 666): ");
            int val2 = new Scanner(System.in).nextInt();

            int res = val1 * val2;
            System.out.println("Производное число равно: " + res);

            if (val1 == 666) {
                break;
            }
        }
        */

        /**/

        /**
         * TODO: Задача 3.2.1
         * Написать цикл, который будет выводить числа от 0 до 10
         */
        System.out.println("\n[ 3.2.1 ]:");
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        /**/

        /**
         * TODO: Задача 3.2.2
         * Написать цикл, который будет выводить числа от 5 до 15
         */
        System.out.println("\n[ 3.2.2 ]:");
        for (int i = 5; i <= 15; i++) {
            System.out.println(i);
        }

        /**/

        /**
         * TODO: Задача 3.2.3
         * Написать цикл, который будет выводить числа от 10 до 0
         */
        System.out.println("\n[ 3.2.3 ]:");
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
        }

        /**/

        /**
         * TODO: Задача 3.2.4
         * Написать цикл, который будет выводить числа от 17 до 9
         */
        System.out.println("\n[ 3.2.4 ]:");
        for (int i = 17; i >= 9; i--) {
            System.out.println(i);
        }

        /**/

        /**
         * TODO: Задача 3.2.5
         * Написать цикл, который будет выводить только чётные числа
         * от 0 до 10 (0, 2, 4, 6, 8 и 10)
         */
        System.out.println("\n[ 3.2.5 ]:");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
