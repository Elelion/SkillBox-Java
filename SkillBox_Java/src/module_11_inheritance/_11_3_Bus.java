package module_11_inheritance;

public class _11_3_Bus {
    private double tankFullnessRate; // rate of tank fullness, 0-1
    private final double consumptionRate; // rate (0-1) per 1 km

    private static int count;

    public _11_3_Bus(double consumptionRate) {
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
}
