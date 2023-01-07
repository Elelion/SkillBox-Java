package module_13_features_of_OOP._13_6_lecture_sorted_MIN_MAX;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Sorted {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    public Sorted() {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        // сортируем
//        staff.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(
//            System.out::println
//        );

        /**
         * Optional - Задачей этого класса является предоставление решений на
         * уровне типа-обертки для обеспечения удобства обработки возможных
         * null-значений
         */

        // Вариант №1
        /*
        Optional<Employee> optional = staff.stream().max(
            Comparator.comparing(Employee::getSalary));

        Employee employee = optional.get();
        System.out.println(employee);
        */

        // Вариант №2
        staff.stream().max(Comparator
            .comparing(Employee::getSalary))
            .ifPresent(System.out::println);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        // соритурем по ЗП
//        Collections.sort(staff, (o1, o2) ->
//            o1.getSalary().compareTo(o2.getSalary()));

        // сортируем по алфавиту
//        Collections.sort(staff, (o1, o2) ->
//            o1.getName().compareTo(o2.getName()));

        // сорируем и так и сяк через компаратор
//        Collections.sort(staff, Comparator
//            .comparing(Employee::getSalary)
//            .thenComparing(Employee::getName));

        staff.sort((e1, e2) -> {
            int comparison =
                e1.getSalary().compareTo(e2.getSalary());
            if (comparison == 0) {
                return e1.getName().compareTo(e2.getName());
            }
            return comparison;
        });
    }
}