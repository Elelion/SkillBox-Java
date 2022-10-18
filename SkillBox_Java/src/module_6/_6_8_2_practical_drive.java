package module_6;

public class _6_8_2_practical_drive {
    public final _6_8_2_practical_driveType type;
    public final int volume;
    public final double weight;

    public _6_8_2_practical_drive(_6_8_2_practical_driveType type, int volume,
        double weight
    ) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    /**/

    public _6_8_2_practical_drive setType(_6_8_2_practical_driveType type) {
        return new _6_8_2_practical_drive(type, volume, weight);
    }

    public _6_8_2_practical_drive setVolume(int volume) {
        return new _6_8_2_practical_drive(type, volume, weight);
    }

    public _6_8_2_practical_drive setWeight(double weight) {
        return new _6_8_2_practical_drive(type, volume, weight);
    }

    /**/

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "Drive: " + "\n" +
                "тип: " + type + "\n" +
                "объем: " + volume + "\n" +
                "вес: " + weight;
    }
}
