package module_14_exceptions_debug_test_log._14_1_lecture_occurrence_of_exceptions;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    /**/

    /**
     * добавляет в наш storage строки с пользователями и их данными
     * \\s+ - поиск пробелов в строке - регулярка, те пробел разделяет наши
     * строки при добавлении
     */
    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    /**
     * перебирает storage и выводит все содержимое
     */
    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    /**
     * удоляет конкретное имя из storage
     */
    public void removeCustomer(String name) {
        storage.remove(name);
    }

    /**
     * возвращяет размер storage
     */
    public int getCount() {
        return storage.size();
    }
}
