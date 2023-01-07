package module_14_exceptions_debug_test_log._14_4_lecture_debugging_applications;

import java.util.Scanner;

public class Debugging {
    private static String addCommand = "add Vasiliy Petrov" +
        "vasiliy.petrov@gmail.com +79998887766";
    private static String commandExamples = "\t" + addCommand + "\n" +
        "\tlist\n\tremove Vasiliy Petrov";
    private static String commandError = "Wrong command! Aviable command examples: \n" +
        commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public Debugging() {
        String[] names = {"Dmitriy", "Sergey", "Ann"};


        try {
            System.out.println(names[4]);
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.out.println("catch error!");
            System.out.println(ex.getMessage());
        }


        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        for (;;) {
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

//            try {
                if (tokens[0].equals("add")) {

                    /**
                     * ставим BreakPoint на против этой строки
                     * и далее запускаем программу в режиме отладки - как это сделать ?
                     * - кликаем на _14_main.java - ПКМ - Debug...
                     * или
                     * - ctrl + d
                     */
                    executor.addCustomer(tokens[1]);

                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                } else {
                    System.out.println(commandError);
                }
//            } catch (IllegalArgumentException ex) {
//                System.out.println(ex.getMessage());
//            }
        }
    }
}
