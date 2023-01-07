package module_13_features_of_OOP._13_11_lecture_maven;

import module_13_features_of_OOP._13_10_lecture_generics.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Maven {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "data/staff.json";

    public Maven() {
        /**
         * Подргужает зависимости для проекта которые ему нужны
         *
         * в корне проекта создаем папку lib и ложим туда json-simple-1.1.1.jar
         *
         * далее подключаем нашу библиотеку
         * File -> Project Structure -> Libraries -> + -> Java -> выбрать
         * нашу библиотеку, и указать наш проект
         *
         * после чего мы сможем вызывать классы которые в ней есть
         */

//        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        /**
         * Получаем данные из наего JSON'a
         * data - в него загружаем наш файл
         * parser - это программный скрипт, выполняющий парсинг данных
         * array - JSON массив, который будет содержать распарсенные данные с файла
         * JSONObject — хранит неупорядоченные пары типа ключ — значение.
         * Значение могут быть типа String, JSONArray, JSONObject. NULL,
         * Boolean и Number .
         */
        try {
            String data = getDataFromFile(STAFF_TXT);
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(data);

            for (Object item : array) {
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
