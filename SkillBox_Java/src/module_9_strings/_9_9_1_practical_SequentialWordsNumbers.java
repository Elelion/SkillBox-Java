package module_9_strings;

import java.util.Arrays;
import java.util.Scanner;

public class _9_9_1_practical_SequentialWordsNumbers {
    public _9_9_1_practical_SequentialWordsNumbers() {
        /**
         * TODO: Задание 9.9 - 1
         * - Нужно написать метод sequentialWordsNumbers, который в качестве
         * аргумента принимает текст и перед каждым словом пишет его порядковый
         * номер в круглых скобках и возвращает строку. Метод необходимо написать
         * без использования регулярных выражений. Пример того, как оно должно
         * работать:
         *
         * Введите текст:
         * Это просто текст, для примера работы программы
         * Результат:
         * (1) Это (2) просто (3) текст, (4) для (5) примера (6) работы (7) программы
         *
         * - Запустите в проекте тесты и убедитесь в том, что они выполняются
         * успешно. Если тесты не выполняются и выдают информацию об ошибках,
         * постарайтесь самостоятельно исправить эти ошибки и добиться успешного
         * выполнения тестов перед отправкой результатов преподавателю.
         *
         * Советы и рекомендации:
         * • Используйте поиск пробелов в тексте методом indexOf в цикле.
         * • Сохраняйте новую строку в объект класса StringBuilder, а затем
         * верните объект класса String
         *
         * Критерии оценки работы:
         * • Программа работает так, как показано на примере.
         * • В программе не используются регулярные выражения.
         * • Автотесты выполняются без ошибок.
         */

        System.out.println("Введите текст:");

        Scanner in = new Scanner(System.in);
        String userText = in.nextLine();
        System.out.println(userText);
        System.out.println(sequentialWordsNumbers(userText));;
    }

    public static String sequentialWordsNumbers(String text) {
        int[] spacesListIndexDirty = getAllIndexesFromText(text);
        int[] spacesListIndex = removeDuplicates(spacesListIndexDirty);

        int currSpace = 0;
        int count = 0;
        int previous = 0;

        StringBuilder compileText = new StringBuilder();

        /**/

        while (count < spacesListIndex.length) {
            currSpace = spacesListIndex[count];
            count++;

            // first word
            String separator = "";
            if (count >= 2) {
                previous = spacesListIndex[count - 2];
                separator = " (" + count + ")";
            }

            // middle words
            if (count == 1) {
                previous = 0;
                separator = "(" + count + ") ";
            }

            // only one word
            if (currSpace == -1) {
                compileText.append(separator).append(text.substring(0));
            } else {
                compileText.append(separator).append(text.substring(previous, currSpace));

                // last word
                if (count == spacesListIndex.length) {
                    compileText.append(" (").append(count + 1).append(")").append(text.substring(currSpace));
                }
            }
        }

        return compileText.toString();
    }

    private static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    private static int[] getAllIndexesFromText(String text) {
        int[] spacesListIndexDirty = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            int indexSpace = text.indexOf(' ', i);
            spacesListIndexDirty[i] = text.indexOf(' ', indexSpace);
        }

        return spacesListIndexDirty;
    }
}
