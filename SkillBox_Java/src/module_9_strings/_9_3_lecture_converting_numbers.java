package module_9_strings;

public class _9_3_lecture_converting_numbers {
    public _9_3_lecture_converting_numbers() {
        // преобразования из чисел в строки
        System.out.println("9.3 - 1");
        int age = 30;
        String name = "Ann";

        String personInfo = name + " " + age;

        // НЕ явное преобразование, те когда преобразование происходит автоматич
        System.out.println(personInfo);

        // явное преобразование
        String val = Integer.toString(age);

        Double dbl = 30.0;
        String val2 = dbl.toString();

        String val3 = String.valueOf(val);
        String val4 = String.valueOf(val2);
        String val5 = (String) val;
        System.out.println("-");

        /**/

        // преобразования из строки в число
        System.out.println("9.3 - 2");
        String value = "12391238";
        int count = Integer.parseInt(value);
        System.out.println(count);

        String valueD = "4.13823";
        double countD = Double.parseDouble(valueD);
        System.out.println(countD);
    }
}
