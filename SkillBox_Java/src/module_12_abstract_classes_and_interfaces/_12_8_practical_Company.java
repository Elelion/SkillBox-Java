package module_12_abstract_classes_and_interfaces;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class _12_8_practical_Company {
    public enum Type {
        MANAGER,
        TOPMANAGER,
        OPERATOR,
    }

    private final int COMPANY_INCOME;
    private ArrayList<_12_8_practical_EmployeeInterface> staffArray = new ArrayList<>();
    private HashMap<String, Integer> COMPANY_SALARY = new HashMap<>();

    /**/

    public _12_8_practical_Company(int companyIncome, HashMap<String, Integer> companySalary) {
        COMPANY_INCOME = companyIncome;
        COMPANY_SALARY = companySalary;
    }

    /**/

    /**
     * Создайте два метода, возвращающие список указанной длины (count).
     * Они должны содержать сотрудников, отсортированных по убыванию и
     * возрастанию заработной платы:
     *
     * Примеры вывода списка зарплат
     *
     * Список из пяти зарплат по убыванию:
     * 230 000 руб.
     * 178 000 руб.
     * 165 870 руб.
     * 123 000 руб.
     * 117 900 руб.
     */
    public ArrayList<_12_8_practical_EmployeeInterface> getTopSalaryStaff(int count) {
        return getSortSalaryStaff(count, "top");
    }

    public ArrayList<_12_8_practical_EmployeeInterface> getLowerSalaryStaff(int count) {
        return getSortSalaryStaff(count, "low");
    }

    private ArrayList getSortSalaryStaff(int count, String command) {
        ArrayList salary = new ArrayList();

        for (int i = 0; i < count; i++) {
            salary.add(staffArray.get(i).getMonthSalary());
        }

        Collections.sort(salary);

        if (command == "top") {
            Collections.reverse(salary);
        }

        return salary;
    }

    /**/

    // найм одного сотрудника
    public void hire(_12_8_practical_EmployeeInterface employee) {
        staffArray.add(employee);
    }

    // увольнение сотрудника
    public void fire(_12_8_practical_EmployeeInterface employee) {
        staffArray.remove(employee);
    }

    public void fire(int quantity, Type type) {

        if (quantity > staffArray.size()) {
            System.out.println("Введено число превышающее кол-во сотрудников");
        } else {
            for (int i = 0; i < quantity; i++) {
                String str1 = staffArray.get(i).getClass().getSimpleName().toLowerCase();
                String str2 = "_12_8_" + type.toString().toLowerCase();

                if (str1.contains(str2)) {
                    staffArray.remove(i);
                }
            }
        }
    }

    // найм списка сотрудников
    public void addEmployees(int manager, int topManager, int operator) {
        for (int i = 0; i < manager; i++) {
            hire(getNewManager());
        }

        for (int i = 0; i < topManager; i++) {
            hire(getNewTopManager());
        }

        for (int i = 0; i < operator; i++) {
            hire(getNewOperator());
        }
    }

    /**/

    public _12_8_practical_EmployeeInterface getNewManager() {
        return new _12_8_Manager(COMPANY_SALARY.get(Type.MANAGER.toString()));
    }

    public _12_8_practical_EmployeeInterface getNewTopManager() {
        return new _12_8_TopManager(COMPANY_INCOME, COMPANY_SALARY.get(Type.TOPMANAGER.toString()));
    }

    public _12_8_practical_EmployeeInterface getNewOperator() {
        return new _12_8_Operator(COMPANY_SALARY.get(Type.OPERATOR.toString()));
    }

    public int getIncome() {
        return COMPANY_INCOME;
    }

    private int getCalcCompanyData(Type type, String command) {
        int count = 0;
        int profit = 0;

        for (int i = 0; i < staffArray.size(); i++) {
            String str1 = staffArray.get(i).getClass().getSimpleName().toLowerCase();
            String str2 = "_12_8_" + type.toString().toLowerCase();

            if (str1.contains(str2)) {
                count++;
                profit += staffArray.get(i).getMonthSalary();
            }
        }

        return command.contains("profit") ? profit : count;
    }

    private int getCalcSalaryExpenses() {
        int managersSalaryProfit = getCalcCompanyData(Type.MANAGER, "profit");
        int topManagersSalaryProfit = getCalcCompanyData(Type.TOPMANAGER, "profit");
        int operatorsSalaryProfit = getCalcCompanyData(Type.OPERATOR, "profit");

        return managersSalaryProfit + topManagersSalaryProfit + operatorsSalaryProfit;
    }

    private int getCompanyIncomeAfterSpending() {
        return getIncome() + getCalcCompanyData(Type.MANAGER, "profit") -
            getCalcSalaryExpenses();
    }

    public ArrayList<_12_8_practical_EmployeeInterface> getStaffArray() {
        return staffArray;
    }

    public int getArraySize() {
        return staffArray.size();
    }

    /**/

    public String toString() {
        NumberFormat f = NumberFormat.getInstance();

        return "В компании работает: " + getArraySize() + " человек." +

            /**/

            System.lineSeparator() + "-------------------" + System.lineSeparator() +
            "В штате менеджеров: " + getCalcCompanyData(Type.MANAGER, "count") +
            System.lineSeparator() +

            "В штате топ-Менеджеров: " + getCalcCompanyData(Type.TOPMANAGER, "count") +
            System.lineSeparator() +
            "В штате операторов: " + getCalcCompanyData(Type.OPERATOR, "count") +
            System.lineSeparator() +

            /**/

            "-------------------" + System.lineSeparator() +
            "Доход компании (постоянный): " + f.format(getIncome()) +
            System.lineSeparator() +

            "Дополнительная прибыль компании от продаж: " +
            f.format(getCalcCompanyData(Type.MANAGER, "profit")) +
            System.lineSeparator() +

            "Итого прибыль компании: " + f.format(getCalcCompanyData(Type.MANAGER, "profit") + getIncome()) +
            System.lineSeparator() +

            /**/

             "-------------------" + System.lineSeparator() +
            "Оклад менеджера: " + f.format(COMPANY_SALARY.get(Type.MANAGER.toString())) +
                " + " + _12_8_Manager.getPercentBonus() + " % от продаж" +
            System.lineSeparator() +

            "Оклад топ-менеджера: " + f.format(COMPANY_SALARY.get(Type.TOPMANAGER.toString())) +
                " + " + _12_8_TopManager.getPercentBonus() + " % к окладу, если доход компании" +
                " превысит " + f.format(_12_8_TopManager.getDefaultCompanyIncome()) +
            System.lineSeparator() +

            "Оклад оператора: " + f.format(COMPANY_SALARY.get(Type.OPERATOR.toString())) +
            System.lineSeparator() +

            /**/

            "-------------------" + System.lineSeparator() +
            "Итого расодов на зарплату сотрудников: " + f.format(getCalcSalaryExpenses()) +
            System.lineSeparator() +
            "Оставшиеся прибыль компании: " + f.format(getCompanyIncomeAfterSpending());

    }
}
