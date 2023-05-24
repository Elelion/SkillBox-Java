package module_13_features_of_OOP._13_10_lecture_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Когда разработчик создает дженерик-класс, он приписывает к нему параметр
 * в треугольных скобках — метку. К примеру, так:
 * class myClass<T>;
 */
public class LRUCache<T> {
    /**
     * Cache - кеш в котором храниться заданное кол-во елементов
     * и при добавлении новых данных - наиболее старые из них стираются
     *
     * Теперь при создании объекта этого класса нужно будет указать на
     * месте T название типа, с которым будет работать объект. Например,
     * myClass<Integer> <название объекта> для целых чисел или
     * myClass<String> <название объекта> для строк. Сам класс остается
     * универсальным, то есть общим. А вот каждый его объект специфичен
     * для своего типа.
     *
     * С помощью дженериков можно создать один класс, а потом на основе
     * него — несколько объектов этого класса для разных типов. Не
     * понадобится дублировать код и усложнять программу. Поэтому
     * дженерики лучше и удобнее, чем проверка типа прямо в коде — тогда
     * для каждого типа данных понадобился бы свой класс.
     */
    ArrayList<T> elements;
    int size;

    public LRUCache(int size) {
        this.size = size;
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        int currentSize = elements.size();

        if (currentSize >= size) {

            // удалим самый первый елемент
            for (int i = 0; i < currentSize - size + 1; i++) {
                elements.remove(0);
            }
        }

        // добавим в конец значение
        elements.add(element);
    }

    public T getElement(int i) {
        if (i >= elements.size()) {
            return null;
        }

        return elements.get(i);
    }

    public List<T> getAllElements() {
        return elements;
    }
}
