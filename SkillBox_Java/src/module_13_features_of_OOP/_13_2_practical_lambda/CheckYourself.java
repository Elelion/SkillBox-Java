package module_13_features_of_OOP._13_2_practical_lambda;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CheckYourself {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    // HardCode путь, так работает то же
    // public final String STAFF_TXT = "SkillBox_Java/src/module_13_features_of_OOP/_13_2_lecture_pointers_to_methods/data/staff.txt";

    public CheckYourself() {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        System.out.println("-");

        sortBySalaryAndAlphabet(staff);

        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i));
        }
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