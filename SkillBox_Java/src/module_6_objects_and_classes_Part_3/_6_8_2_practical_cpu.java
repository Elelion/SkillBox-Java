package module_6_objects_and_classes_Part_3;

public class _6_8_2_practical_cpu {
    public final int frequency;
    public final int core;
    public final _6_8_2_practical_cpuManufacturerType manufacturer;
    public final double weight;

    public _6_8_2_practical_cpu(int frequency, int core,
        _6_8_2_practical_cpuManufacturerType manufacturer, double weight
    ) {
        this.frequency = frequency;
        this.core = core;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    /**/

    public _6_8_2_practical_cpu setFrequency(int frequency) {
        return new _6_8_2_practical_cpu(frequency, core, manufacturer, weight);
    }

    public _6_8_2_practical_cpu setCore(int core) {
        return new _6_8_2_practical_cpu(frequency, core, manufacturer, weight);
    }

    public _6_8_2_practical_cpu setManufacturer(_6_8_2_practical_cpuManufacturerType manufacturer) {
        return new _6_8_2_practical_cpu(frequency, core, manufacturer, weight);
    }

    public _6_8_2_practical_cpu setWeight(double weight) {
        return new _6_8_2_practical_cpu(frequency, core, manufacturer, weight);
    }

    /**/

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "CPU: " + "\n" +
                "частота: " + frequency + "\n" +
                "ядер: " + core + "\n" +
                "производитель: " + manufacturer + "\n" +
                "вес: " + weight;
    }
}
