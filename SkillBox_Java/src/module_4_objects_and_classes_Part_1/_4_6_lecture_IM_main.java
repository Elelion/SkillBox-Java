package module_4_objects_and_classes_Part_1;

// отделяем main от нашего основного класса basket
public class _4_6_lecture_IM_main {
    public static void main(String[] args) {
        /**
         * TODO: Задача 4.6 - 1
         * Задание 1. Создайте класс с конструктором и используйте его
         *
         * TODO: Задача 4.6 - 2
         * Создайте класс с несколькими конструкторами
         */

        /**
         * в конструктор мы задаем лимит итоговой цены, те при добавлении очередного
         * товара будет происходить проверка, и если итоговая сумма будет выше
         * суммы заданной в конструктор, то товар больше не добавиться
         * проверка реализована в методе:
         *
         * public void add(String name, int price) {...}
         */
        _4_6_lecture_IM_Constructors_Basket vasyaBasket = new _4_6_lecture_IM_Constructors_Basket(100);
        vasyaBasket.add("колбаса", 76);
        vasyaBasket.add("молоко", 55);
        vasyaBasket.add("молоко", 65); // не добавиться, тк уже есть в корзине
        vasyaBasket.add("чипсы", 15);
        vasyaBasket.add("масло", 120);
        vasyaBasket.print("Корзина Васи");
        System.out.println("Итого: " + vasyaBasket.getTotalPrice());
        System.out.println("---");

        /**/

        _4_6_lecture_IM_Constructors_Basket petyaBasket = new _4_6_lecture_IM_Constructors_Basket(300);
        petyaBasket.add("Лопата", 280);
        petyaBasket.add("Бочка", 5500);
        petyaBasket.print("Корзина Пети");
        System.out.println("---");

        /**/

        _4_6_lecture_IM_Constructors_Basket mashaBasket = new _4_6_lecture_IM_Constructors_Basket("Стол", 5000);
        mashaBasket.print("Корзина Маши");
        System.out.println("---");

        /**/

        _4_6_lecture_IM_Constructors_Basket ivanBasket = new _4_6_lecture_IM_Constructors_Basket();
        ivanBasket.print("Корзина Ивана");
        System.out.println("---");

        /**/

        // Задача 1
        _4_6_lecture_IM_user dmitry = new _4_6_lecture_IM_user("Дмитрий", 45);
        _4_6_lecture_IM_user oleg = new _4_6_lecture_IM_user("Олег", 40);
        _4_6_lecture_IM_user katya = new _4_6_lecture_IM_user("Катя", 35);

        printUserInfo(dmitry);
        printUserInfo(oleg);
        printUserInfo(katya);
        System.out.println("---");

        // Задача 2
        _4_6_lecture_IM_employee ben = new _4_6_lecture_IM_employee(
                "Бен Алексеев", 6567
        );
        _4_6_lecture_IM_employee anna = new _4_6_lecture_IM_employee(
                "Анна Потапова", "anna@smart.ru"
        );
        _4_6_lecture_IM_employee daria = new _4_6_lecture_IM_employee(
                "Дарья Савина",
                "daria.savina@smart.ru",
                2442
        );

        ben.printInfo();
        anna.printInfo();
        daria.printInfo();
        System.out.println("---");
    }

    public static void printUserInfo(_4_6_lecture_IM_user user) {
        System.out.println("Информация о пользователе:");
        System.out.println("Имя: " + user.getName());
        System.out.println("Возраст: " + user.getAge());
    }
}
