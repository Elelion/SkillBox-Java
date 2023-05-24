package module_14_exceptions_debug_test_log._14_3_lecture_types_of_exceptions;

import java.util.Scanner;

public class TypesExceptions {
    private static String addCommand = "add Vasiliy Petrov" +
        "vasiliy.petrov@gmail.com +79998887766";
    private static String commandExamples = "\t" + addCommand + "\n" +
        "\tlist\n\tremove Vasiliy Petrov";
    private static String commandError = "Wrong command! Aviable command examples: \n" +
        commandExamples;
    private static String helpText = "Command examples:\n" + commandExamples;

    public TypesExceptions() {
        String[] names = {"Dmitriy", "Sergey", "Ann"};

        /**
         * try - должен содержать код, который может вызвать ошибки
         *
         * catch - обработчик ошибки , если указать так:
         * catch(Exception ex)
         * {ex.printStackTrace(); ИЛИ System.out.println(ex.getMessage());}
         * то будут отлавливаться все ошибки
         *
         * либо можно указать конкретное отлавливание ошибок, например:
         * catch(ArrayIndexOutOfBoundsException ex) {...}
         *
         * Для просмотра ошибки, используем ex.printStackTrace();
         */
        try {
            // если мы оставим так, то выпадет ошибка
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

            try {
                if (tokens[0].equals("add")) {
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
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
