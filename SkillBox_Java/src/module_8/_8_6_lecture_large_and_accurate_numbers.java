package module_8;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _8_6_lecture_large_and_accurate_numbers {
    public _8_6_lecture_large_and_accurate_numbers() {
        System.out.println("8.6 - 1");
        double val = 0;
        for (int i = 0; i < 1_000_000; i++) {
            val += 0.1;
        }

        System.out.println(val); // 100000.00000133288
        System.out.println("-");

        /**/

        System.out.println("8.6 - 2");
        long longVal = 1_000_000_000_000L;
        System.out.println(longVal * longVal); // будет переполнение
        System.out.println("-");

        /**/

        System.out.println("8.6 - 3");
        double bigNumber = 829_389_283_018_237L;
        System.out.println(bigNumber + bigNumber);

        BigInteger integer = new BigInteger("829389283018237");
        BigInteger integer2 = new BigInteger("829389283018555");

        integer = integer.add(integer); // складываем
        System.out.println(" +: " + integer);

        integer = integer.multiply(integer); // умножаем
        System.out.println(" *: " + integer);

        integer = integer.divide(integer); // делим
        System.out.println(" /: " + integer);

        integer = integer.subtract(integer); // делим
        System.out.println(" -: " + integer);

        integer = integer.subtract(integer); // сравниваем
        System.out.println(" compare: " + integer.compareTo(integer2));

        integer = integer2.pow(10); // возводим в степень
        System.out.println(" pow: " + integer);
        System.out.println("-");

        /**/

        double val1 = 2.0 - 1.1; // 0.8999999999999999
        BigDecimal val1_1 = new BigDecimal("2.0");
        double val2 = 0.9;
        BigDecimal val2_2 = new BigDecimal("0.9");

        System.out.println("val: " + val1);
        System.out.println("val1_1: " + val1_1);
        System.out.println("val2: " + val2);
        System.out.println("val2_2: " + val2_2);
        System.out.println(val1 == val2); // false
        System.out.println(val1_1 == val2_2); // false
        System.out.println(val1 == val2_2.doubleValue()); // false
        System.out.println(val1_1.doubleValue() - val2_2.doubleValue());
    }
}
