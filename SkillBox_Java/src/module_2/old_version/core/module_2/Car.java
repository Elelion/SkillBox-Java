package core.module_2;

public class Car {
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    /**
     * Часто необходимо узнать содержимое того или иного объекта.
     * Для этого в классе Object языка Java определен специальный
     * метод toString(), возвращающий символьную строку описывающую объект.
     * При создании нового класса принято переопределение  toString()
     * таким образом, чтобы возвращающая строка содержала в себе имя класса,
     * имена и значения всех переменных.
     */
    public String toString() {
        // если isSpecial == true, то СПЕЦТРАНСПОРТ, если false, то ПУСТО
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";

        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}
