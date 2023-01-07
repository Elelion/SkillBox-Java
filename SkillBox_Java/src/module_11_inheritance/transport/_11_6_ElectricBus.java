package module_11_inheritance.transport;

// extends - наследование, те мы унаседуем все методы от указанного класса
public class _11_6_ElectricBus extends _11_6_Bus {
    private final double minimalTankFullnessRate;

    // TODO: дописываем это
    private static final double degradationRate = 0.0001;
    private static final double minRateToDegrade = 0.1;

    private static int count;

    /**
     * у класса что наследуется от родителя, ВСЕГДА должен быть конструктор
     * с типом параметра, как и у класса родителя - double consumptionRate
     */
    public _11_6_ElectricBus(double consumptionRate, double minimalTankFullnessRate) {

        // super - конструктор класса родителя
        super(consumptionRate);
        this.minimalTankFullnessRate = minimalTankFullnessRate;
        System.out.println("Constructor: _11_3_lecture_ElectricBus");
        count++;
    }

    /**
     * убираем область видимости, по умолчанию будет зона видимости пакета
     * package-private
     *
     * @Override - это аннатация, нужная для JavaDoc
     */
    @Override
    int powerReserve() {
        double remainingRate = getTankFullnessRate() - minimalTankFullnessRate;

        if (remainingRate <= 0) {
            return 0;
        }

        return (int) (remainingRate / getConsumptionRate());
    }

//    public final void refuel(double tankRate) {
//        System.out.println("Ошибка переопределния");
//    }

    /**
     * @Override - будет ошибка: Method does not override method from its superclass
     * тк переопределять статические методы НЕЛЬЗЯ
     */
    // @Override
    public static int getCount() {
        return count;
    }

    // TODO: дописываем это
    @Override
    public void refuel(double tankRate) {
        // вызываем родительский метод
        super.refuel(tankRate);

        if (tankRate > minRateToDegrade) {
            // consumptionRate - берется из родительского класса
            consumptionRate += degradationRate;
        }
    }
}
