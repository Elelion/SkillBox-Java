package module_7;

public class _7_7_lecture_boxing_unboxing {

    public static int MAX_AGE = 6;

    public _7_7_lecture_boxing_unboxing() {
        /**
         * Классы обертки - это просто классы в которых содержаться примитивы
         *
         * те Обертка — это специальный класс, который хранит внутри себя
         * значение примитива.
         *
         * int -> Integer
         * short -> Short
         * long -> Long
         * byte -> Byte
         * float -> Float
         * double -> Double
         * char -> Character
         * boolean -> Boolean
         */
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.NEGATIVE_INFINITY); // положительная бесконечность
        System.out.println(Double.POSITIVE_INFINITY); // отрицательная бесконечность
        System.out.println("---");

        /**/

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println("---");

        /**/

        // Boxing
        Integer vasyaAge = 6;
        Integer mishaAge = vasyaAge;
        // vasyaAge = 7; // создаться ноый объект и при сравнении ниже будет false
        System.out.println(vasyaAge == mishaAge); // true

        Integer test = new Integer(555);
        System.out.println(test); // 555
        System.out.println("---");

        /**/

        // UnBoxing
        Integer vlad = 5;

        /**
         * в данном случае, класс обертки будет автоматически распакован и
         * преобразован в примитив int
         */
        if (vlad <= MAX_AGE) {
            System.out.println("Влад может играть в эту игру");
        }
    }
}
