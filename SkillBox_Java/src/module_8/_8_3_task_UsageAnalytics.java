package module_8;

public class _8_3_task_UsageAnalytics {

    /**
     * TODO: Задание 8.3 - 1
     * Задание 1. Найдите и исправьте ошибку в программном коде
     */
    private int visitsCount;

    public _8_3_task_UsageAnalytics() {
        visitsCount = 0;
    }

    public int countVisit() {
        // не верно
        // return visitsCount++;

        /**
         * способ №1:
         * нам нужно - сначала увеличить переменную, а уже потом её вернуть
         */
        // visitsCount++;
        // return visitsCount;

        // способ №2:
        return ++visitsCount;
    }

}
