package module_4;

public class _4_3_lecture_IM_basket {
    public static String items = "";

    public static void main(String[] args) {
        add("колбаса", 76);
        add("молоко", 55);
        add("масло", 120);

        print("Содержимое корзины");
        clear();
        print("Содержимое корзины");

        /**
         * instanceof используется для проверки того, является ли объект
         * экземпляром указанного типа
         */
        if (items instanceof String) {
            System.out.println("items является типом String");
        }
    }

    public static void add(String name, int price) {
        items = items + "\n" + name +  " - " + price;
    }

    public static void clear() {
        items = "";
    }

    public static void print(String title) {
        System.out.println(title);

        //  проверяем пустая ли строка или нет
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
