package module_10_arrays;

import java.util.ArrayList;

public class _10_6_lecture_lists_of_elements {
    public _10_6_lecture_lists_of_elements() {
        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("Первое наше дело");
        todoList.add("Второе наше дело");

        // указываем индекс на котором будет наша строка
        todoList.add(1, "Третье дело");

        // будет ошибка, тк индекс долден быть последним
        // todoList.add(5, "Третье дело");

        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(todoList.get(i));
        }

        /**/

        // Упращенная запись - быстрая инициализация
        ArrayList<String> todoList2 = new ArrayList<>() {{
            add("Первая строка");
            add("Вторая строка");
            add("Третья строка");
        }};

        // удалить индекс с содержимым
        todoList2.remove(2);
    }
}
