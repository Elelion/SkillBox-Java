package module_10_arrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _10_9_practical_EmailList {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";

    private final String regexMailCheck = "[A-Za-z0-9+]+(@{1})+([A-Za-z0-9+])+(\\.{1})+([A-Za-z]{2,})";
    private static final String LIST = "LIST";
    private static final String ADD = "ADD";

    private TreeSet<String> list = new TreeSet<>();
    private String[] elementsText;

    public _10_9_practical_EmailList() {
        /**
         * TODO: Задание 10.9
         * - Задание выполняйте в классе src/main/java/practice/EmailList.java.
         * - Напишите программу, в которой будет храниться перечень адресов
         * электронной почты. Адреса можно добавлять через консоль командой
         * ADD и печатать весь список командой LIST.
         * - Программа должна проверять корректность вводимых email и печатать
         * сообщение об ошибке при необходимости.
         * - Для работы с данными списка дел в проекте находится класс
         * EmailList, который должен отвечать за хранение и работу с
         * электронными адресами. Реализуйте все методы и проверьте класс с
         * помощью существующих тестов. Вы можете добавлять дополнительные
         * методы в класс.
         *
         * Принцип работы команд:
         * • LIST — выводит список электронных адресов.
         * • ADD — проверяет и, если формат адреса верный, добавляет в множество.
         *
         * Примеры команд:
         * • LIST
         * • ADD hello@skillbox.ru
         * • Команды вводятся одной строкой пользователем в консоль.
         * • Примеры работы со списком электронных адресов (жирным шрифтом
         * выделен ввод пользователя)
         * • ADD mail@mail.ru
         * • ADD hello@skillbox.ru
         * • ADD hello@skillbox
         * • ADD hello@skillbox.ru
         * • LIST
         * • hello@skillbox.ru
         * • mail@mail.ru
         */

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }

            elementsText = input.split(" ");
            String command = elementsText[0];

            /**
             * - сздаем строку, которая будет содержать введенный текст без мусора
             * - склеиваем обратно нашу строку, НО уже без команды и индекса
             */
            StringBuilder textWithoutCommand = new StringBuilder();
            for (int i = 1; i <= elementsText.length - 1; i++) {
                textWithoutCommand.append(elementsText[i]).append(' ');
            }

            //TODO: write code here
            switch (command) {
                case ADD:
                    Pattern pattern = Pattern.compile(regexMailCheck);
                    Matcher matcher = pattern.matcher(textWithoutCommand.toString());

                    if (matcher.find()) {
                        add(textWithoutCommand.toString().toLowerCase(Locale.ROOT));
                    } else {
                        System.out.println(WRONG_EMAIL_ANSWER);
                    }
                    break;

                case LIST:
                    for (String listStr: list) {
                        System.out.println(listStr);
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        list.add(email.trim());
    }

//    public List<String> getSortedEmails() {
    public TreeSet<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return list;
    }

}
