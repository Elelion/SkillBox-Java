package module_6_objects_and_classes_Part_3;

public class _6_2_lecture_Basket {
    public static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;

    private int totalWeight = 0;

    public _6_2_lecture_Basket() {
        // будет срабатывать при каждом создании корзины (при new...)
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public _6_2_lecture_Basket(int limit) {
        this();
        this.limit = limit;
    }

    public _6_2_lecture_Basket(String items, int totalPrice) {
        this();
        this.items += items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        _6_2_lecture_Basket.count = _6_2_lecture_Basket.count + count;
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
