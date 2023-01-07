package module_14_exceptions_debug_test_log._14_2_lecture_catching_exceptions;

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

    /**
     * те обрабатывать ошибки можно и так - НО это считается не верным, тк
     * это PHP подход, в Java нужно все делать через Exception's
     */
    /*
    public boolean addCustomer(String data) {
        String[] components = data.split("\\s+");

        // пишем обработчик ошибки, если будет ошибка, то вернется false
        if (components.length != 4) {
            return false;
        }

        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));

        // если все хорошо то вернется true
        return true;
    }
    */
    public void addCustomer(String data) {
        String[] components = data.split("\\s+");

        // пишем обработчик ошибки, если будет ошибка, то вернется false
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format. Correct format: \n" +
                "add Vasiliy Petrov vasiliy.petrov@gmail.com +79998887766");
        }

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
