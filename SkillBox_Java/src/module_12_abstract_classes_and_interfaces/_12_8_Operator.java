package module_12_abstract_classes_and_interfaces;

/**
 * Operator — зарплата складывается только из фиксированной части.
 */
public class _12_8_Operator implements _12_8_practical_EmployeeInterface {
    private final int SALARY;

    /**/

    public _12_8_Operator(int salary) {
        SALARY = salary;
        System.out.println("1 оператор нанят");
    }

    /**/

    @Override
    public int getMonthSalary() {
        return SALARY;
    }
}
