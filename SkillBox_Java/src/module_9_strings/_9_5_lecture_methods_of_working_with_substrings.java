package module_9_strings;

import java.util.StringJoiner;

public class _9_5_lecture_methods_of_working_with_substrings {
    public _9_5_lecture_methods_of_working_with_substrings() {
        String header1 = "Content-Type: text/html; charset=utf-8;";
        String header2 = "Content-Type: text/html; charset=windows-1251;";
        String header3 = "Content-Type: text/html; charset=ISO-8859-1;";

        String header4 = "Content-Type: text/html;";
        String header5 = "Content-Type: text/html; charset=";
        String header6 = "Content-Type: text/html; charset=;";

        System.out.println(getEncoding(header1));
        System.out.println(getEncoding(header2));
        System.out.println(getEncoding(header3));

        System.out.println(getEncoding(header4));
        System.out.println(getEncoding(header5));
        System.out.println(getEncoding(header6));
        System.out.println("-");

        /**/

        // делаем что бы имена следовали через запятую
        String name1 = "Василий";
        String name2 = "Иван";
        String name3 = "Николай";

        // специальный класс объеденения строк, что бы не писать name1 + ", " + ...
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(name1);
        joiner.add(name2);
        joiner.add(name3);
        System.out.println(joiner);

        // так же можно соединять строки и через обычный String
        String list = String.join(", ", name1, name2, name3);
        System.out.println(list);

        /**/

        // выводим строки в заданном формате
        String name = "Юий";
        int birthYear = 1999;

        /**
         * требуемый формат: {"name": "Юрий", "birthYear: 1999}
         * но чем больше будет переменных тем длиннее будет строка...
         */
        // String res = "{\"name\" : \"" + name + "\", \"birthYear\": \"" + birthYear + "\"}";

        /**
         * по этому пишут так:
         * %s - String
         * %d - number
         * %f - float / double
         * %b - boolean
         * %n - \n
         * %t - Date
         * %% - символ %
         *
         * по сути мы делаем шаблон, который отрабатывается последовательно
         * и последовательно в него подставляются нужные переменные
         * а %S, %d - это как бы тип переменных, для проверки
         */
        String template = "{\"name\" : \"%s\", \"birthYear\": \"%d\"}";
        String res = String.format(template, name, birthYear);
        System.out.println(res);

        // либо можем сразу вывести через sout
        System.out.printf(template, name, birthYear);
        System.out.println(System.lineSeparator());
    }

    public String _getEncoding(String header) {
        String charsetStr = "charset=";

        /**
         * определяет позицию в подстроке, которая передана как параметр
         * находим позицию - это charset, начало значения будет с 25 символа
         *
         * а затем прибавляем ей длинну этой же найденной строки, что бы нужный
         * нам индекс был не начало строки charset, а ее конец, те 33 символ
         */
        int start = header.indexOf(charsetStr) + charsetStr.length();

        /**
         * start - конец строки, ищем ; после того как закончиться строка start
         * тк ; может встречаться не только в конце
         */
        int end = header.indexOf(';', start);

         String encoding = header.substring(start, end);
         return encoding;
    }

    // пишем новый метод, который будет обрабатывать и не правильные строки
    public String getEncoding(String header) {
        String charsetStr = "charset=";
        int start = header.indexOf(charsetStr);
        int end = header.indexOf(';', start);

        // отлавливаем ошибки, те наши -1 от indexOf
        if (start < 0 || end < 0) {
            return "catch: " + header;
        }

        String encoding = header.substring(start + charsetStr.length(), end);
        return encoding;
    }
}
