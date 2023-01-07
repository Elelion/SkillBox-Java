package module_13_features_of_OOP;

import module_13_features_of_OOP._13_10_lecture_generics.Generics;
import module_13_features_of_OOP._13_11_lecture_maven.Maven;
import module_13_features_of_OOP._13_13_lecture_annotations_and_lombok.Lombok;
import module_13_features_of_OOP._13_5_lecture_stream_DONT_WORK.Stream;
import module_13_features_of_OOP._13_6_lecture_sorted_MIN_MAX.Sorted;
import module_13_features_of_OOP._13_7_practical_stream.Employee;
import module_13_features_of_OOP._13_7_practical_stream.EmployeeUtils;
import module_13_features_of_OOP._13_7_practical_stream.Path;
import module_13_features_of_OOP._13_8_lecture_map_reduce.Map;
import module_13_features_of_OOP._13_9_lecture_static_default.Static;

import java.util.Comparator;
import java.util.List;

public class _13_main {
    public static void main(String[] args) {
        System.out.println("Лекция 13.1");
//        LambdaExpressions lecture1 = new LambdaExpressions();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.2");
//        CheckYourself lecture2 = new CheckYourself();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.3");
//        ForEach lecture3 = new ForEach();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.4");
//        Stream lecture4 = new Stream();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.6");
//        Sorted lecture6 = new Sorted();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.7");

//        Path path = new Path();
//        final String STAFF_TXT = path.getPath() + "data/staff.txt";

//        List<Employee> staff = EmployeeUtils.loadStaffFromFile(STAFF_TXT);
//        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);

//        staff.stream().sorted(Comparator
//            .comparing(Employee::getWorkStart))
//            .forEach(System.out::println);

//        System.out.println("-");
//        System.out.println(employeeMaxSalary);

        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.8");
//        Map lecture8 = new Map();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.9");
//        Static lecture9 = new Static();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.10");
//        Generics lecture10 = new Generics();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.11");
//        Maven lecture11 = new Maven();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 13.13");
        Lombok lecture11 = new Lombok();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

    }

    // для задания 13.7
    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        //TODO Метод должен вернуть сотрудника с максимальной зарплатой среди тех,
        // кто пришёл в году, указанном в переменной year

        return staff.stream()
            .filter((e) -> e.getWorkStart().getYear() == year)
            .max((e1, e2) ->
                e1.getSalary().compareTo(e2.getSalary()))
            .get();
    }
}
