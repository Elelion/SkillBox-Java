package module_6;

import java.time.Period;

public class _6_6_lecture_static_initialization_Basket {
    public static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private int totalWeight = 0;

    // присваиваем значение в блоке статической инициализации
    private static int timeout = getTimeout();

    /**
     * блоки статической инициализации
     * в нутри пишется код, который срабатывает при первом обращении
     * к данному классу
     *
     * Важно!!!
     * НО такой подход используется все реже и реже, за место него пишут
     * просто статические методы
     */
    /*
    static {
        int secondsInHour = 3600;
        int hoursInDay = 24;
        int daysInWeek = 7;
        int dayInMonth = 30;

        // далее пишем какую нибудь логику
        timeout = secondsInHour * hoursInDay *
            (count < 5 ? daysInWeek : dayInMonth);
    }
    */

    private static int getTimeout() {
        int secondsInHour = 3600;
        int hoursInDay = 24;
        int daysInWeek = 7;
        int dayInMonth = 30;

        // далее пишем какую нибудь логику
        return secondsInHour * hoursInDay *
                (count < 5 ? daysInWeek : dayInMonth);
    }

    public _6_6_lecture_static_initialization_Basket() {
        // будет срабатывать при каждом создании корзины (при new...)
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public _6_6_lecture_static_initialization_Basket(int limit) {
        this();
        this.limit = limit;
    }

    public _6_6_lecture_static_initialization_Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        _6_6_lecture_static_initialization_Basket.count = _6_6_lecture_static_initialization_Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add (String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, int weight) {
        boolean error = false;
        int errorCode = 0;

        if (contains(name)) {
            error = true;
            errorCode = 1;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
            errorCode = 2;
        }

        if (error) {
            System.out.println("Error occured :( | Error code: " + errorCode);
            return;
        }

        String totalWeightString = weight > 0 ? weight + " кг." : " 0 кг.";
        items += "\n" + name + " - " + count + " шт. - " + price + " - " + totalWeightString;

        this.totalWeight += weight;
        totalPrice += count * price;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
