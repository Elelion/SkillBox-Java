package module_11_inheritance;

public class _11_8_practical_CardAccount extends _11_8_practical_BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    private final int commission = 1;

    /**/

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        // Вариант №1
        double calcComission = (amountToTake * commission) / 100;
        double calcAmount = amountToTake + calcComission;

        // Вариант №2
        // amountToTake = (amountToTake / 100) + amountToTake;

        super.take(calcAmount);
    }
}
