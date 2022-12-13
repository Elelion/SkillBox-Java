package module_11_inheritance;

public class _11_2_Bus {
    private double tankFullnessRate; // rate of tank fullness, 0-1
    private final double consumptionRate; // rate (0-1) per 1 km

    public _11_2_Bus(double consumptionRate) {
        this.consumptionRate = consumptionRate;
        System.out.println("Constructor: _11_2_lecture_Bus");
    }

    public boolean run(int distance) {
        if (powerReserve() < distance) {
            return false;
        }

        tankFullnessRate -= distance * consumptionRate;
        return true;
    }

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
}
