package module_10_arrays;

import java.util.ArrayList;
import java.util.Collections;

public class _10_12_lecture_search_and_sort {
    public _10_12_lecture_search_and_sort() {
        ArrayList<String> items = new ArrayList<>();


        items.add("line1");
        items.add("line3");
        items.add("line2");
        items.add("line7");

        /**
         * Collections - Он содержит полиморфные алгоритмы, которые используются
         * при работе с коллекциями. Этот класс содержит методы основных
         * алгоритмов Сollection framework, а именно методы бинарного поиска,
         * сортировка, перемешивание, а также метод, возвращающий обратный
         * порядок элементов и многие другие.
         */

        /**
         * Класс Collections имеет алгоритм shuffle, который выполняет
         * противоположную сортировке задачу: случайным образом изменяет
         * порядок элементов в списке.
         */
        Collections.sort(items);
        System.out.println(items);

        // если найдет, вернет индекс, если нет, то -1
        System.out.println(Collections.binarySearch(items, "line7"));

    }
}
