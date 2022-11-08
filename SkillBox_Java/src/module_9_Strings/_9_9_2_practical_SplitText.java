package module_9_Strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _9_9_2_practical_SplitText {
    public _9_9_2_practical_SplitText() {
        /**
         * TODO: Задание 9.9 - 2
         * Цель
         * • Научиться писать и использовать несложные регулярные выражения.
         *
         * Что нужно сделать
         * - Реализуйте метод, который принимает в качестве аргумента строку,
         * содержащую английский текст (не менее 100 слов). Метод должен
         * разделить текст на слова и вернуть строку, состоящую из полученных
         * слов, где каждое слово будет на отдельной строке. Знаки препинания
         * и числа не являются словами.
         * - Запустите в проекте тесты и убедитесь в том, что они выполняются
         * успешно. Если тесты не выполняются и выдают информацию об ошибках,
         * постарайтесь самостоятельно исправить эти ошибки и добиться
         * успешного выполнения тестов перед отправкой результатов
         * преподавателю.
         */

        String text = "Everyone could notice that people often complain and say that it was better before. It may be a little nostalgia;\n" +
            "the old people would like to return in the 50, forty years old people prefer the 70.\n" +
            "It can be explained of the life period when they were younger. As its known people like their youth time.\n" +
            "In general living is better now. We live when there arent as many wars in the world as before. And\n" +
            "people live longer; the level of lifespan is higher than it was 40 years ago. People work less and they\n" +
            "can afford to go to the vacation and buy more things.\n" +
            "So, it is true that there is more pollution now than in the last century but there is more conveniences.\n" +
            "Everyone has a shower, a TV, a fridge, a computer, etc. And now there are more means of communication\n" +
            "than before. Earlier it was dangerous to travel and it was almost impossible to go around the world.\n" +
            "Someone say that people were kinder before. But now people are more educated and now everyone has an\n" +
            "opportunity to go to school and to get education. Its better to think of advantages to live in the\n" +
            "modern world than to regret something that no longer exists.\n";

        //String[] textSplit = splitTextIntoWords(text);
        //for (int i = 0; i < text.length(); i++) {
        //    System.out.println(textSplit[i]);
        //}

        System.out.println(splitTextIntoWords(text));
    }

    private String[] _splitTextIntoWords(String text) {
        String[] words = text.split("\\s+");
        return words;
    }

    private String splitTextIntoWords(String text) {
        String regex = "[a-zA-Z{1-9}]+[ˆ,.()\\S]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start, end));
        }

        return "";
    }
}
