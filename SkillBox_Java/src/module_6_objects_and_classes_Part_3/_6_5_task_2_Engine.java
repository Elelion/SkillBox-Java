package module_6_objects_and_classes_Part_3;

public class _6_5_task_2_Engine {
    private final _6_5_task_2_EngineType type;
    private final double volume;
    private final int power;

    public _6_5_task_2_Engine(_6_5_task_2_EngineType type, double volume, int power) {
        this.type = type;
        this.volume = volume;
        this.power = power;
    }

    public _6_5_task_2_EngineType getType() {
        return type;
    }

    public double getVolume() {
        return volume;
    }

    public int getPower() {
        return power;
    }
}
