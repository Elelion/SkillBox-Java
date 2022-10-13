package module_5;

public class _5_8_2_practical_Cargo {
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

    /**
     * FIXME: Правки
     * По второму заданию – посмотри внимательнее задание, должно быть два
     * класса – Dimensions (габариты) и Cargo (информация о доставке).
     * Внутри Cargo нужно использовать Dimensions.
     */

    private final int weight; // масса
    private final String address; // адрес доставки;
    private final boolean isProperty; // свойство — можно ли переворачивать;
    private final String registrationNumber; // регистрационный номер
    private final boolean isFragile; // является ли груз хрупким.

    public _5_8_2_practical_Cargo(int weight, String address, boolean isProperty,
        String registrationNumber, boolean isFragile
    ) {
        this.weight = weight;
        this.address = address;
        this.isProperty = isProperty;
        this.registrationNumber = registrationNumber;
        this.isFragile = isFragile;
    }

    /**/

    public _5_8_2_practical_Cargo setWeight(int weight) {
        return new _5_8_2_practical_Cargo(weight, address, isProperty,
            registrationNumber, isFragile);
    }

    public _5_8_2_practical_Cargo setAddress(String address) {
        return new _5_8_2_practical_Cargo(weight, address, isProperty,
            registrationNumber, isFragile);
    }

    public _5_8_2_practical_Cargo setProperty(boolean isProperty) {
        return new _5_8_2_practical_Cargo(weight, address, isProperty,
            registrationNumber, isFragile);
    }

    public _5_8_2_practical_Cargo setRegistrationNumber(String registrationNumber) {
        return new _5_8_2_practical_Cargo(weight, address, isProperty,
            registrationNumber, isFragile);
    }

    public _5_8_2_practical_Cargo setFragile(boolean isFragile) {
        return new _5_8_2_practical_Cargo(weight, address, isProperty,
            registrationNumber, isFragile);
    }

    /**/

    public _5_8_2_practical_Dimensions setDimension(int widthSize, int heightSize, int longSize, int quantity) {
        return new _5_8_2_practical_Dimensions(widthSize, heightSize, longSize, quantity);
    }

    public String toString() {
        return weight + " масса \n" +
            address + " адрес доставки \n" +
            isProperty + " свойство \n" +
            registrationNumber  + " регистрационный номер \n" +
            isFragile + " хрупкий";
    }
}
