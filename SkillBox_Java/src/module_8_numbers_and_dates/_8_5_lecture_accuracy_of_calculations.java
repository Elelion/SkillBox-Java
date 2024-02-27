package module_8_numbers_and_dates;

public class _8_5_lecture_accuracy_of_calculations {

    public final static double epsilon = 0.000000001;

    public _8_5_lecture_accuracy_of_calculations() {

        System.out.println("8.5 - 1");
        /**
         * точность будет не точной, и результат будет 2.4000000000000004
         */
        double value = 24.0 * 0.1;
        System.out.println(value);
        System.out.println("-");

        /**/

        System.out.println("8.5 - 2");
        /**
         * 0.70000005
         */
        float val = 0.3F + 0.4F;
        System.out.println(val);
        System.out.println("-");

        System.out.println(Math.PI); // 15 знаков
        System.out.println((float) Math.PI); // 7 знаков
        System.out.println("-");

        /**/

        System.out.println("8.5 - 3");
        double val1 = 2.0 - 1.1; // 0.8999999999999999
        double val2 = 0.9;
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val1 == val2); // false

        boolean comparison = Math.abs(val1 - val2) < epsilon;
        System.out.println(comparison); // true
    }
}
