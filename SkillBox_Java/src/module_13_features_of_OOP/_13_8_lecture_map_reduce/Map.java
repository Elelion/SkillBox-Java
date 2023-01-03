package module_13_features_of_OOP._13_8_lecture_map_reduce;

import java.text.NumberFormat;
import java.util.List;

public class Map {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    public Map() {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        /**
         * читается примерно так:
         * - преобразуем данные staff в поток
         * - ищем значения >= 100k
         * - складываем каждые найденные значения
         * - выводим
         */
        staff.stream()
            .map(employee -> employee.getSalary())
            .filter(s -> s >= 100_000)
            .reduce((s1, s2) -> s1 + s2)
            .ifPresent(System.out::println);
    }
}