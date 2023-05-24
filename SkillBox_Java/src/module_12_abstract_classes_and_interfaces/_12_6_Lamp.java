package module_12_abstract_classes_and_interfaces;

public class _12_6_Lamp extends _12_6_LightingDeviceAbstract {

    private Type type;

    // вложенный класс
    public enum Type {
        INCANDESCENT,
        FILAMENT,
        LED,
        LUMINESCENT
    }

    /**
     * у наследуемых классов от абстрактных классов - ВСЕГДА должны
     * вызываться конструкторы
     */
    public _12_6_Lamp(int power) {
        super(power);
    }

    // обязательно должны реализовать абстрактный метод !!!
    @Override
    public double getEnergyConsumption() {
        return power * brightness;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
