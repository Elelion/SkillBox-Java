package module_5;

public class _5_8_2_practical_Dimensions {
    /**
     * TODO: Задание 5.8 - 2
     * - Габариты — ширина, высота и длина — должны храниться в отдельном
     * иммутабельном классе Dimensions. Создайте класс Dimensions с
     * соответствующими полями и реализуйте в нём метод вычисления объёма
     * груза (название метода придумайте самостоятельно).
     */

    /**
     * FIXME: Правки
     * По второму заданию – посмотри внимательнее задание, должно быть два
     * класса – Dimensions (габариты) и Cargo (информация о доставке).
     * Внутри Cargo нужно использовать Dimensions.
     */

    private final int widthSize;
    private final int heightSize;
    private final int longSize;
    private int quantity;

    public _5_8_2_practical_Dimensions(int widthSize, int heightSize, int longSize, int quantity) {
        this.widthSize = widthSize;
        this.heightSize = heightSize;
        this.longSize = longSize;
        this.quantity = quantity;

        System.out.println("Кол-во груза: " + this.quantity);
        System.out.println("Объем груза равен: " + getCalcVolume());
    }

    /**/

    public _5_8_2_practical_Dimensions setWidthSize(int widthSize) {
        return new _5_8_2_practical_Dimensions(widthSize, heightSize, longSize, quantity);
    }

    public _5_8_2_practical_Dimensions setHeightSize(int heightSize) {
        return new _5_8_2_practical_Dimensions(widthSize, heightSize, longSize, quantity);
    }

    public _5_8_2_practical_Dimensions setLongSize(int longSize) {
        return new _5_8_2_practical_Dimensions(widthSize, heightSize, longSize, quantity);
    }

    /**/

    private int getCalcVolume() {
        return (widthSize * heightSize * longSize) * quantity;
    }
}
