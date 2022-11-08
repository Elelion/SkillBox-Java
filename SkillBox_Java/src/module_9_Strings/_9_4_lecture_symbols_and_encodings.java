package module_9_Strings;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class _9_4_lecture_symbols_and_encodings {
    public _9_4_lecture_symbols_and_encodings() {
        String line = "8678976784";

        // вывести нужный символ, нумерация с 0
        char symbol = line.charAt(2);
        System.out.println(symbol);

        // проверить является ли переданный параметр цифрой
        System.out.println(Character.isDigit(symbol));
        System.out.println("-");

        /**/

        // работа с символами строки
        String text = "There is no cow level";
        int spaceCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char symbols = text.charAt(i);

            if (symbols == ' ') {
                spaceCount++;
            }
        }

        System.out.println("Кол-во пробелов: " + spaceCount);
        System.out.println("-");

        /**/

        // удаление пробельных символов
        String name = "\t\r\nАндриана    ";
        System.out.println(name);
        System.out.println(name.trim());
        System.out.println("-");

        /**/

        // кодировка
        String charset = Charset.defaultCharset().displayName();
        System.out.println(charset);

        String test = "something about coding...";
        String encodedText = new String(test.getBytes(), StandardCharsets.UTF_16);
        System.out.println(encodedText);
    }
}
