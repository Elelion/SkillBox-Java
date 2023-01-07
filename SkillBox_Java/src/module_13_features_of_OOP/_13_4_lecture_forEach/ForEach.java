package module_13_features_of_OOP._13_4_lecture_forEach;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForEach {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    // HardCode путь, так работает то же
    // public final String STAFF_TXT = "SkillBox_Java/src/module_13_features_of_OOP/_13_2_lecture_pointers_to_methods/data/staff.txt";

    public ForEach() {
        List<Employee> staff =
            Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        System.out.println("-");

        // данное выражение можно написать как (см ниже)
        // Collections.sort(staff, ((o1, o2) -> o1.getSalary().compareTo(o2.getSalary())));

        // Указатель передается через ::
        Collections.sort(staff, Comparator.comparing(Employee::getSalary));

        sortBySalaryAndAlphabet(staff);

        // за место нашего любимого FOR теперь будет ForEach (как в PHP)
        /*
        for (Employee employee : staff) {
            System.out.println(employee);
        }
        */

        /**
         * в ForEach мы пишем Лямбда выражение
         * Цикл foreach - это синтаксический сахар. Внешне прежде всего
         * отличается от for отсутствием явного счетчика. Единственное
         * практическое различие между ними заключается в том, что в случае
         * индексируемых объектов у вас нет доступа к индексу.
         */
//        staff.forEach(employee -> System.out.println(employee));

        // или так
        System.out.println("Old salaries:");
        staff.forEach(System.out::println);

        System.out.println("-");

        /**/

        System.out.println("New salaries:");

        // поднимаем всем ЗП на 10к через лямбду + forEach
        // работает как то так если сравнивать с PHP...
        /*
        var.forEach($arr as $key)
        var.forEach(
            var as emp -> {
                // some code....
                emp.set...
            });
         */

        staff.forEach(employee -> {
            int salary = employee.getSalary();
            employee.setSalary(salary + 10_000);
        });

        // более короткий вариант
        staff.forEach(e -> e.setSalary(e.getSalary() + 10_000));

        /**/

        // выводим
        staff.forEach(System.out::println);
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