package module_11_inheritance;

public class _11_5_lecture_class_object {
    public _11_5_lecture_class_object() {
        System.out.println("1 - Работаем с Object");

        // все в Java наследуется от Object
        Object obj = new Object();

        _11_5_Bus bus1 = new _11_5_Bus(0.001);
        _11_5_Bus bus2 = new _11_5_Bus(0.001);
        _11_3_ElectricBus ebus1 = new _11_3_ElectricBus(0.001, 0.1);

        System.out.println("bus1.equals(ebus1): " + bus1.equals(ebus1));
        System.out.println("bus1.equals(bus2): " + bus1.equals(bus2));
        System.out.println("-");

        /**/

        System.out.println("2 - работаем дальше с Object");

        Class busObjClass = bus1.getClass();
        System.out.println(busObjClass.getName());
        System.out.println("-");

        /**/

        System.out.println("3 - строковые представления");

        // выведет имя класса и хеш представление - Bus@eda1cf72
        System.out.println("bus1.toString(): " + bus1.toString());

        // еще один вывод класса, но в ручную, то, что возвращает toString() по умолчанию
        System.out.println("bus1: " + bus1.getClass().getName() + "@" +
            Integer.toHexString(bus1.hashCode()));
    }
}
