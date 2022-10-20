package module_6;

public class _6_8_2_practical_ram {
    public final _6_8_2_practical_ramType type;
    public final int volume;
    public final double weight;

    public _6_8_2_practical_ram(_6_8_2_practical_ramType type, int volume,
        double weight
    ) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    /**/

    public _6_8_2_practical_ram setType(_6_8_2_practical_ramType type) {
        return new _6_8_2_practical_ram(type, volume, weight);
    }

    public _6_8_2_practical_ram setVolume(int volume) {
        return new _6_8_2_practical_ram(type, volume, weight);
    }

    public _6_8_2_practical_ram setWeight(double weight) {
        return new _6_8_2_practical_ram(type, volume, weight);
    }

    /**/

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "RAM: " + "\n" +
                "тип: " + type + "\n" +
                "объем: " + volume + "\n" +
                "вес: " + weight;
    }
}
