package module_12_abstract_classes_and_interfaces;

public class _12_3_Chandelier extends _12_2_LightingDeviceAbstract {
//    public static final double MAX_BRIGHTNESS = 1D;
//    public static final double MIN_BRIGHTNESS = 0D;

    private static final int LAMP_BRIGHTNESS_STEP = 2;
    private static final double CONSUMPTION_COEFFICIENT = 1.095;

//    private final int power;
    private final int lampsCount;
//    private double brightness;

    /**/

    public _12_3_Chandelier(int power, int lampsCount) {
        super(power);

//        this.power = power;
        this.lampsCount = lampsCount;
    }

    @Override
    public void setBrightness(double level) {
//        if (level < MIN_BRIGHTNESS) {
//            brightness = MIN_BRIGHTNESS;
//        } else if (level > MAX_BRIGHTNESS){
//            brightness = MAX_BRIGHTNESS;
//        } else {
            double step = 1.0 / (lampsCount * LAMP_BRIGHTNESS_STEP);
            int stepCount = (int) Math.round(level / step);
//            brightness = stepCount * step;
//        }

        super.setBrightness(stepCount * step);
    }

//    public double getBrightness() {
//        return brightness;
//    }

//    public void changeBrightness(double rate) {
//        double changed = brightness + brightness * rate;
//        setBrightness(changed);
//    }

    @Override
    public double getEnergyConsumption() {
        return power * Math.pow(brightness, CONSUMPTION_COEFFICIENT);
    }
}
