package module_12_abstract_classes_and_interfaces;

import java.util.ArrayList;

public class _12_5_SmartHouse {
    private ArrayList<_12_5_ElectricDeviceInterface> devices;

    public _12_5_SmartHouse() {
        devices = new ArrayList<>();
        initLightingDevices();

        System.out.println("devices size: " + devices.size());

        /**/

        for (_12_5_ElectricDeviceInterface device: devices) {
            // проверяем является ли устр-во осветительным прибором (true / false)
            boolean status = device instanceof _12_5_LightingDeviceAbstract;
            System.out.println(device + " - " + status);
        }

        System.out.println(devices.get(2));
    }

    /**
     * отключить все приборы
     */
    public void switchOffAllDevices() {
        for (_12_5_ElectricDeviceInterface device: devices) {
            device.switchOff();
        }
    }

    /**
     * суммируем энерго потребление каждого устройства
     */
    public double getEnergyConsumption() {
        double sum = 0;

        for (_12_5_ElectricDeviceInterface device: devices) {
            sum += device.getEnergyConsumption();
        }

        return sum;
    }

    /**
     * выключить в доме ВЕСЬ свет
     *
     * В данном случае instanceof проверяет является ли данный объект
     * экземпляром указанного класса....
     *
     * + данный instanceof создает дополнительную зависимость к Абстрактному классу
     */
    public void switchOffAllLight() {
        for (_12_5_ElectricDeviceInterface device: devices) {
            if (device instanceof _12_5_LightingDeviceAbstract) {
                device.switchOff();
            }
        }
    }

    private void initLightingDevices() {
        devices.add(new _12_5_Lamp(100));
        devices.add(new _12_5_Lamp(60));
        devices.add(new _12_5_Lamp(40));

        devices.add(new _12_5_Chandelier(100, 4));
        devices.add(new _12_5_Chandelier(400, 10));
        devices.add(new _12_5_Chandelier(250, 5));
        devices.add(new _12_5_Chandelier(120, 3));
    }
}
