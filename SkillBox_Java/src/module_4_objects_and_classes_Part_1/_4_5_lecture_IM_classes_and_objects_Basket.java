package module_4_objects_and_classes_Part_1;

public class _4_5_lecture_IM_classes_and_objects_Basket {

    /**
     * TODO: Задача 4.5 - 1
     *
     */

    public String items = "";
    public int totalPrice = 0;

    public void main(String[] args) {

    }

    public void add(String name, int price) {
        /**
         * проверяем есть ли уже такой товар в корзине или нет
         * если он есть, те containsString вернет true, то выполнение
         * этого метода завершиться, а если вернет false, то добавиться
         */
        if (containsString(name)) {
            return;
        }

        items = items + "\n" + name +  " - " + price;
        totalPrice += price;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    /**
     * return - так же приводит к завершению работы метода
     * сли после него написать какой то код, то он не будет выполняться
     */
    public int getTotalPrice() {
        return totalPrice;
    }

    // Домашка №1
    public int calculateSum(int a, int b, int c) {
        return a + b + c;
    }

    // Домашка №2
    public int max(int a, int b) {
        // аналогично: return a >= b ? a : b;
        return Math.max(a, b);

    }

    public boolean containsString(String name) {

        // закоментированная запись аналогична записи ниже
        /*
        if (items.contains(name)) {
            return true;
        }

        return false;
        */

        /**
         * contains - метод чтобы проверить, содержит ли String указанную
         * последовательность символов. Этот метод возвращает логический
         * тип данных, который является результатом тестирования, если строка
         * содержит символы, указанные в аргументе метода в типе объекта
         * CharSequence. Метод contains() возвращает true тогда и только тогда,
         * когда эта строка содержит указанную последовательность значений char.
         */

        /**
         * те мы проверяем в нашем items значения которые уже есть
         * со значением которые мы зададим в name
         */
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);

        //  проверяем пустая ли строка или нет
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
