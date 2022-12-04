package module_9_strings;

public class _9_5_task_2_StringExperiments {
    public _9_5_task_2_StringExperiments() {
        /**
         * TODO: Задание 9.5 - 1 (лекционное)
         * Задание 2. Напишите приложение, извлекающее из строки заработные
         * платы людей и суммирующее их
         */

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int numberStart = -1;
        int index = 0;
        int sum = 0;

        while (index >= 0) {
            // пробегаем по всей строке и ищем пробелы
            index = text.indexOf(' ',  index + 1);
            System.out.println(index);

            // проверяем является ли первый символ числом или нет
            if (Character.isDigit(text.charAt(index + 1))) {
                numberStart = index + 1;
                System.out.println("numberStart: " + numberStart);
            }

            // проверяем является ли последний символ числом или нет
            if (numberStart > 0 && Character.isDigit(text.charAt(index - 1))) {
                System.out.println("index: " + index + " | " + Character.isDigit(text.charAt(index - 1)));

                sum += Integer.parseInt(text.substring(numberStart, index));
                numberStart = -1;
            }

        }

        System.out.println(sum);
    }
}
