package module_4;

public class _4_4_lecture_IM_return_values {

    /**
     * TODO: Задача 4.4 - 1
     * Напишите метод, рассчитывающий и возвращающий сумму трёх переданных ему
     * в качестве параметров чисел
     *
     * TODO: Задача 4.4 - 2
     * Напишите метод, возвращающий большее из двух переданных ему в качестве
     * параметров чисел
     */

    public static String items = "";
    public static int totalPrice = 0;

    public static void main(String[] args) {
        add("колбаса", 76);
        add("молоко", 55);
        add("молоко", 65); // не добавиться, тк уже есть в корзине
        add("масло", 120);
        print("Содержимое корзины");
        System.out.println("Общая стомость товаров: " + getTotalPrice());
        clear();
        System.out.println("---");
        print("Содержимое корзины");
        System.out.println("Общая стомость товаров: " + getTotalPrice());

        /**
         * instanceof используется для проверки того, является ли объект
         * экземпляром указанного типа
         */
        if (items instanceof String) {
            System.out.println("items является типом String");
        }

        System.out.println("---");
        System.out.println("Домашка");

        // Домашка №1
        int sum = calculateSum(300, 200, 700);
        System.out.println(sum);

        // Домашка №2
        int max = max(300, 200);
        System.out.println(max);
    }

    public static void add(String name, int price) {
        /**
         * проверяем есть ли уже такой товар в корзине или нет
         * если он есть, те containsString вернет true, то выполнение
         * этого метода завершиться, а если вернет false, то добавиться
         */
        if (containsString(name)) {
            return;
        }

        items = items + "\n" + name +  " - " + price;
        totalPrice += price;
    }

    public static void clear() {
        items = "";
        totalPrice = 0;
    }

    /**
     * return - так же приводит к завершению работы метода
     * сли после него написать какой то код, то он не будет выполняться
     */
    public static int getTotalPrice() {
        return totalPrice;
    }

    // Домашка №1
    public static int calculateSum(int a, int b, int c) {
        return a + b + c;
    }

    // Домашка №2
    public static int max(int a, int b) {
        // аналогично: return a >= b ? a : b;
        return Math.max(a, b);

    }

    public static boolean containsString(String name) {

        // закоментированная запись аналогична записи ниже
        /*
        if (items.contains(name)) {
            return true;
        }

        return false;
        */

        /**
         * contains - метод чтобы проверить, содержит ли String указанную
         * последовательность символов. Этот метод возвращает логический
         * тип данных, который является результатом тестирования, если строка
         * содержит символы, указанные в аргументе метода в типе объекта
         * CharSequence. Метод contains() возвращает true тогда и только тогда,
         * когда эта строка содержит указанную последовательность значений char.
         */

        /**
         * те мы проверяем в нашем items значения которые уже есть
         * со значением которые мы зададим в name
         */
        return items.contains(name);
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
