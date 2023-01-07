package module_11_inheritance;

import java.util.Objects;

public class _11_5_Bus {
    private double tankFullnessRate; // rate of tank fullness, 0-1
    private final double consumptionRate; // rate (0-1) per 1 km

    private static int count;

    public _11_5_Bus(double consumptionRate) {
        this.consumptionRate = consumptionRate;
        System.out.println("Constructor: _11_3_lecture_Bus");

        count++;
    }

    public boolean run(int distance) {
        if (powerReserve() < distance) {
            return false;
        }

        tankFullnessRate -= distance * consumptionRate;
        return true;
    }

    // final - служит для защиты от override
    public final void refuel(double tankRate) {
        double total = tankFullnessRate + tankRate;
        tankFullnessRate = total > 1 ? 1 : total;
    }

    public int powerReserve() {
        return (int) (tankFullnessRate / consumptionRate);
    }

    public double getConsumptionRate() {
        return consumptionRate;
    }

    public double getTankFullnessRate() {
        return tankFullnessRate;
    }

    public static int getCount() {
        return count;
    }

    /**/

    /**
     * при написании equals и нажатии на tab, IDE предложит создать стандартный
     * метод equals, где так же будет создан и метод hashCode
     *
     * hashCode - сверяет хеш-код объектов, и если он разный, то объекты разные
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        _11_5_Bus bus = (_11_5_Bus) o;
        return Double.compare(bus.tankFullnessRate, tankFullnessRate) == 0 && Double.compare(bus.consumptionRate, consumptionRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tankFullnessRate, consumptionRate);
    }

    /**
     * возвращает строковое представление объекта
     */
    @Override
    public String toString() {
        return "_11_4_Bus{" +
            "tankFullnessRate=" + tankFullnessRate +
            ", consumptionRate=" + consumptionRate +
            '}';
    }
}
