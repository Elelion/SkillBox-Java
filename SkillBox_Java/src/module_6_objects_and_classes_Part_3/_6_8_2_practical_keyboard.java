package module_6_objects_and_classes_Part_3;

public class _6_8_2_practical_keyboard {
    public final _6_8_2_practical_keyboardType type;
    public final boolean illumination;
    public final double weight;

    public _6_8_2_practical_keyboard(_6_8_2_practical_keyboardType type,
        boolean illumination, double weight
    ) {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }

    /**/

    public _6_8_2_practical_keyboard setType(_6_8_2_practical_keyboardType type) {
        return new _6_8_2_practical_keyboard(type, illumination, weight);
    }
    public _6_8_2_practical_keyboard setIllumination(boolean illumination) {
        return new _6_8_2_practical_keyboard(type, illumination, weight);
    }
    public _6_8_2_practical_keyboard setWeight(double weight) {
        return new _6_8_2_practical_keyboard(type, illumination, weight);
    }


    /**/

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "KeyBoard: " + "\n" +
                "тип: " + type + "\n" +
                "подсветка: " + illumination + "\n" +
                "вес: " + weight;
    }
}
