package module_14_exceptions_debug_test_log;

import java.util.Scanner;

import module_14_exceptions_debug_test_log._14_9_1_practical_ConsoleCustomerList.CustomerStorage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class _14_9_1_practical_main {
    private static final String ADD_COMMAND = "add Василий Петров " +
        "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
        "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
        COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    private static final Logger logger = LogManager.getLogger(_14_9_1_practical_main.class);

    /**/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        System.out.println("Введите команду, например: help");
        logger.log(Level.INFO, "Start of the cycle");

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

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
                logger.log(Level.ERROR, COMMAND_ERROR);
                System.out.println(COMMAND_ERROR);
            }
        }
    }

}
