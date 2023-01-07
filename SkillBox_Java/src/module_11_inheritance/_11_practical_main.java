package module_11_inheritance;

public class _11_practical_main {
    public static void main(String[] args) {
        System.out.println("Задание №1");

        _11_8_practical_BankAccount bankAccount = new _11_8_practical_BankAccount();
        _11_8_practical_CardAccount cardAccount = new _11_8_practical_CardAccount();
        _11_8_practical_DepositAccount depositAccount = new _11_8_practical_DepositAccount();

        cardAccount.put(1000);
        System.out.println(cardAccount.getAmount());
        cardAccount.take(500);
        System.out.println(cardAccount.getAmount());

        System.out.println("-");
        depositAccount.put(500);
        depositAccount.take(100);
        System.out.println(depositAccount.getAmount());

        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());

        /* ----------------------------------------------------------------- */

        System.out.println("Задание №2");
//        _10_5_2_practical_Hospital task2 = new _10_5_2_practical_Hospital();
        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());
    }
}
