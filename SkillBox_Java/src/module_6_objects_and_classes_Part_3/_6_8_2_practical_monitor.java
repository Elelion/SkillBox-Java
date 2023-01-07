package module_6_objects_and_classes_Part_3;

public class _6_8_2_practical_monitor {
    public final double size;
    public final _6_8_2_practical_monitorType type;
    public final double weight;

    public _6_8_2_practical_monitor(double size,
        _6_8_2_practical_monitorType type, double weight
    ) {
        this.size = size;
        this.type = type;
        this.weight = weight;
    }

    /**/

    public _6_8_2_practical_monitor setSize(double size) {
        return new _6_8_2_practical_monitor(size, type, weight);
    }

    public _6_8_2_practical_monitor setType(_6_8_2_practical_monitorType type) {
        return new _6_8_2_practical_monitor(size, type, weight);
    }

    public _6_8_2_practical_monitor setWeight(double weight) {
        return new _6_8_2_practical_monitor(size, type, weight);
    }

    /**/

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Monitor: " + "\n" +
                "диагональ: " + size + "\n" +
                "тип матрици: " + type + "\n" +
                "вес: " + weight;
    }
}
