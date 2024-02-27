package module_13_features_of_OOP._13_10_lecture_generics;


import java.util.List;

public class Generics {
    String path = this.getClass().getResource("").getPath();
    public final String STAFF_TXT = path + "/data/staff.txt";

    public Generics() {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        LRUCache<Employee> cache = new LRUCache(5);
        for (Employee employee : staff) {
            cache.addElement(employee);
        }

        cache.getAllElements().forEach(System.out::println);
    }
}
