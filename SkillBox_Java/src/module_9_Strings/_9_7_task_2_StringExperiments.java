package module_9_Strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _9_7_task_2_StringExperiments {
    public _9_7_task_2_StringExperiments() {
        /**
         * TODO: Задание 9.7 - 2 (лекционное)
         * Задание 2.
         * Напишите консольное приложение, извлекающее из текста числа при
         * помощи регулярного выражения и суммирующее их
         */

        Scanner in = new Scanner(System.in);
        System.out.println("числа: ");
        String text = in.nextLine();
        int sum = 0;

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String number = matcher.group();
            sum += Integer.parseInt(number);
        }

        System.out.println("Сумма чисел в тексте: " + sum);
        System.out.println();
    }
}
