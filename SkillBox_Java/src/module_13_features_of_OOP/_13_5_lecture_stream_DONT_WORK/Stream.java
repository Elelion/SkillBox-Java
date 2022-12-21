package module_13_features_of_OOP._13_5_lecture_stream_DONT_WORK;

import java.util.List;

public class Stream {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    public Stream() {
        List<module_13_features_of_OOP._13_5_lecture_stream_DONT_WORK.Employee> staff =
            module_13_features_of_OOP._13_5_lecture_stream_DONT_WORK.Employee.loadStaffFromFile(STAFF_TXT);
//        ArrayList<Employee> staff = new Employee::loadStaffFromFile(STAFF_TXT);

        /**
         * использование Stream
         * например напечатаем тех работников у которых ЗП > 100k
         */
//        Stream stream = (Stream) staff.stream();
        Stream stream = (Stream) staff.stream();

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