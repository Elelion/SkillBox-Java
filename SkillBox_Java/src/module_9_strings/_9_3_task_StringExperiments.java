package module_9_strings;

import java.util.Scanner;

public class _9_3_task_StringExperiments {
    public _9_3_task_StringExperiments() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку 1 - ");
        String strFst = scanner.nextLine();

        System.out.print("Введите строку 2 (действие) - ");
        String mathSymbol = scanner.nextLine();

        System.out.print("Введите строку 3 - ");
        String strThd = scanner.nextLine();

        int result;

        switch (mathSymbol) {
            case "+" -> result = Integer.parseInt(strFst) + Integer.parseInt(strThd);
            case "-" -> result = Integer.parseInt(strFst) - Integer.parseInt(strThd);
            case "*" -> result = Integer.parseInt(strFst) * Integer.parseInt(strThd);
            case "/" -> result = Integer.parseInt(strFst) / Integer.parseInt(strThd);
            default -> throw new IllegalStateException("Unexpected value: " + mathSymbol);
        }

        System.out.println("sum: " + result);
    }
}
