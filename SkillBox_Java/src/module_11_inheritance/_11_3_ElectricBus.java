package module_11_inheritance;

// extends - наследование, те мы унаседуем все методы от указанного класса
public class _11_3_ElectricBus extends _11_3_Bus {
    private final double minimalTankFullnessRate;

    private static int count;

    /**
     * у класса что наследуется от родителя, ВСЕГДА должен быть конструктор
     * с типом параметра, как и у класса родителя - double consumptionRate
     */
    public _11_3_ElectricBus(double consumptionRate, double minimalTankFullnessRate) {

        // super - конструктор класса родителя
        super(consumptionRate);
        this.minimalTankFullnessRate = minimalTankFullnessRate;
        System.out.println("Constructor: _11_3_lecture_ElectricBus");
        count++;
    }

    // @Override - это аннатация, нужная для JavaDoc
    @Override
    public int powerReserve() {
        double remainingRate = getTankFullnessRate() - minimalTankFullnessRate;

        if (remainingRate <= 0) {
            return 0;
        }

        return (int) (remainingRate / getConsumptionRate());
//        return super.powerReserve();
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
}
