package module_11_inheritance;

public class _11_3_lecture_method_override {
    public _11_3_lecture_method_override() {
        System.out.println("1 - Создаем обычный экземпляр класса и смотрим как он работает");

        _11_3_Bus bus = new _11_3_Bus(0.001);
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

        _11_3_ElectricBus electricBus = new _11_3_ElectricBus(0.001, 10);
        electricBus.refuel(1);
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 50 км: " + electricBus.run(50));
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 900 км: " + electricBus.run(900));
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("едем 100 км: " + electricBus.run(100));
        System.out.println("Резерв: " + electricBus.powerReserve());
        System.out.println("-");

        /**/

        System.out.println("3 - наследование static");

        _11_3_Bus bus1 = new _11_3_Bus(0.001);
        _11_3_Bus bus2 = new _11_3_Bus(0.001);
        _11_3_Bus bus3 = new _11_3_Bus(0.001);

        _11_3_ElectricBus ebus1 = new _11_3_ElectricBus(0.001, 0.1);
        _11_3_ElectricBus ebus2 = new _11_3_ElectricBus(0.001, 0.1);

        /**
         * _11_3_lecture_Bus.getCount - будет считать общее кол-во ВСЕХ автобусов
         * и элбасов, тк он родитель для всех наследуемых классов
         */
        System.out.println("Количество автобусов: " + _11_3_Bus.getCount());

        /**
         * _11_3_lecture_ElectricBus.getCount - будет считать ТОЛЬКО кол-во
         * элбасов, тк этот метод прописан в _11_3_lecture_ElectricBus
         * переопределять статические методы - НЕЛЬЗЯ
         */
        System.out.println("Количество электробусов: " + _11_3_ElectricBus.getCount());
    }
}
