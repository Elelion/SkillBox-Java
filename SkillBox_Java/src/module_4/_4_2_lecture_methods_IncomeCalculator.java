package module_4;

import java.util.Scanner;

public class _4_2_lecture_methods_IncomeCalculator {
    private static int minIncome = 200000;
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt();

            // метод описан за пределами метода main
            if (!checkIncomeRange(income)) {
                continue;
            }

            double managerSalary = income * managerPercent;
            double pureIncome = income - managerSalary -
                calculateFixedCharges();
            double taxAmount = mainTaxPercent * pureIncome;
            double pureIncomeAfterTax = pureIncome - taxAmount;

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            // точка безубыточности компании
            boolean breakEvenPointCompany = pureIncomeAfterTax == minInvestmentsAmount;
            if (breakEvenPointCompany) {
                System.out.println("Ваш бюджет = точке безубыточности компании");
            }

            System.out.println("Зарплата менеджера: " + managerSalary);

            // тернарный оператор в скобках
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));

            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));

            if (pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!");
            }
        }
    }

    /**
     * сигнатура метода - это имя метода и набор параметров, которые
     * передаются в метод.
     *
     * параметры метода - передаются в круглых скобках, далее мы оперируем с
     * этими параметрами
     */
    private static boolean checkIncomeRange(int income) {
        if (income < minIncome) {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    /**
     * все методы что мы здесь видим являются методами нашего
     * _4_2_methods_lecture_IncomeCalculator класса
     */
    private static int calculateFixedCharges() {
        return officeRentCharge +
            telephonyCharge +
            internetAccessCharge +
            assistantSalary +
            financeManagerSalary;
    }
}
