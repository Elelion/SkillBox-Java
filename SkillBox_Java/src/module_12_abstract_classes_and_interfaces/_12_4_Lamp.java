package module_12_abstract_classes_and_interfaces;

public class _12_4_Lamp extends _12_4_LightingDeviceAbstract
//    implements Comparable
{

    /**
     * у наследуемых классов от абстрактных классов - ВСЕГДА должны
     * вызываться конструкторы
     */
    public _12_4_Lamp(int power) {
        super(power);
    }

    // обязательно должны реализовать абстрактный метод !!!
    @Override
    public double getEnergyConsumption() {
        return power * brightness;
    }

    /**/

//    @Override
//    public int compareTo(Object o) {
//        _12_4_Lamp lamp = (_12_4_Lamp) o;
//        return Integer.compare(power, lamp.power);
//    }

//    @Override
//    public String toString() {
//        return "Lamp whit power: " + power;
//    }
}
