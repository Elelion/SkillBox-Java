package module_17_multithreading._17_13_practical_Transactions;

import module_17_multithreading._17_7_lecture_volatile.Volatile;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Transactions implements RandomAmount, FormatNumber {
    private ConcurrentHashMap<String, Account> accounts;
    private ConcurrentHashMap<String, Account> accountsBlocked;
    private Bank bank = new Bank();

    public Transactions()  {
        int dealAccounts = 10;
        AtomicInteger count = new AtomicInteger();

        bank.addAccounts(dealAccounts);
        accounts = bank.getAccounts();

        // выводим для наглядной проверки баланс 1го аккаунта
        consoleColorLog("Get account balance (№1): " + bank.getBalance("1"));

        for (int i = 1; i <= dealAccounts; i++) {
            String fromAccountNum = Integer.toString(getRandomAmount(1, dealAccounts));
            String toAccountNum = Integer.toString(getRandomAmount(1, dealAccounts));

            new Thread(() -> {
                try {
                    // проводим транзакцию
                    bank.transfer(
                        accounts.get(fromAccountNum).getAccNumber(),
                        accounts.get(toAccountNum).getAccNumber(),
                        getRandomAmount(15_000, 65_000)
                    );

                    // считаем сколько транзакций было сделано потоками
                    count.getAndIncrement();

                    // выводим доп данные об аккаунтах
                    if (count.get() == dealAccounts) {
                        printDetails();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }

    /**/

    private void printDetails() {
        accountsBlocked = bank.getAccountsBlocked();

        // выводим заблокированные аккаунты
        printBlockAccounts();

        // выводим баланс аккаунтов
        printBalanceEveryAccounts();

        // выводим баланс ВСЕХ аккаунтов
        printBalanceAllAccounts();
    }

    private void printBlockAccounts() {
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        consoleColorLog("Blocked accounts:");

        for (Map.Entry<String, Account> entry : accountsBlocked.entrySet()) {
            String key = entry.getKey();
            Account value = entry.getValue();

            System.out.println(key + " - " + convertFormatNumber(value.getMoney()));
        }
    }

    private void printBalanceEveryAccounts() {
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        consoleColorLog("Get account balance:");
        for (Map.Entry<String, Account> entry : accounts.entrySet()) {
            String key = entry.getKey();
            Account value = entry.getValue();

            System.out.println(key + " - " + convertFormatNumber(value.getMoney()));
        }
    }

    private void printBalanceAllAccounts() {
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        consoleColorLog("Get account ALL balance:");
        System.out.println(convertFormatNumber(bank.getSumAllAccounts()));
    }

    /**/

    private void consoleColorLog(String str) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }

}
