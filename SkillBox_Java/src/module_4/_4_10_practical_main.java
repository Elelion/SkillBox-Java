package module_4;

public class _4_10_practical_main {
    public static void main(String[] args) {
        // Задание №1
        new _4_10_1_practical_Arithmetic(5,7);
        System.out.println("---");

        // Задание №2
        _4_10_2_practical_Basket vasyaBasket = new _4_10_2_practical_Basket();
//        vasyaBasket.add("колбаса", 76);
        vasyaBasket.add("молоко", 55, 10, 10);
        vasyaBasket.add("молоко", 65, 1, 1); // не добавиться, тк уже есть в корзине
        vasyaBasket.add("чипсы", 15, 2, 1);
        vasyaBasket.add("масло", 120, 3, 2);

        System.out.println("");
        vasyaBasket.print("Корзина Васи:");
        System.out.println("");
        System.out.println("Итого цена: " + vasyaBasket.getTotalPrice() + " руб.");
        System.out.println("Итого вес: " + vasyaBasket.getTotalWeight() + " кг.");
        System.out.println("---");
    }
}
