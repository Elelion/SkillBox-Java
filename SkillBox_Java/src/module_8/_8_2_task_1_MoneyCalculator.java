package module_8;
public class _8_2_task_1_MoneyCalculator {
    /**
     * TODO: Задание 8.2 - 1 (лекционное)
     * Напишите метод расчёта количества кассет с деньгами, вставляемых в банкомат
     *
     * В этом задании вам предстоит написать код, который будет рассчитывать
     * количество кассет, необходимых для вставки денег в банкомат. Деньги перед
     * помещением в банкомат упаковывают в пачки по 100 купюр, а пачки — в кассеты.
     * В каждую кассету помещается не более 20-ти пачек. На вход метода должно
     * подаваться количество купюр.
     */

    private static final int BANKNOTES_PER_PACK = 100;
    private static final int PACKS_IN_CASSETTE = 20;

    public static int calculateCassetteCount(int banknoteCount) {
        // если есть остаток, то прибавляем +1 пачку
        int packsCount = banknoteCount / BANKNOTES_PER_PACK +
                (banknoteCount % BANKNOTES_PER_PACK == 0 ? 0 : 1);

        // если есть остаток, то прибавляем +1 кассету
        int cassetteCount = packsCount / PACKS_IN_CASSETTE +
                (packsCount % PACKS_IN_CASSETTE == 0 ? 0 : 1);

        return cassetteCount;
    }
}
