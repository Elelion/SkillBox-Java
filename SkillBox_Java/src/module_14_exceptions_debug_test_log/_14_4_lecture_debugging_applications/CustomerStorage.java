package module_14_exceptions_debug_test_log._14_4_lecture_debugging_applications;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    /**/

    public void addCustomer(String data) {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    /**
     * перебирает storage и выводит все содержимое
     */
    public void listCustomers() {

        /**
         * List<String> lines = Files.readAllLines(Paths.get("file.txt"));
         * будет выдавать не обработанное исключение, те среда разработки видет
         * где может возникнуть ошибка и требует обернуть этот код в try/catch
         */
        try {
            List<String> lines = Files.readAllLines(Paths.get("file.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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
