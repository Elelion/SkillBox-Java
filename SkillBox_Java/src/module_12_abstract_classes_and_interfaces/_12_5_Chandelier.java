package module_12_abstract_classes_and_interfaces;

public class _12_5_Chandelier extends _12_5_LightingDeviceAbstract {
    private static final int LAMP_BRIGHTNESS_STEP = 2;
    private static final double CONSUMPTION_COEFFICIENT = 1.095;

    private final int lampsCount;

    /**/

    public _12_5_Chandelier(int power, int lampsCount) {
        super(power);
        this.lampsCount = lampsCount;
    }

    @Override
    public void setBrightness(double level) {
        double step = 1.0 / (lampsCount * LAMP_BRIGHTNESS_STEP);
        int stepCount = (int) Math.round(level / step);

        super.setBrightness(stepCount * step);
    }

    @Override
    public double getEnergyConsumption() {
        return power * Math.pow(brightness, CONSUMPTION_COEFFICIENT);
    }
}
