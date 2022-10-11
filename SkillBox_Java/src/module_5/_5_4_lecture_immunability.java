package module_5;

public class _5_4_lecture_immunability {
    /**
     * Иммутабельность (неизменяемый, immutable) класс — это класс, который
     * после инициализации не может изменить свое состояние. Те после создания
     * объекта значение переменных уже поменять нельзя.
     */

    // те иммутабельность сводиться к тому, что мы задаем константы + private
    private final String name;
    private final int price;

    // в конструкторе final можно назначить лишь однажды
    public _5_4_lecture_immunability(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**/

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    /**/

    // а при изменении константы IDE выдаст нам ошибку и сеттеров быть не должно
    public void setName(String name) {
        // this.name = name;
    }
}
