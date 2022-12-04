package module_6_objects_and_classes_Part_3;

public class _6_main {
    public static void main(String[] args) {
        // Лекция 6.2
        System.out.println("Лекция 6.2");

        // count = 1
        _6_2_lecture_Basket Basket = new _6_2_lecture_Basket("товары", 5666);

        // count = 2
        _6_2_lecture_static_variables Session = new _6_2_lecture_static_variables();

        // обращаемся к статической переменной
        System.out.println(_6_2_lecture_Basket.count);
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        // Лекция 6.3
        System.out.println("Лекция 6.3");

        // count = 1
        _6_3_lecture_static_methods_Basket BasketMth = new _6_3_lecture_static_methods_Basket(
            "товары", 5666);

        // count = 2
        _6_3_lecture_static_methods_Basket SessionMth = new _6_3_lecture_static_methods_Basket();

        // обращаемся к статического метода
        System.out.println(_6_3_lecture_static_methods_Basket.getCount());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        // Лекция 6.5
        System.out.println("Лекция 6.5");

        _6_5_lecture_GearBoxTypeEnum type = _6_5_lecture_GearBoxTypeEnum.valueOf("ROBOT");
        _6_5_lecture_enum_GearBox GearBox = new _6_5_lecture_enum_GearBox(type);
        // _6_5_lecture_enum_GearBox GearBox = new _6_5_lecture_enum_GearBox(_6_5_lecture_GearBoxTypeEnum.AUTOMATIC);
        System.out.println(GearBox.type);
        System.out.println("-");


        // Задание 6.5 - 1 (лекционное)
        System.out.println("Задание 6.5 - 1 (лекционное)");

        _6_5_task_1_ArithmeticCalculator calculator =
            new _6_5_task_1_ArithmeticCalculator(56, 12);

        System.out.println("Сложение: " +
            calculator.calculate(_6_5_task_1_EnumOperation.ADD));
        System.out.println("Вычитание: " +
            calculator.calculate(_6_5_task_1_EnumOperation.SUBTRACT));
        System.out.println("Умножение: " +
            calculator.calculate(_6_5_task_1_EnumOperation.MULTIPLY));

        System.out.println("-");

        // Задание 6.5 - 2 (лекционное)
        System.out.println("Задание 6.5 - 2 (лекционное)");

        _6_5_task_2_Engine engine = new _6_5_task_2_Engine(
            _6_5_task_2_EngineType.DIESEL, 3.5, 156
        );

        _6_5_task_2_Car car = new _6_5_task_2_Car(
            _6_5_task_2_CarType.SUV, engine, 2300
        );

        System.out.println("Тип автомобиля: " + car.getType());
        System.out.println("Масса двигателя: " + car.getWeight());

        // Важно!!! - обратить внимание на: car.getEngine().getType() - двойной вызов!
        System.out.println("Тип двигателя: " + car.getEngine().getType());
        System.out.println("Объём двигателя: " + car.getEngine().getVolume());
        System.out.println("Мощность двигателя: " + car.getEngine().getPower());
    }
}
