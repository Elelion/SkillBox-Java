package module_12_abstract_classes_and_interfaces;

import java.lang.reflect.Constructor;

public class _12_6_Chandelier extends _12_6_LightingDeviceAbstract {
    private static final int LAMP_BRIGHTNESS_STEP = 2;
    private static final double CONSUMPTION_COEFFICIENT = 1.095;

    private final int lampsCount;

    /**/

    // внутренние НЕ статические классы
//    private Controller controller;

//    private class Controller {
//        public void reset() {
//             some logic...
//        }
//    }

    public _12_6_Chandelier(int power, int lampsCount) {
        super(power);
        this.lampsCount = lampsCount;
//        controller = new Controller();
    }

    @Override
    public void setBrightness(double level) {
        double step = 1.0 / (lampsCount * LAMP_BRIGHTNESS_STEP);
        int stepCount = (int) Math.round(level / step);

        super.setBrightness(stepCount * step);


        // локальный внутренний класс...
        // обязательно должен быть выше, кода где new...
        class Controller {
            public Controller() {
                // connect...
            }
            public void reset() {
                // some logic...
            }
        }

        if (brightness == 0) {
            Controller controller = new Controller();
            controller.reset();
        }
    }

    @Override
    public double getEnergyConsumption() {
        return power * Math.pow(brightness, CONSUMPTION_COEFFICIENT);
    }
}
