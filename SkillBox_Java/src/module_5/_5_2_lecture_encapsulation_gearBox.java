package module_5;

public class _5_2_lecture_encapsulation_gearBox {
    /**
     * 0 - neutral
     * -1 - rear
     * 1-6
     */

    /**
     * private - делаем видимость переменныз только в нутри данного класса
     * те из вне уже они видны НЕ будут
     */
    private final int MAX_GEAR = 6;
    private final int MIN_GEAR = 1;
    private int gear = 0;

    public void shiftUp() {
        // проверка что бы выше 6ой скорости коробка не переключала
        gear = gear < MAX_GEAR ? gear + 1 : gear;
    }

    public void shiftDown() {
        gear = gear > MIN_GEAR ? gear - 1 : gear;
    }

    public void switchRear() {
        gear = gear > 1 ? gear : -1;
    }

    public void switchNeutral() {
        gear = 0;
    }

    public int getCurrentGear() {
        return gear;
    }
}
