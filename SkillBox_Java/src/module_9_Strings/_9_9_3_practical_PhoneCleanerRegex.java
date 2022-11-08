package module_9_Strings;

import java.util.Scanner;

public class _9_9_3_practical_PhoneCleanerRegex {
    public _9_9_3_practical_PhoneCleanerRegex() {
        /**
         * TODO: Задание 9.9 - 3
         * Цель
         * • Научиться писать и использовать несложные регулярные выражения.
         *
         * Что нужно сделать
         * - Выполните задание в отдельном репозитории “java_Strings” в классе
         * main/java/practice/regex/PhoneCleanerRegex.java.
         * - Реализуйте удаление лишних символов при вводе номера телефона в
         * консоли и проверку соответствия номера формату мобильных номеров в
         * России. Если введённую строку нельзя привести к формату мобильного
         * номера, выводите сообщение о неверном вводе. Телефон может быть введён
         * не только в формате 79091234567, но и с лишними символами.
         * - Запустите в проекте тесты и убедитесь в том, что они выполняются
         * успешно. Если тесты не выполняются и выдают информацию об ошибках,
         * постарайтесь самостоятельно исправить эти ошибки и добиться успешного
         * выполнения тестов перед отправкой результатов преподавателю.
         */

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер:");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            String regex = "[ˆ\\D]"; // [ˆ0-9]
            String phoneNumber = input.replaceAll(regex, "");
            String withoutCode = "[ˆ7,8]";

            if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
                System.out.println("Неверный формат номера");
                break;
            } else {
                if (phoneNumber.charAt(0) == '8' || phoneNumber.length() != 10) {
                    phoneNumber = phoneNumber.replaceFirst("[0-9]", "7");
                    System.out.println(phoneNumber);
                    break;
                }

                if (phoneNumber.length() == 11 && (phoneNumber.charAt(0) != '8' || phoneNumber.charAt(0) != 7)) {
                    System.out.println("Неверный формат номера");
                    break;
                }

                if (phoneNumber.length() == 10) {
                    System.out.println("7" + phoneNumber);
                } else {
                    System.out.println(phoneNumber);
                }

                break;
            }



        }
    }
}
