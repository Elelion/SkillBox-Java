package module_12_abstract_classes_and_interfaces;

/**
 * TopManager — зарплата складывается из фиксированной части и бонуса в
 * виде 150% от заработной платы, если доход компании более 10 млн рублей.
 */
public class _12_8_TopManager implements _12_8_practical_EmployeeInterface {
    private final int SALARY;
    private static final int PERCENT_BONUS = 150;
    private final int EARNED_MONEY;
    private static final int DEFAULT_COMPANY_INCOME = 10_000_000;

    /**/

    public _12_8_TopManager(int companyIncome, int salary) {
        EARNED_MONEY = companyIncome;
        SALARY = salary;
        System.out.println("1 топ-менеджер нанят");
    }

    /**/

    public static int getPercentBonus() {
        return PERCENT_BONUS;
    }

    public static int getDefaultCompanyIncome() {
        return DEFAULT_COMPANY_INCOME;
    }

    /**/

    @Override
    public int getMonthSalary() {
        if (EARNED_MONEY >= DEFAULT_COMPANY_INCOME) {
            int calcBonusProfit = (SALARY * PERCENT_BONUS) / 100;
            return SALARY + calcBonusProfit;
        }

        return SALARY;
    }
}
