package module_10_arrays;

import java.text.NumberFormat;
import java.util.*;

public class _10_13_practical_CoolNumbers {

    private static final List<String> numbersList = new ArrayList<>();
    private static final Random random = new Random();

    private static final char[] NUMBERS_US = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] NUMBERS_RU = "АВЕКМНОРСТУХ".toCharArray();

    public _10_13_practical_CoolNumbers() {
        /**
         * TODO: Задание 10.13
         * - Реализуйте метод генерации «красивых» автомобильных номеров
         * generateCoolNumbers() в классе CoolNumbers. Используйте следующие
         * правила генерации номеров:
         * • XYZ — различный набор из списка разрешенных букв, N — цифры,
         * R — регион (от 01 до 199);
         * • XNNNYZR — пример: A111BC197, У777HC66.
         * В госномерах автомобилей в РФ используются следующие
         * буквы: А, В, Е, К, М, Н, О, Р, С, Т, У, Х.
         * В коллекции должно быть не менее 2 млн номеров.
         *
         * - Реализуйте методы поиска класса CoolNumbers по поиску номеров
         * в каждой коллекции:
         * • прямым перебором по ArrayList,
         * • бинарным поиском по сортированному ArrayList,
         * • поиском в HashSet,
         * • поиском в TreeSet.
         *
         * - Измерьте и выведите длительность каждого метода поиска. Формат
         * вывода результатов поиска:
         * • Поиск перебором: номер найден/не найден, поиск занял 34нс
         * • Бинарный поиск: номер найден/не найден, поиск занял 34нс
         * • Поиск в HashSet: номер найден/не найден, поиск занял 34нс
         * • Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
         *
         * Рекомендации
         * • сортировка не входит в учёт времени для бинарного поиска;
         * • для детального сравнения методов поиска используйте время
         * в наносекундах:   System.nanoTime()
         */

        generateCoolNumbers();

        System.out.println("Часть сгенерированых номеров для примера");
        for (int i = 0; i < 10; i++) {
            System.out.println(numbersList.get(i));
        }

        NumberFormat formatNum = NumberFormat.getInstance();
        System.out.println("Из 2млн сгенерировано: " +
            formatNum.format(numbersList.size()) + " красивых номеров");

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер в формае A555AA199");
            String userInput = in.nextLine();

            bruteForceSearchInList(numbersList, userInput);
        }
    }

    /**/

    private static char getRandomSerialFirstLetter(char[] alphabet) {
        return alphabet[random.nextInt(alphabet.length)];
    }

    private static String getRandomSerialLastLetter(char[] alphabet) {
        String letters = "";

        for (int i = 0; i < 2; i++) {
            letters += alphabet[random.nextInt(alphabet.length)];
        }
        return letters;
    }

    private static String getRandomRegistryNumber() {
        String numbers = "";

        for (int i = 0; i < 3; i++) {
            numbers += random.nextInt(0, 10);
        }

        return numbers;
    }

    private static String getRandomRegion() {
        String region = "";

        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                region += random.nextInt(0, 2);
            } else if (i == 1) {
                region += random.nextInt(0, 10);
            } else {
                region += random.nextInt(0, 10);
            }

        }

        return region;
    }

    /**/

    public static List<String> generateCoolNumbers() {
        char[] alphabet = NUMBERS_RU;

        for (int i = 0; i <= 80_000_000; i++) {
            String regNumber = getRandomRegistryNumber();

            if (Integer.parseInt(regNumber) % 100 == 0) {
                numbersList.add(getRandomSerialFirstLetter(alphabet) + regNumber +
                    getRandomSerialLastLetter(alphabet) + getRandomRegion());
            }

            for (int j = 111; j <= 999; j += 111) {
                if (Integer.parseInt(regNumber) % j == 0) {
                    numbersList.add(getRandomSerialFirstLetter(alphabet) + regNumber +
                        getRandomSerialLastLetter(alphabet) + getRandomRegion());
                }
            }
        }

        Collections.sort(numbersList);
        return numbersList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        long startTime = System.currentTimeMillis();
        boolean index = list.contains(number);
        long finishTime = System.currentTimeMillis() - startTime;

        return isPrintSet(index, finishTime, "перебором");
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        long startTime = System.currentTimeMillis();
        int index = Collections.binarySearch(sortedList, number);
        long finishTime = System.currentTimeMillis() - startTime;

        if (index >= 0) {
            System.out.println("Бинарный поиск: номер найден, поиск занял " +
                 finishTime + " мс");

            return true;
        }

        System.out.println("Бинарный поиск: номер НЕ найден, поиск занял " +
            finishTime + " мс");

        return false;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        HashSet<String> hSet = hashSet;

        long startTime = System.currentTimeMillis();
        boolean index = hSet.contains(number);
        long finishTime = System.currentTimeMillis() - startTime;

        return isPrintSet(index, finishTime, "HashSet");
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        TreeSet<String> tSet = treeSet;

        long startTime = System.currentTimeMillis();
        boolean index = tSet.contains(number);
        long finishTime = System.currentTimeMillis() - startTime;

        return isPrintSet(index, finishTime, "TreeSet");
    }

    /**/

    private static boolean isPrintSet(boolean index, long finishTime, String title) {
        if (index) {
            System.out.println("Поиск " + title + ": номер найден, поиск занял " +
                finishTime + " мс");

            return true;
        }

        System.out.println("Поиск " + title + ": номер НЕ найден, поиск занял " +
            finishTime + " мс");

        return false;
    }
}
