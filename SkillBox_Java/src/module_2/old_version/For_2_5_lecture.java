package module_2;

public class For_2_5_lecture {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        // for (int age = 15; age < 40; age++) {
        //  за место for мы можем написать while, но в данном случае лучше for
        int age = 15;
        while (age < 40) { // выполнять код до тех пор, пока ...
            System.out.print(age + " лет, вы можете: ");

            if (age > 16 && age < 18 ) {
                System.out.print("иметь ученические права");
            } else if (age >= 18) {
                System.out.print("иметь обычные права");
            } else {
                System.out.print("жить обычной жизнью");
            }

            if (age >= 35) {
                System.out.print(", вы можете балотироваться в презеденты");
            }

            System.out.println();

            // для while
            age++;
        }

        // Пример бесконечного цикла
        // for (int i = 0; ; i++) {...}

        // Пример только условия (так то же не пишут)
        // int i = 5;
        // for (; i < 10;) {...}
    }
}
