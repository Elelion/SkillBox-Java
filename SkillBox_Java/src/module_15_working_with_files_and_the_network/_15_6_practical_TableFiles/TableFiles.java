package module_15_working_with_files_and_the_network._15_6_practical_TableFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * - Напишите код парсинга банковской выписки (файл movementList.csv). Код
 * должен выводить сводную информацию по этой выписке: общий приход, общий
 * расход, а также разбивку расходов по типам.
 *
 * - Создайте новый проект MovementsParser, создайте также в нём класс Main с
 * методом main.
 *
 * - Откройте файл movementList.csv в любом текстовом редакторе и ознакомьтесь
 * с его структурой. Обратите внимание, что файл состоит из первой строки с
 * именами столбцов, разделённых запятыми:
 * • Тип счёта,Номер счета,Валюта,Дата операции,Референс проводки,Описание
 * операции,Приход,Расход
 *
 * … А также строк следующего вида:
 * • Текущий счёт,40817813206170024534,RUR,05.05.17,CRD_8K25F0,548673++++++1028
 * 11436154\RUS\MOSCOW\16 LVA\YANDEX TAXI            05.05.17 02.05.17
 * 89.00  RUR MCC4121,0,89
 *
 * - Значения в каждой такой строке разделены по столбцам запятой. В столбце
 * “Описание операции” содержится тип расхода, по которому нужно в итоге разбить
 * общую сумму. В примере выше расход можно отнести к типу “YANDEX TAXI”.
 *
 * - Пропишите в методе main код, который будет читать данный файл построчно:
 * String path = "/Users/name/Desktop/movementList.csv";
 * List<String> lines = new ArrayList<>();
 * try {
 *    lines = Files.readAllLines(Paths.get(path));
 * } catch (IOException e) {
 *    e.printStackTrace();
 * }
 *
 * for(String line : lines) {
 *    //parse line
 * }
 *
 * - Напишите в цикле “for” код таким образом, чтобы первая строка не читалась,
 * поскольку она не содержит необходимых данных, а состоит из имён столбцов.
 *
 * - Напишите код, который разобьёт строку на компоненты по запятой и вычленит
 * из этих компонентов тип платежа и сумму расхода. Строки, в которых отражены
 * пополнения счёта, необходимо пропустить. Получить тип платежа из фрагмента
 * строки с описанием операции можно при помощи регулярного выражения:
 * String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\s]+)[0-9]{2}\\.[0-9]{2}\\
 * .[0-9]{2}\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
 *
 * - Создайте HashMap, в котором будут в качестве ключей храниться типы расходов,
 * а в качестве значений — общие суммы по каждому из этих типов.
 *
 * - Запустите и проверьте, как работает программа. В результате она должна
 * вывести следующий список:
 * SUBWAY	510.0
 * RAIKHONA	1645.0
 * FSPRG UK	953.44
 * YANDEX EDA	823.0
 * ZOOMAGAZIN 4	2176.5
 * DIXY	281.38
 * GOOGLE GOOGLE	139.0
 * VPS NET	4409.29
 * Alfa Iss	353000.0
 * RYABINOVAYA 5	630.0
 * KFC ASHAN MAR	375.0
 * LOVE REPUBLIC	10815.3
 * ZOTMAN	3000.0
 * delivery club	1370.0
 * KUSCHAVEL	4745.0
 * L ETOILE	1263.4
 * AWS EMEA	588.63
 * YANDEX TAXI	11873.0
 * WWW HETZNER D	16795.13
 * MOSCOW	51000.0
 */
public class TableFiles {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_6_practical_TableFiles";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "movementList.csv";

    private List<String> lines = new ArrayList<>();
    private static HashMap<String, Double> expence2sum = new HashMap<>();

    public TableFiles() {
        String path = DATA_FILE;


        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // удаляем нулевую строку тк она не содержит нужных нам данных
        lines.remove(0);

        // заполняем expence2sum
        fillLines(lines);

        // выводим данные из expence2sum
        for (String paymentType : expence2sum.keySet()) {
            double sum = expence2sum.get(paymentType);

            System.out.println(paymentType + "\t" + sum);
        }
    }

    private static void fillLines(List<String> lines) {
        for (String line : lines) {
            /**
             * загоняем куждую строку, в tokens в виде массива
             * далее работаем с элементом массива...[7] и [5]
             * [7] - это цена
             * [5] - это тип услуги
             */
            String[] tokens = line.split(",");
            double expense = Double.parseDouble(tokens[7]);

            // пропускаем нулевые значения
            if (expense == 0) {
                continue;
            }

            String paymentType = getPaymentType(tokens[5]);

            /**
             * добавляем в наш ассоциативный массив значения...
             * с начала кладем название услуги, затем суммируем цены
             *
             * если текущего ключа нет в массиве, то добавляем его с нулевой ценой
             */
            if (!expence2sum.containsKey(paymentType)) {
                expence2sum.put(paymentType, 0.);
            }

            expence2sum.put(
                paymentType,
                expence2sum.get(paymentType) + expense
            );
        }
    }

    private static String getPaymentType(String info) {
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\s]+)[0-9]{2}\\" +
            ".[0-9]{2}\\.[0-9]{2}\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(info);

        return matcher.find() ? matcher.group(1).trim() : null;
    }

}
