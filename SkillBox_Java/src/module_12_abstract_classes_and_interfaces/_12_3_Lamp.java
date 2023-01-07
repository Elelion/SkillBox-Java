package module_12_abstract_classes_and_interfaces;

public class _12_3_Lamp extends _12_2_LightingDeviceAbstract {


    /**
     * у наследуемых классов от абстрактных классов - ВСЕГДА должны
     * вызываться конструкторы
     */
    public _12_3_Lamp(int power) {
        super(power);
    }

    // обязательно должны реализовать абстрактный метод !!!
    @Override
    public double getEnergyConsumption() {
        return power * brightness;
    }
}
