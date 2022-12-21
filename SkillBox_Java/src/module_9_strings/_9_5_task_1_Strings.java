package module_9_strings;

import java.util.Scanner;

public class _9_5_task_1_Strings {
    public _9_5_task_1_Strings() {
        /**
         * TODO: Задание 9.5 - 1 (лекционное)
         * Задание 1. Напишите консольное приложение, разделяющее строку с фамилией,
         * именем и отчеством на компоненты
         */

        Scanner in = new Scanner(System.in);
        System.out.println("Введите ФИО (через пробелы): ");
        String fullName = in.nextLine();

        int firstSpace = fullName.indexOf(' '); // вернет индекс первого пробела
        String surname = fullName.substring(0, firstSpace);

        int secondSpace = fullName.lastIndexOf(' '); // вернет индекс ПОСЛ пробела
        String name = fullName.substring(firstSpace + 1, secondSpace);
        String lastName = fullName.substring(secondSpace + 1);

        System.out.println("Фамилия: " + surname);
        System.out.println("Имя: " + name);
        System.out.println("Отчество: " + lastName);
        System.out.println('-');
        System.out.println("firstSpace: " + firstSpace);
        System.out.println("secondSpace: " + secondSpace);
    }
}
