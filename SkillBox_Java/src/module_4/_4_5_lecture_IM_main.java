package module_4;

// отделяем main от нашего основного класса basket
public class _4_5_lecture_IM_main {
    public static void main(String[] args) {
        /**
         * TODO: Задача 4.5 - 1
         * Создайте класс с одной переменной и двумя методами
         *
         * TODO: Задача 4.5 - 2
         * Измените существующие и добавьте новые методы в класс
         */

        _4_5_lecture_IM_classes_and_objects_Basket vasyaBasket = new _4_5_lecture_IM_classes_and_objects_Basket();
        vasyaBasket.add("колбаса", 76);
        vasyaBasket.add("молоко", 55);
        vasyaBasket.add("молоко", 65); // не добавиться, тк уже есть в корзине
        vasyaBasket.add("масло", 120);
        vasyaBasket.print("Корзина Васи");
        System.out.println("---");

        /**/

        _4_5_lecture_IM_classes_and_objects_Basket petyaBasket = new _4_5_lecture_IM_classes_and_objects_Basket();
        petyaBasket.add("Лопата", 280);
        petyaBasket.add("Бочка", 5500);
        petyaBasket.print("Корзина Пети");
        System.out.println("---");

        /**/

        _4_5_lecture_IM_classes_and_objects_Basket IvanBasket = new _4_5_lecture_IM_classes_and_objects_Basket();
        IvanBasket.print("Корзина Ивана");
        System.out.println("---");

        /**/

        // Задача №1
        _4_5_lecture_IM_order order1 = new _4_5_lecture_IM_order();
        order1.addProducts(54, 500);
        order1.addProducts(600, 550);
        System.out.println(order1.getProductsCount());
        System.out.println("---");

        // Задача №2
        _4_5_lecture_IM_order order2 = new _4_5_lecture_IM_order();
        order2.addProducts(201, 40000);
        order2.addProducts(317, 12000);
        System.out.println(
            "Количество: " + order2.getProductsCount()
        );
        System.out.println(
            "Стоимость: " + order2.getTotalCost()
        );
    }
}
