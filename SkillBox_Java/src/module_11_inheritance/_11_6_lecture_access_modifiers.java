package module_11_inheritance;

import module_11_inheritance.transport._11_6_Bus;

public class _11_6_lecture_access_modifiers {
    public _11_6_lecture_access_modifiers() {
        System.out.println("1 - модификаторы доступа");

        /**
         * public - общедоступный
         * protected - доступен только для текущего и наследуемых классов
         * private - токльо в нутри класса
         * package-private - ограничивает доступ к классам, конструкторам,
         *      методам - текущим пакетом в котором они находятся (является
         *      по умолчанию, если модификатор НЕ установлен)
         */
        System.out.println("-");

        /**/

        System.out.println("2 - расширение классов");
        /**
         * расширять классы можно, те это
         * в классе Bus у нас есть public метод, в eBus мы этот метод
         * переопределяем и делаем protected
         *
         * наоборот сделать (сузить) нельзя
         * те в классе Bus сделать метод protected
         * а в классе eBus этот же метод сделать public
         */

        System.out.println("-");

        /**/

        System.out.println("3 - пакетная зона видимости");
        /**
         * создаем package->transport и в него перемещаем наш Bus + eBus
         * у методов убираем public / protected
         * и этими методами не кто не сможет пользоваться с наружи, те
         * пользоваться ими можно будет только в нутри пакета transport
         */
        _11_6_Bus bus = new _11_6_Bus(0.001);

        /**
         * будет ошибка вызова, тк его НЕльзя вызвать с наружи нашего пакета
         * Cannot be accessed from outside package
         */
//        bus.powerReserve();
    }
}
