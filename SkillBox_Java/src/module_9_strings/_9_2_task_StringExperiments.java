package module_9_strings;

import java.util.Scanner;

public class _9_2_task_StringExperiments {
    public _9_2_task_StringExperiments() {

//        while (true)
            System.out.print("Введите строку 1 - ");
            String strFirst = new Scanner(System.in).next();

            System.out.print("Введите строку 2 - ");
            String strSecond = new Scanner(System.in).next();

            boolean isEqual = strFirst.equals(strSecond);

            if (isEqual) {
                System.out.println(strFirst + " = " + strSecond);
            } else {
                System.out.println(strFirst + " != " + strSecond);
            }
//        }
    }
}
