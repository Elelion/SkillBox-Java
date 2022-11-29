package module_4_objects_and_classes_Part_1;

public class _4_10_2_practical_Basket {
    /**
     * TODO: Задача 4.10 - 2
     * Допишите в класс Basket (проект в репозитории ObjectsAndMethods или, если
     * у вас его нет, скачайте архив, приложенный к заданию):
     *
     * - Переменную “totalWeight”, которая будет содержать общую массу всех
     * товаров, добавленных в корзину:
     * • Начальное значение переменной должно быть равно 0.
     * • При добавлении в корзину товара методом add() с параметром веса
     * (см. ниже описание этого метода) добавляйте переданный в метод вес
     * к этой переменной.
     * • Если вызывается уже существующий в классе метод add(), не содержащий
     * параметр веса (weight), эта переменная не должна изменяться.
     *
     * - Метод add с дополнительным параметром веса (weight):
     * public void add(String name, int price, int count, double weight)
     * Метод должен переиспользовать существующие методы добавления и добавлять
     * указанный в их параметрах вес товаров к общему весу корзины.
     *
     * - Метод, который будет возвращать значение массы всех товаров в корзине:
     * public double getTotalWeight()
     */

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private int totalWeight = 0;

    public _4_10_2_practical_Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public _4_10_2_practical_Basket(int limit) {
        this();
        this.limit = limit;
    }

    public _4_10_2_practical_Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        _4_10_2_practical_Basket.count = _4_10_2_practical_Basket.count + count;
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
