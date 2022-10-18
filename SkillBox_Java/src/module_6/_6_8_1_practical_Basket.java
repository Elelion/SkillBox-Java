package module_6;

public class _6_8_1_practical_Basket {
    /**
     * TODO: Задание 6.8 - 1
     * Для выполнения этого задания используйте проект из практической
     * работы 4.10, в GitLab — директория ObjectsAndClasses_Methods.
     *
     * Внесите следующие изменения в класс Basket:
     *
     * - Добавьте две статические переменные для хранения общей стоимости и
     * общего количества всех товаров во всех корзинах.
     *
     * - Реализуйте статические методы, которые будут увеличивать значения
     * этих переменных при добавлении в корзину новых товаров.
     *
     * - Реализуйте статический метод расчёта средней цены товара во всех
     * корзинах. Он должен рассчитывать и возвращать отношение общей стоимости
     * всех корзин к общему количеству всех товаров.
     *
     * - Реализуйте статический метод расчёта средней стоимости корзины
     * (отношение общей стоимости всех корзин к количеству корзин).
     *
     * - Названия и типы переменных, а также названия и методов придумайте
     * самостоятельно.
     *
     * Критерии оценки работы
     * Принято:
     *
     * - Выполнены все указанные в задании требования: созданы обе переменные
     * и реализованы все методы.
     * - Имена переменных соответствуют хранимым в них данным.
     * - Имена методов соответствуют выполняемым действиям.
     * - Все методы работают без ошибок, код компилируется.
     */

    private String items = "";
    private int totalPriceLocalBasket = 0;
    private int limit;
    private int totalWeight = 0;

    private static int totalSum;
    private static int totalQuantity;

    public _6_8_1_practical_Basket() {
        increaseCount();

        items = "Список товаров:";
        this.limit = 1000000;
    }

    public _6_8_1_practical_Basket(int limit) {
        this();
        this.limit = limit;
    }

    public _6_8_1_practical_Basket(String items, int totalPriceLocalBasket) {
        this();
        this.items += items;
        this.totalPriceLocalBasket = totalPriceLocalBasket;
    }

    /**/

    public static void increaseCount() {
        _6_8_1_practical_Basket.totalQuantity += 1;
    }

    /**/

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public int getTotalPrice() {
        return totalPriceLocalBasket;
    }

    public int getTotalSum() {
        return totalSum;
    }

    /**/

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add (String name, int price, int countLocalItem) {
        add(name, price, countLocalItem, 0);
    }

    public void add(String name, int price, int countLocalItem, int weight) {
        boolean error = false;
        int errorCode = 0;

        if (contains(name)) {
            error = true;
            errorCode = 1;
        }

        if (totalPriceLocalBasket + countLocalItem * price >= limit) {
            error = true;
            errorCode = 2;
        }

        if (error) {
            System.out.println("Error occured :( | Error code: " + errorCode);
            return;
        }

        String totalWeightString = weight > 0 ? weight + " кг." : " 0 кг.";
        items += "\n" + name + " - " + countLocalItem + " шт. - "
            + price + " - " + totalWeightString;

        this.totalWeight += weight;
        totalPriceLocalBasket += countLocalItem * price;
        totalSum += countLocalItem * price;
    }

    /**/

    public void clear() {
        items = "";
        totalPriceLocalBasket = 0;
        totalSum = 0;
    }

    private boolean contains(String name) {
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
