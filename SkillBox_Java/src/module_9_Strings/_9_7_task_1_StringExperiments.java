package module_9_Strings;

import java.util.Scanner;

public class _9_7_task_1_StringExperiments {
    public _9_7_task_1_StringExperiments() {
        /**
         * TODO: Задание 9.7 - 1 (лекционное)
         * Задание 1.
         * Напишите консольное приложение, разделяющее строку Ф.И.О.
         * на компоненты с использованием регулярного выражения
         */

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО (через пробелы): ");
        String text = in.nextLine();

        String[] components = text.split("\s+");

        if (components.length <= 3) {
            for (int i = 0; i < components.length; i++) {
                System.out.println(components[i]);
            }
        } else {
            System.out.println("Error length");
        }

    }
}
