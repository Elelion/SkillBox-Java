package module_8;

import java.util.Random;

public class _8_2_lecture_operations_with_numbers {
    public _8_2_lecture_operations_with_numbers() {
        double valueD = 5.0 / 2;
        int valueI = 5 / 2;
        System.out.println(valueD);
        System.out.println(valueI);

        /**/

        /**
         * остаток от диления (mod). Если 0 - то делиться без остатка
         * если остаток остается, то выводиться первое остаточное число от
         * деления, те как раньше мы делили в столбик, нули НЕ приписываются
         */
        double mod = 23 % 4; // 10 % 2
        System.out.println(mod);

        /**/

        int val = 55;
        val %= 49;
        System.out.println(val); // остаток от деления будет 55 / 49 = 6

        /**/

        /**
         * вычислить абсолютное число по модулю, те инвертирует знак
         * c отрицаетльного числа на положительное, если было положительное
         * то оно НЕ измениться
         */
        System.out.println(Math.abs(-46555));

        System.out.println(Math.max(5, 7));

        System.out.println(Math.sqrt(625));

        System.out.println(Math.random()); // 0 - 0.9999...
        System.out.println(Math.round(Math.random())); // 0 - 1

        Double rand = Math.random() * 100;
        System.out.println(rand.intValue()); // 0 - 100

        System.out.println(new Random().nextInt(50)); // 0 - 50

        System.out.println(Math.round(2.54)); // в большую сторону округлит
    }
}
