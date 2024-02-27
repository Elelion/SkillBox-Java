package module_17_multithreading._17_13_practical_Transactions;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Bank implements RandomAmount, FormatNumber {
    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Account> accountsBlocked = new ConcurrentHashMap<>();
    private final Random RANDOM = new Random();
    private final int AMOUNT_BLOCKING = 50_000;
    private boolean block = true;
    private int accountsTotalSum = 0;

    /**/

    public synchronized boolean isFraud() throws InterruptedException {
        Thread.sleep(100);

        synchronized (this) {
            return RANDOM.nextBoolean();
        }
    }

    /**
     * TODO:
     * Реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции, она
     * отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(
        String fromAccountNum,
        String toAccountNum,
        int amount
    ) throws InterruptedException {

        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        block = isFraud();

        System.out.println("-");

        if (fromAccountNum.compareTo(toAccountNum) > 0) {
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    transferMoney(fromAccount, toAccount, amount);
                }
            }
        } else {
            synchronized (toAccount) {
                synchronized (fromAccount) {
                    transferMoney(fromAccount, toAccount, amount);
                }
            }
        }

        System.out.print("Перевод от: " + fromAccountNum + " -> ");
        System.out.print("к: " + toAccountNum + " | ");
        System.out.println("Сумма: " + convertFormatNumber(amount));

        if (amount > AMOUNT_BLOCKING && block) {
            System.out.println("Подозрительная транзакция!");
        }

        if (ifBlockedFraud(amount)) {
            System.out.println("Блокируем счет...");
            accountsBlocked.put(fromAccountNum, accounts.get(fromAccountNum));
            accountsBlocked.put(toAccountNum, accounts.get(toAccountNum));
            System.out.println("Счет заблокирован!");
        } else if (accounts.get(fromAccountNum).getMoney() <= amount) {
            System.out.println("Сумма операции превышает баланс аккаунта!");
            System.out.println("Баланс аккаунта: " + convertFormatNumber(accounts.get(fromAccountNum).getMoney()));
            System.out.println("Сумма перевода: " + convertFormatNumber(amount));
            System.out.println("Перевод отменен!");
        }

    }

    /**
     * TODO:
     * реализовать метод. Возвращает остаток на счёте.
     */
    public synchronized int getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public int getSumAllAccounts() {
        accounts.forEach((key, value) -> {
            accountsTotalSum += value.getMoney();
        });

        return accountsTotalSum;
    }

    /**/

    public void addAccounts(int deal) {
        for (int i = 0; i <= deal; i++) {
            Account localAccounts = new Account();
            int money = getRandomAmount(15_000, 65_000);

            localAccounts.setAccNumber(Integer.toString(i));
            localAccounts.setMoney(money);

            accounts.put(Integer.toString(i), localAccounts);
        }
    }

    public ConcurrentHashMap<String, Account> getAccounts() {
        return accounts;
    }

    public ConcurrentHashMap<String, Account> getAccountsBlocked() {
        return accountsBlocked;
    }

    private boolean ifBlockedFraud(int amount) {
        return amount > AMOUNT_BLOCKING && block;
    }

    private void transferMoney(Account fromAccount, Account toAccount, int amount) {
        if (fromAccount.getMoney() >= amount) {
            fromAccount.setMoney(fromAccount.getMoney() - amount);
            toAccount.setMoney(toAccount.getMoney() + amount);
        }
    }

}
