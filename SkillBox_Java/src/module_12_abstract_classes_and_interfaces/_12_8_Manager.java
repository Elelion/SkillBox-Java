package module_12_abstract_classes_and_interfaces;

import java.util.Random;

/**
 * Manager — зарплата складывается из фиксированной части и бонуса в
 * виде 5% от заработанных для компании денег. Количество заработанных
 * денег для компании генерируйте случайным образом от 115 000 до 140 000 рублей.
 */
public class _12_8_Manager implements _12_8_practical_EmployeeInterface {
    private final int SALARY;
    private static final int PERCENT_BONUS = 5;
    private final int EARNED_MONEY = new Random().nextInt(115_000, 140_000);

    /**/

    public _12_8_Manager(int salary) {
        SALARY = salary;
        System.out.println("1 менеджер нанят");
    }

    /**/

    public static int getPercentBonus() {
        return PERCENT_BONUS;
    }

    /**/

    @Override
    public int getMonthSalary() {
        int calcBonusProfit = (EARNED_MONEY * PERCENT_BONUS) / 100;
        return SALARY + calcBonusProfit;
    }
}
