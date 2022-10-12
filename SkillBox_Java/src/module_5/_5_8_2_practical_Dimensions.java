package module_5;

public class _5_8_2_practical_Dimensions {
    /**
     * TODO: Задание 5.8 - 2
     * Продолжайте работу в проекте Encasulation, в котором вы выполняли
     * предыдущее задание. Создайте в этом проекте иммутабельный класс для
     * хранения информации о грузах, передаваемых в курьерскую службу.
     * Название класса придумайте самостоятельно.
     * - Создайте у класса следующие поля:
     * • габариты;
     * • масса;
     * • адрес доставки;
     * • свойство — можно ли переворачивать;
     * • регистрационный номер (может содержать буквы);
     * • является ли груз хрупким.
     *
     * - Названия полей придумайте самостоятельно таким образом, чтобы по ним
     * было понятно, что в них находится. Типы полей задайте в соответствии
     * с данными, которые в них содержатся.
     *
     * - Габариты — ширина, высота и длина — должны храниться в отдельном
     * иммутабельном классе Dimensions. Создайте класс Dimensions с
     * соответствующими полями и реализуйте в нём метод вычисления объёма
     * груза (название метода придумайте самостоятельно).
     *
     * - Реализуйте в классе методы, дающие возможность изменять адрес доставки,
     * габариты и массу груза без изменения исходного объекта путём создания его
     * копии.
     *
     * - Напишите в методе main класса Main дополнительный код, который будет
     * создавать экземпляр класса (объект) груза и его копии при изменении тех
     * или иный полей. Напишите также код, который позволит проверить, что
     * копирование действительно происходит.
     *
     *
     * Критерии оценки работы
     * - Выполнены все указанные в задании требования по написанию кода в
     * классе для хранения данных о заказе на доставку и классе Dimensions.
     * - Оба реализованных класса являются иммутабельными.
     * - Имена методов соответствуют действиям, которые они выполняют.
     * - Имена и типы переменных соответствуют хранимым в них данным.
     * - Методы, изменяющие адрес доставки, габариты и массу груза, создают
     * копии исходного объекта, а исходный объект при этом остаётся неизменным.
     * - Все методы классов работают без ошибок, код компилируется.
     */

    private final int dimensions; // габариты
    private final int weight; // масса
    private final String address; // адрес доставки;
    private final boolean isProperty; // свойство — можно ли переворачивать;
    private final String registrationNumber; // регистрационный номер
    private final boolean isFragile; // является ли груз хрупким.

    public _5_8_2_practical_Dimensions(int dimensions, int weight, String address,
                                       boolean isProperty, String registrationNumber, boolean isFragile) {
        this.dimensions = dimensions;
        this.weight = weight;
        this.address = address;
        this.isProperty = isProperty;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    /**/

    public int getDimensions() {
        return dimensions;
    }

    public int getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    public boolean isProperty() {
        return isProperty;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public boolean isFragile() {
        return isFragile;
    }

    /**/

    public _5_8_2_practical_Dimensions setDimensions(int dimensions) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
            isProperty, registrationNumber, isFragile);
    }

    public _5_8_2_practical_Dimensions setWeight(int weight) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
                isProperty, registrationNumber, isFragile);
    }

    public _5_8_2_practical_Dimensions setAddress(String address) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
                isProperty, registrationNumber, isFragile);
    }

    public _5_8_2_practical_Dimensions setProperty(boolean isProperty) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
                isProperty, registrationNumber, isFragile);
    }

    public _5_8_2_practical_Dimensions setRegistrationNumber(String registrationNumber) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
                isProperty, registrationNumber, isFragile);
    }

    public _5_8_2_practical_Dimensions setFragile(boolean isFragile) {
        return new _5_8_2_practical_Dimensions(dimensions, weight, address,
                isProperty, registrationNumber, isFragile);
    }

    /**/

    public String toString() {
        return dimensions + " габариты \n" +
            weight + " масса \n" +
            address + " адрес доставки \n" +
            isProperty + " свойство \n" +
            registrationNumber  + " регистрационный номер \n" +
            isFragile + " хрупкий";
    }
}
