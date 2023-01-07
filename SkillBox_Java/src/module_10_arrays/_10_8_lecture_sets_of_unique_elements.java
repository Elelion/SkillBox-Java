package module_10_arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class _10_8_lecture_sets_of_unique_elements {
    public _10_8_lecture_sets_of_unique_elements() {
        // коллекция лист - список
        ArrayList<String> todoList = new ArrayList<>();

        // коллекция set
//        HashSet<String> words = new HashSet<>();
        TreeSet<String> words = new TreeSet<>();
        words.add("Второе");
        words.add("Первое");
        words.add("Третье");
        words.add("Второе"); // не выведится тк будет преобразовано в хеш

        for (String word: words) {
            System.out.println(word);
        }

        /**
         * выведет результат за одну операцию, без какого либо перебора
         * тк будет искать по хешированным данным
         */
        System.out.println(words.contains("Второе"));
    }
}
