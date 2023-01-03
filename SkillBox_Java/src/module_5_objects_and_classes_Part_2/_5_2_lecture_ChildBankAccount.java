package module_5_objects_and_classes_Part_2;

public class _5_2_lecture_ChildBankAccount {
    /**
     * TODO: Задача 5.2
     * Напишите код класса с применением принципа инкапсуляции
     */

    private double balance;
    private double maxBalance;

    public _5_2_lecture_ChildBankAccount(double maxBalance) {
        this.maxBalance = maxBalance;
    }

    /**
     * Метод должен защищать balance от ошибочных изменений — уменьшения
     * (в случае, если value меньше нуля) и увеличения сверх лимита
     * (выше значения maxBalance).
     *
     * В методе напишите проверку того, что сумма счёта после пополнения
     * не станет выше максимально допустимой — выше значения переменной
     * maxBalance. Если это условие выполняется, увеличьте баланс счёта
     * на значение value и верните true. Если условие не выполняется или
     * переменная value меньше нуля, метод должен возвращать false.
     */
    public boolean depositMoney(double value) {
        double sum = balance + value;

        if (sum > maxBalance || sum < balance) {
            return false;
        }

        balance = sum;
        return true;
    }

    /**
     * Этот метод должен защищать переменную balance от увеличения
     * (в случае, если будет передано значение value меньше 0) и от
     * уменьшения ниже нуля.
     *
     * Напишите в этом методе проверку того, что баланс счёта не станет
     * отрицательным, если из него вычесть value, а также проверку того,
     * что value — неотрицательное число. В случае, если всё в порядке,
     * метод должен вернуть true. Если хотя бы одно из условий не выполняется,
     * метод должен вернуть false.
     */
    public boolean debitMoney(double value) {
        double sum = balance - value;

        if (sum < 0 || sum > balance) {
            return false;
        }

        balance = sum;
        return true;
    }

    /**
     * Создайте также в классе ChildBankAccount метод getBalance, который будет
     * возвращать текущий баланс счёта.
     */
    public double getBalance() {
        return balance;
    }
}
