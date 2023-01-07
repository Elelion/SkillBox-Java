package module_11_inheritance;

import java.time.LocalDate;

public class _11_8_practical_DepositAccount extends _11_8_practical_BankAccount {
    private LocalDate lastIncome;

    /**/

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        System.out.println("_11_8_practical_DepositAccount -> if: ...: " +
            LocalDate.now().minusMonths(1).isAfter(lastIncome));

        if (LocalDate.now().minusMonths(1).isAfter(lastIncome)) {
            super.take(amountToTake);
        }
    }
}
