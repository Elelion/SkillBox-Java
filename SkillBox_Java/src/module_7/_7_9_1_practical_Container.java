package module_7;

public class _7_9_1_practical_Container {

    /**
     * TODO: Задание 7.9 - 1
     * - Запустите код проекта IntOrInteger, найдите ошибку и исправьте класс
     * Container таким образом, чтобы ошибка не возникала.
     *
     * Что оценивается
     * - Понимание отличий примитивов от объектов и исправление ошибки с
     * учётом этого понимания.
     */

    /**
     * потому что у примитива(int) значение по-умолчанию 0.
     * А у "обертки"(Integer) - null.
     * А null нельзя присвоить примитиву
     */
    private Integer count = 0;

    public void addCount(int value) {
        count += count + value;
    }

    public int getCount() {
        return count;
    }

}
