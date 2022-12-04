package module_2;

import java.util.Scanner;

public class WhileCycle_2_5 {
    public static void main(String[] args) {

        // do... while. Начала выполняет код, а потом проверяет условие
        // почти не используется

        // Пример: бесконечный цикл
        /*
        do {
            System.out.println("do");
        } while (true);
        */

        /**/

        // while

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

        /**
         * TODO: Задача 2.5
         * Написать код который будет писать в консоль номера билетов от
         * 200к до 210к и от 220к до 235к с использованием цикла for и while
         */

        // Вариант №1
        for (int i = 0; i < 500000; i++) {
            if (i >= 200000 && i <= 210000) {
                System.out.println("For - Counter i: " + i);
            } else if (i >= 220000 && i <= 235000) {
                System.out.println("For - Counter i: " + i);
            }
        }

        // Вариант №2
        int i = 0;
        while (i <= 500000) {
            if (i >= 200000 && i <= 210000) {
                System.out.println("while - Counter i: " + i);
            } else if (i >= 220000 && i <= 235000) {
                System.out.println("while - Counter i: " + i);
            }

            i++;
        }
    }
}
