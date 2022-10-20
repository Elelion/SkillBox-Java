package module_7;

public class _7_practical_main {
    public static void main(String[] args) {
        // Задание №1
        _7_9_1_practical_Container container = new _7_9_1_practical_Container();
        container.addCount(5672);
        System.out.println(container.getCount());
        System.out.println("\n---\n");

        /* ----------------------------------------------------------------- */

        // Задание №2
        /**
         * TODO: Задание 7.9 - 2
         * Напишите в этом же проекте код, который с помощью цикла и преобразования
         * чисел в символы найдёт все числовые коды букв русского
         * алфавита — заглавных и строчных, в том числе буквы Ё.
         */

        // Вариант №1
        // правда без Ё и ё тк Ё начинается до алфавита А-я, а ё идет после...
        for (char ch = 'А'; ch <= 'я'; ch++) {
             // System.out.println(ch + " (" + ((int) ch) + ")");
        }

        // Вариант №2
        // но этот вариант показался костыльным
        for (char ch :"АаБбВвГгДдЕеЁёЖжЗзИиЙйКкЛлМмНнОоПпРрСсТтУуФфХхЦцЧчШшЩщЪъЫыЬьЭэЮюЯя".toCharArray()){
            // System.out.println(ch + " (" + ((int) ch) + ")");
        }

        // Вариант №3
        // встретил проблему как и в варианте №1....
        /*
        for (int i = 0; i < 65536; i++) {
            char ch = (char) i;

            if (ch == 'Ё' || ch == 'ё') {
                 System.out.println(i + " - " + ch);
            } else if (ch >= 'А' && ch <= 'я') {
                 System.out.println(i + " - " + ch);
            }
        }
        */

        // Вариант №4
        for (char ch = 'Ё'; ch <= 'ё'; ch++) {
            char ch1 = 1025, ch2 = 1105;

            if (ch >= 'А' && ch <= 'я') {
                System.out.println(ch + " (" + ((int) ch) + ")");

                if (ch == 'Е') {
                    System.out.println(ch1 + " (" + ((int) ch1) + ")");
                }

                if (ch == 'е') {
                    System.out.println(ch2 + " (" + ((int) ch2) + ")");
                }
            }
        }
    }
}
