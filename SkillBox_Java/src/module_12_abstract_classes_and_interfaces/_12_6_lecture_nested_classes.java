package module_12_abstract_classes_and_interfaces;


import java.util.Comparator;
import java.util.TreeSet;

public class _12_6_lecture_nested_classes {
    public _12_6_lecture_nested_classes() {
        System.out.println("1 - статические вложенные классы");

        _12_6_Lamp lamp = new _12_6_Lamp(100);
        lamp.setType(_12_6_Lamp.Type.LED);

        System.out.println("-");

        /**/

        System.out.println("2 - Анонимный класс");

        TreeSet<_12_6_LightingDeviceAbstract> lightingDevice = new TreeSet<>(new Comparator<_12_6_LightingDeviceAbstract>() {
            @Override
            public int compare(_12_6_LightingDeviceAbstract o1, _12_6_LightingDeviceAbstract o2) {
                return Integer.compare(o1.getPower(), o2.getPower());
            }
        });

    }

}
