package module_13_features_of_OOP._13_13_lecture_annotations_and_lombok;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Lombok {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "data/staff.json";

    public Lombok() {
        /**
         * Аннотации - специальные комментарии которые позволяют помечать
         * фрагменты нашего кода и несут функциональную нагрузку
         *
         * Например:
         * @Deprecated - устарел
         * @Override - пере определение метода
         */
        /**
         * для упрощения аннотаций есть плагин - lombok
         * скачиваем его и устанавливаем
         */
//        Employee employee = null;

        // будет зачеркнутым те значит - устарел
//        employee.toString();

        /**/

        System.out.println("-");
        Employee employee =
            new Employee("Василий Петров", 74000, LocalDate.now());

        System.out.println(employee);
    }

    private static String getDataFromFile(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                builder.append(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}
