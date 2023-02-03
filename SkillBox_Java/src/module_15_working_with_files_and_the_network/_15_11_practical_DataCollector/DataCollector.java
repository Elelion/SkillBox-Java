package module_15_working_with_files_and_the_network._15_11_practical_DataCollector;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataCollector {

    /**
     * Задание 1. Программа, собирающая данные из разных источников
     *
     * Что нужно сделать
     * Выполните задание в отдельном проекте, создайте для проекта директорию
     * FilesAndNetwork/DataCollector.
     *
     * Напишите программу, которая будет собирать данные из разных источников и
     * записывать два JSON-файла. Парсинг разных данных должен происходить в
     * разных классах. Имена классов и их методов придумайте самостоятельно.
     * По мере реализации проверяйте работу каждого созданного класса.
     * В программе должны быть следующие классы:
     *
     * (1) - Класс парсинга веб-страницы. В нём должно происходить (реализуйте
     * каждую операцию в отдельных методах):
     *      • получение HTML-кода страницы «Список станций Московского
     *      метрополитена» с помощью библиотеки jsoup;
     *      • парсинг полученной страницы и получение из неё следующих данных
     *      (создайте для каждого типа данных отдельные классы):
     *          ◻ линии московского метро (имя и номер линии, цвет не нужен);
     *          ◻ станции московского метро (имя станции и номер линии).
 *              Проверьте работу данного класса: напишите код, который будет
     *              его использовать и выводить полученные данные.
     *              Для удобства рекомендуем у каждого класса, предназначенного
     *              для хранения того или иного объекта, реализовать метод
     *              toString, который будет возвращать строку с данными
     *              объекта в понятном виде.
     *
     * (2) - Класс поиска файлов в папках. В методах этого класса необходимо
     * реализовать обход папок, лежащих в архиве. Разархивируйте его и напишите
     * код, который будет обходить все вложенные папки и искать в них файлы
     * форматов JSON и CSV (с расширениями *.json и *.csv). Метод для обхода
     * папок должен принимать путь до папки, в которой надо производить поиск.
     * Проверьте работу данного класса: передайте ему на вход путь к папке и
     * убедитесь, что он вывел информацию о трёх найденных JSON-файлах и о трёх
     * CSV-файлах.
     *
     * (3) - Класс парсинга файлов формата JSON. Изучите структуру JSON-файлов,
     * лежащих в папках, и создайте класс(ы) для хранения данных из этих файлов.
     * Напишите код, который будет принимать JSON-данные и выдавать список
     * соответствующих им объектов.
     * Проверьте работу данного класса: передайте ему на вход данные любого из
     * JSON-файлов, найденных на предыдущем шаге, и убедитесь, что он выводит
     * данные корректно.
     *
     * (4) - Класс парсинга файлов формата CSV. Изучите структуру CSV-файлов,
     * лежащих в папках, и создайте класс(ы) для хранения данных из этих файлов.
     * Напишите код, который будет принимать CSV-данные и выдавать список
     * соответствующих им объектов.
     * Проверьте работу данного класса: передайте ему на вход данные любого
     * из CSV-файлов, найденных двумя шагами ранее, и убедитесь, что он выводит
     * данные корректно.
     *
     * (5) - Класс, в который можно добавлять данные, полученные на предыдущих
     * шагах, и который создаёт и записывает на диск два JSON-файла:
     *      • со списком станций по линиям и списком линий по формату
     *      JSON-файла из проекта SPBMetro (файл map.json);
     *      • файл stations.json со свойствами станций в следующем формате:
     * {
     *     "stations": [
     *           {
     *                 "name": "Название станции",
     *                 "line": "Название линии",
     *                 "date": "Дата открытия в формате 19.01.2005",
     *                 "depth": "Глубина станции в виде числа",
     *                 "hasConnection": "Есть ли на станции переход"
     *           },
     *           …
     *     ]
     * }
     *
     * Пример:
     *
     * {
     *      "stations": [
     *            {
     *                  "name": "Ленинский проспект",
     *                  "line": "Калужско-Рижская",
     *                  "date": "13.10.1962",
     *                  "depth": -16,
     *                  "hasConnection": true
     *            },
     *            …
     *      ]
     * }
     *
     * (6) Если каких-то свойств для станции нет, то в файле не должно быть
     * соответствующих ключей.
     * - Проверьте созданный класс: запустите получившуюся программу и
     * убедитесь, что она создаёт и записывает два JSON-файла по описанным
     * выше форматам.
     */

    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_11_practical_DataCollector" + File.separator + "data";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    /**/

    public DataCollector() throws IOException {
        System.out.println("DataCollector");

        // TODO: см. пункт в задании - (1)
        consoleColorLog("см. пункт в задании - (1)");

        /**/

        ParsingSubwayFromWeb parsingSubwayFromWebTask1 = new ParsingSubwayFromWeb();

        System.out.println(parsingSubwayFromWebTask1.getLines());
        System.out.println(parsingSubwayFromWebTask1.getStations());
        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());

        /* ----------------------------------------------------------------- */

        // TODO: см. пункт в задании - (2)
        consoleColorLog("см. пункт в задании - (2)");

        /**/

        SearchFiles search = new SearchFiles();
        ArrayList<File> fileList = new ArrayList<>();

        /**
         * передаем папку в которой искать, и массив где будут найденные файлы
         *
         * Важно!!!
         * Если мы передаем массив, и в другом классе метода что то с ним делаем
         * то, он изменяется и там, от куда мы его передаем!!!
         */
        search.searchFiles(new File(DATA_FILE), fileList);

        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());

        /* ----------------------------------------------------------------- */

        // TODO: см. пункт в задании - (3/4)
        consoleColorLog("см. пункт в задании - (3/4)");

        /**/

        // применяем данные из задания №2 (см выще по TODO: см. пункт в задании - (2))

        for (File file : fileList) {
//            ParsingJSON parsingJSON = new ParsingJSON();
//            parsingJSON.setFile(file);
//            parsingJSON.parsingJsonToLinkedHashMap();
//            parsingJSON.printParsedJson();

//            new ParsingCSV(file);
        }

        /* ----------------------------------------------------------------- */

        // TODO: см. пункт в задании - (5)
        consoleColorLog("см. пункт в задании - (5)");

        /**/

        ParsingSubwayFromWeb parsingSubwayFromWeb = new ParsingSubwayFromWeb();
        ParsingJSON parsingJSON = new ParsingJSON();

        // заносим только ОДИН json файл в наш парсер
        int countJsonFiles = 0;
        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).getName().toLowerCase().endsWith(".json")) {
                if (countJsonFiles == 1) {
                    parsingJSON.setFile(fileList.get(i));
                    parsingJSON.parsingJsonToLinkedHashMap();
                }

                countJsonFiles++;
            }
        }

        new WriteJSON(
            parsingSubwayFromWeb.getLines(),
            parsingSubwayFromWeb.getStations(),
            parsingJSON.getJsonArrayHash());
    }

    private void consoleColorLog(String str) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
}
