package module_6;

public class _6_5_lecture_DeliveryOrder {
    /**
     * isPedestrian - доставка на магине или велосипедом
     * isFragile - хрепкий
     * isCold - нужно ли охлаждать
     */

    /**
     * часто применяется enum для того что бы не писать еще и вот так, тк
     * не во всех редакторах подсвечиается название полей
     */
    // public _6_5_lecture_DeliveryOrder(boolean isPedestrian, boolean isFragile, boolean isCold) {
        // _6_5_lecture_DeliveryOrder order = new _6_5_lecture_DeliveryOrder(true, false, true);


    public _6_5_lecture_DeliveryOrder(
            _6_5_lecture_enum_DeliveryType pedestrian,
            _6_5_lecture_enum_Fragile fragile,
            _6_5_lecture_enum_Cold cold
    ) {
        _6_5_lecture_DeliveryOrder order = new _6_5_lecture_DeliveryOrder(
                _6_5_lecture_enum_DeliveryType.PEDESTRIAN,
                _6_5_lecture_enum_Fragile.NO,
                _6_5_lecture_enum_Cold.YES
        );
    }
}
