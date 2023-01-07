package module_13_features_of_OOP._13_1_lecture_lambda_expressions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//import static com.sun.tools.javac.util.Constants.format;

public class LambdaExpressions {
    private static String staffFile = "staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public LambdaExpressions() {
        System.out.println("1 - ");

        ArrayList<Employee> staff = loadStaffFromFile();

        /**
         * Если просто написать Collections.sort(staff) - то будет ошибка,
         * тк с объектами эта хрень НЕ работает
         *
         * ниже представленна конструкция которая БЕЗ лямбда-выражения
         *
         * Компаратор - Интерфейс Java Comparator используется для
         * упорядочивания объектов внутри определенного пользователем класса.
         */

        /*
        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });
        */

        /**
         * выше придевенное сравнение, но с лямбда-выражением
         * те идея в том, что происходит сравнение двух значений
         * те Коллекция как бы пробегается с текущим значением и следующим
         * и возвращает отсортированный результат
         */
        Collections.sort(staff, (o1, o2) ->
            o1.getSalary().compareTo(o2.getSalary()));

        for (Employee employee : staff) {
            System.out.println(employee);
        }


        System.out.println("-");

        /**/

        System.out.println("2 - ");

        // ...
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();

        /*
        try {
            List<String> lines Files.readAllLines(Paths.get(staffFile));

            for (String line : lines) {
                String[] fragments = line.split("\t");

                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }

                staff.add(new Employee(

                ));
            }
        }
        */

        Date workStart = new Date();
        Employee obj1 = new Employee("Дмитриев Василий", 78000, workStart);
        Employee obj2 = new Employee("Анна Сетяева", 140000, workStart);
        Employee obj3 = new Employee("Алексей Ивлиев", 125000, workStart);

        staff.add(obj1);
        staff.add(obj2);
        staff.add(obj3);

        return staff;
    }
}
