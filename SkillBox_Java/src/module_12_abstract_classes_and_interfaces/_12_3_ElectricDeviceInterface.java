package module_12_abstract_classes_and_interfaces;

public interface _12_3_ElectricDeviceInterface {
    void switchOn();

    void switchOff();

    // в интерфейсах ВСЕГДА методы публичные
    double getEnergyConsumption();

    boolean isSwitchedOn();

    /**/
    
    // создаем default метод
    default void toggle() {
        if (isSwitchedOn()) {
            switchOff();
        } else {
            switchOn();
        }
    }
}
