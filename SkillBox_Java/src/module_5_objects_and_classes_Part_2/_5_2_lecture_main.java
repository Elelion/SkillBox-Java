package module_5_objects_and_classes_Part_2;

public class _5_2_lecture_main {
    public static void main(String[] args) {
        _5_2_lecture_encapsulation_gearBox gearBox = new _5_2_lecture_encapsulation_gearBox();
         gearBox.getCurrentGear();

        // Задание 1
        _5_2_lecture_ChildBankAccount account = new _5_2_lecture_ChildBankAccount(10000);
        account.depositMoney(1000);
        account.depositMoney(2000);
        account.depositMoney(10000);
        account.depositMoney(-1000);
        System.out.println("Balance: " + account.getBalance());

        account.debitMoney(500);
        account.debitMoney(422.75);
        account.debitMoney(50000);
        account.debitMoney(-50);
        System.out.println("Balance: " + account.getBalance());
    }
}
