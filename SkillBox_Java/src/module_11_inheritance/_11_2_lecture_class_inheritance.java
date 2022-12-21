package module_11_inheritance;

public class _11_2_lecture_class_inheritance {
    public _11_2_lecture_class_inheritance() {
        System.out.println("1 - Создаем обычный экземпляр класса и смотрим как он работает");

        _11_2_Bus bus = new _11_2_Bus(0.001);
        bus.refuel(1);
        System.out.println("Резерв: " + bus.powerReserve());
        System.out.println("едем 50 км: " + bus.run(50));
        System.out.println("Резерв: " + bus.powerReserve());
        System.out.println("едем 900 км: " + bus.run(900));
        System.out.println("Резерв: " + bus.powerReserve());
        System.out.println("едем 100 км: " + bus.run(100));
        System.out.println("Резерв: " + bus.powerReserve());

        System.out.println("-");

        /**/

        System.out.println("2 - создаем наследуемый объект");

        _11_2_Bus electricBus = new _11_2_ElectricBus(0.001, 10);
        electricBus.refuel(1);
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 50 км: " + electricBus.run(50));
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 900 км: " + electricBus.run(900));
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 100 км: " + electricBus.run(100));
        System.out.println("Резерв: " + electricBus.powerReserve());

    }
}
