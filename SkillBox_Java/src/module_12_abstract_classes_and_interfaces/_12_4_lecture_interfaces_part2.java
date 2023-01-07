package module_12_abstract_classes_and_interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class _12_4_lecture_interfaces_part2 {
    public _12_4_lecture_interfaces_part2() {
        System.out.println("1 - ");

        // на освнове объекта мы создаем массив возвращаемых значений
        ArrayList<_12_4_Lamp> lamps = new ArrayList<>();
        lamps.add(new _12_4_Lamp(100));
        lamps.add(new _12_4_Lamp(20));
        lamps.add(new _12_4_Lamp(40));
        lamps.add(new _12_4_Lamp(150));

        /**
         * Использование implements Comparable позволяет
         * упорядочивать (сортировать) данные.
         *
         * если в классе Lamp мы уберем строку implements Comparable
         * то, Collections - не работал бы, и выдавал ошибку
         */
        Collections.sort(lamps);

        for (_12_4_Lamp lamp : lamps) {
            System.out.println(lamp);
        }

        // ...

        System.out.println("-");

        /**/

        System.out.println("2 - ");
    }
}

// 6-27