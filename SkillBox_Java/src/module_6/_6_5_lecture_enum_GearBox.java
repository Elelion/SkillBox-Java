package module_6;

public class _6_5_lecture_enum_GearBox {
    /**
     * 0 - neutral
     * -1 - rear
     * 1-6
     */

    /**
     * public - делаем видимость переменных что бы можо было вообще посмотреть
     * что эти переменные есть, хотя они и константы
     * по этому не чего страшного не будет
     */
    public final int MAX_GEAR = 6;
    public final int MIN_GEAR = 1;
    private int gear = 0;

    // enum
    public final _6_5_lecture_GearBoxTypeEnum type;

    public _6_5_lecture_enum_GearBox(_6_5_lecture_GearBoxTypeEnum type) {
        this.type = type;
    }

    public _6_5_lecture_GearBoxTypeEnum getType() {
        return type;
    }

    /**/

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
