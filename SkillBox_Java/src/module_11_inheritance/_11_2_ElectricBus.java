package module_11_inheritance;

// extends - наследование, те мы унаседуем все методы от указанного класса
public class _11_2_ElectricBus extends _11_2_Bus {
    private final double minimalTankFullnessRate;

    /**
     * у класса что наследуется от родителя, ВСЕГДА должен быть конструктор
     * с типом параметра, как и у класса родителя - double consumptionRate
     */
    public _11_2_ElectricBus(double consumptionRate, double minimalTankFullnessRate) {

        // super - конструктор класса родителя
        super(consumptionRate);
        this.minimalTankFullnessRate = minimalTankFullnessRate;
        System.out.println("Constructor: _11_2_lecture_ElectricBus");
    }
}
