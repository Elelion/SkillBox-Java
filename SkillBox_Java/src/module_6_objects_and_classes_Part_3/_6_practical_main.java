package module_6_objects_and_classes_Part_3;

public class _6_practical_main {
    public static void main(String[] args) {
        // Задание №1
        System.out.println("Задание №1");
        _6_8_1_practical_Basket vasyaBasket = new _6_8_1_practical_Basket();
        vasyaBasket.add("колбаса", 10);
        vasyaBasket.add("молоко", 20, 1, 20);
        vasyaBasket.add("молоко", 20, 1, 15); // не добавиться, тк уже есть в корзине
        vasyaBasket.add("масло", 200, 2, 10);
        vasyaBasket.print("Корзина Васи");
        System.out.println("getTotalWeight: " + vasyaBasket.getTotalWeight());
        System.out.println("getTotalPrice: " + vasyaBasket.getTotalPrice());

        System.out.println("Всего корзин: " + vasyaBasket.getTotalQuantity());
        System.out.println("Сумма заказа со всех корзин: " + vasyaBasket.getTotalSum());
        System.out.println("-");

        /**/

        _6_8_1_practical_Basket petyaBasket = new _6_8_1_practical_Basket();
        petyaBasket.add("Лопата", 500, 1, 1500);
        petyaBasket.add("Бочка", 1000, 2);
        petyaBasket.print("Корзина Пети");
        System.out.println("getTotalPrice: " + petyaBasket.getTotalPrice());

        System.out.println("Всего корзин: " + petyaBasket.getTotalQuantity());
        System.out.println("-");

        /**/

        _6_8_1_practical_Basket basketCheck = new _6_8_1_practical_Basket();
        System.out.println("Всего корзин: " + basketCheck.getTotalQuantity());
        System.out.println("Сумма заказа со всех корзин: " + basketCheck.getTotalSum());
        System.out.println("\n---\n");

        /* ----------------------------------------------------------------- */

        // Задание №2
        System.out.println("Задание №2");
        _6_8_2_practical_Computer computer = new _6_8_2_practical_Computer(
            "Arbyte", "home PC"
        );

        /**/

        _6_8_2_practical_cpu cpu = new _6_8_2_practical_cpu(1400, 4,
                _6_8_2_practical_cpuManufacturerType.INTEL, 0.15);
        _6_8_2_practical_ram ram = new _6_8_2_practical_ram(_6_8_2_practical_ramType.DDR5,
                8000, 0.25);
        _6_8_2_practical_drive drive = new _6_8_2_practical_drive(_6_8_2_practical_driveType.SSD,
                512, 0.35);
        _6_8_2_practical_monitor monitor = new _6_8_2_practical_monitor(32.2,
                _6_8_2_practical_monitorType.IPS, 2.75);
        _6_8_2_practical_keyboard keyboard = new _6_8_2_practical_keyboard(
                _6_8_2_practical_keyboardType.MECHANICAL, true, 0.350);

        System.out.println(cpu);
        System.out.println("\n...\n");

        /**/

        _6_8_2_practical_Computer computer2 = new _6_8_2_practical_Computer(
                "hand-made", "for client",
                cpu, ram, drive, monitor, keyboard
        );
        System.out.println(computer2);
        System.out.println("\n...\n");

        computer2.setKeyboard(_6_8_2_practical_keyboardType.LASER, false, 1.2);
        System.out.println(computer2);
    }
}
