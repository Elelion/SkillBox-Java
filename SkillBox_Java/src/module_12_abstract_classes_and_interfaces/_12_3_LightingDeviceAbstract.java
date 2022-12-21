package module_12_abstract_classes_and_interfaces;

/**
 * Абстрактный класс откличается от интерфейсов тем, что в нем может
 * содержаться и реализация методов, в то время как у интерфейсов
 * описывается лишь описание методов
 */
public abstract class _12_3_LightingDeviceAbstract implements _12_3_ElectricDeviceInterface {
    public static final double MAX_BRIGHTNESS = 1D;
    public static final double MIN_BRIGHTNESS = 0D;

    protected final int power;
    protected double brightness;

    /**/

    public _12_3_LightingDeviceAbstract(int power) {
        this.power = power;
    }

    public void setBrightness(double level) {
        if (level < MIN_BRIGHTNESS) {
            brightness = MIN_BRIGHTNESS;
        } else if (level > MAX_BRIGHTNESS){
            brightness = MAX_BRIGHTNESS;
        } else {
            brightness = level;
        }
    }

    public double getBrightness() {
        return brightness;
    }

    public void changeBrightness(double rate) {
        double changed = brightness + brightness * rate;
        setBrightness(changed);
    }

    /**/

    @Override
    public void switchOn() {
        setBrightness(MAX_BRIGHTNESS);
    }

    @Override
    public void switchOff() {
        setBrightness(MIN_BRIGHTNESS);
    }

    @Override
    public boolean isSwitchedOn() {
        return brightness > 0;
    }

    /**
     * убираем, тк этот метод есть в интерфейсе, и его не обходимо
     * будет реализовать в дочерних классах
     */
//    public abstract double getEnergyConsumption();
}
