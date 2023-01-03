package module_9_strings;

import module_5_objects_and_classes_Part_2._5_4_lecture_product;

import java.time.LocalDate;

public class _9_2_lecture_strings_concatenation_and_comparison {
    public _9_2_lecture_strings_concatenation_and_comparison() {
        System.out.println("9.2 - 1");
        String empty = "";

        // проверить на пустоту можно так (но это плохой способ)
        boolean isEmpty = empty.length() == 0;
        System.out.println(isEmpty);

        // а вот актуальный способ проверки на пустоту строки
        System.out.println(empty.isEmpty());
        System.out.println("-");

        /**/

        System.out.println("9.2 - 2");
        String blank = "    \t     \n";

        // проверить на отступы и переходы
        System.out.println("isBlank: " + blank.isBlank());
        System.out.println("-");

        /**/

        System.out.println("9.2 - 3");
        String name = "Alex";
        String surName = "Labs";
        LocalDate birthday = LocalDate.of(1980, 4, 14);

        String fullName = name + " " + surName + " - " + birthday;
        System.out.println(fullName);
        System.out.println("-");

        /**/

        System.out.println("9.2 - 4");
        _5_4_lecture_product prod = new _5_4_lecture_product("мыло", 100, "FF339d");
        String productInfo = "Иформация о продукте: " + prod;
        System.out.println(productInfo);

        String goods = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            goods += prod + System.lineSeparator();
        }

        /**
         * те при множественной контетинации программа может начать
         * работать медленнее
         * тк при каждом добавлении выделяется новая область памяти из за того
         * что объект String иммутабелен
         *
         * выход из ситуации использовать StringBuilder
         */
        System.out.println(System.currentTimeMillis() - start); // ~будет 5 сек
        System.out.println("length: " + goods.length());
        System.out.println("-");

        /**/

        // способ №1
        System.out.println("9.2 - 5");
        StringBuilder goodsBuilder = new StringBuilder();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            goodsBuilder.append(prod).append(System.lineSeparator());
        }
        System.out.println(System.currentTimeMillis() - start2); // ~будет 5 сек
        System.out.println("length: " + goodsBuilder.length());
        System.out.println("-");

        /**/

        // способ №2
        System.out.println("9.2 - 6");
        _5_4_lecture_product prod2 = new _5_4_lecture_product("мыло", 100, "FF339d");
        String allGoods = "";
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++) {
            // allGoods += prod2; // >10 сек
            allGoods = allGoods.concat(prod2 + System.lineSeparator());
        }
        System.out.println(System.currentTimeMillis() - start3); // ~будет 5 сек
        System.out.println("length: " + allGoods.length());
        System.out.println("-");
    }
}
