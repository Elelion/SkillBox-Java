package module_9_strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _9_7_lecture_regular_expressions {
    public _9_7_lecture_regular_expressions() {
        String number = "A677MP197";

        /**
         * RegularExpression = regex
         * Перечисляем буквы которые есть в латинском алфавите
         *
         * [AB...X] - обозначает заданный набор символов
         *
         * [0-9] - 0123456789
         * {3} - значит цифр должно быть 3
         *
         * [ABEKMHOPCTYX]{2} - значит после чисел должны быть только 2 буквы
         * из заданного диапазона
         *
         * [0-9]{2,3} - значит после букв должны быть только цифры в заданном
         * диапазоне, либо 2 либо 3 цифры не больше не меньше
         */

        // но такая запись слишком громоздкая, оптимизируем ее
        // String regex = "[ABEKMHOPCTYX][0-9]{3}[ABEKMHOPCTYX]{2}[0-9]{2,3}";

        String lettersList = "[ABEKMHOPCTYX]";
        String regex = lettersList + "[0-9]{3}" + lettersList + "{2}[0-9]{2,3}";

        /**
         * matches - проверяет соответствие строки переданным в этот метод
         * нашей регулярки
         * Вернет - true / false
         */
        System.out.println(number.matches(regex));
        System.out.println("-");


        /**/


        // поиск нужной фразы в строке
        String text = "Алексей, добрый день!\nМой гитхаб - https://github.com/, " +
            "а так же ссылка на мой персональный сайт - https://www.skillbox.ru/\nЕсли " +
            "возникнут вопросы, пишите мне на прямую. Я всегда доступен";
        System.out.println(text);

        /**
         * что бы использовать правильный слеш на прямую, его надо экранировать
         * обратным слешем, но обратный слеш слеш является спец символом строк,
         * то его надо заэконировать обратным слешем то же, те получиться:
         * \\/ и \\/ - это будет два нормальных слеша для ссылки
         *
         * [,\S] - непробельный символ, далее может следовать любой из символов
         * НО тк \ является спец символом в Java, его надо экранировать \\S
         *
         * ^ - крышечка, это отрицание указанных символов
         *
         * + - один или более раз
         */
        // String regex2 = "https:\\/\\/[ˆ,\\S]+";
        String regex2 = "https:\\/\\/[\\S]+";

        /**
         * Работа с регулярными выражениями в любой Java-программе начинается
         * с создания объекта класса Pattern. Для этого необходимо вызвать один
         * из двух имеющихся в классе статических методов compile. Первый
         * метод принимает один аргумент – строковый литерал регулярного
         * выражения, а второй – плюс еще параметр, включающий режим сравнения
         * шаблона с текстом
         *
         * По сути, класс Pattern — это конструктор регулярных выражений.
         * Под «капотом» метод compile вызывает закрытый конструктор класса
         * Pattern для создания скомпилированного представления. Такой способ
         * создания экземпляра шаблона реализован с целью создания его в виде
         * неизменяемого объекта. При создании производится синтаксическая
         * проверка регулярного выражения. При наличии ошибок в
         * строке – генерируется исключение PatternSyntaxException.
         */
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start, end));
        }
        System.out.println("-");


        /**/


        // разбиение строки на фрагменты

        /**
         * \\ s - пробельный символ
         * String[] - массив строк, обращаемся к массиву строк по индексу, нач
         * с 0, обращение через скобки
         */
        String text2 = "I know  something   about    it";
        String[] words = text2.split("\\s+");
        System.out.println("index: 2 - " + words[2] + System.lineSeparator());

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        System.out.println("-");


        /**/


        /**
         * замена фрагментов - написать прогу приводящую формат
         * телефонов к единому
         *
         * формат:
         * 79039995555
         */

        String phone1 = "+7 903 710-37-54";
        String phone2 = "7 (903) 968-69-45";
        String phone3 = "7999-666-66-66";
        String phone4 = "7(903)9686945";

        System.out.println(formatPhoneNumber(phone1));
        System.out.println(formatPhoneNumber(phone2));
        System.out.println(formatPhoneNumber(phone3));
        System.out.println(formatPhoneNumber(phone4));
    }

    public String formatPhoneNumber(String phone) {
        // \\D - любой символ кроме цифры
        String regex = "[ˆ\\D]";
        return phone.replaceAll(regex, "");
    }
}
