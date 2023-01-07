package module_12_abstract_classes_and_interfaces;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class _12_practical_main {
    public static void main(String[] args) {
        System.out.println("Задание №1");




        // Компания №1 - Nestle
        HashMap<String, Integer> nestleCompanySalary = new HashMap<>();
        nestleCompanySalary.put("MANAGER", 35_000);
        nestleCompanySalary.put("TOPMANAGER", 45_000);
        nestleCompanySalary.put("OPERATOR", 25_000);

        _12_8_practical_Company nestleCompany =
            new _12_8_practical_Company(15_000_000, nestleCompanySalary);

        nestleCompany.addEmployees(80, 10, 180);
        NumberFormat f = NumberFormat.getInstance();

        System.out.println("-=-=-=-=-=-");
        System.out.println(nestleCompany);
        System.out.println("-=-=-=-=-=-");

        /**/

        ArrayList topSalaryTop = nestleCompany.getTopSalaryStaff(5);
        System.out.println("Список из пяти зарплат по убыванию");
        for (Object value : topSalaryTop) {
            System.out.println(value);
        }
        System.out.println(System.lineSeparator());

        ArrayList topSalaryLow = nestleCompany.getLowerSalaryStaff(5);
        System.out.println("Список из пяти зарплат по возрастанию");
        for (Object value : topSalaryLow) {
            System.out.println(value);
        }

        // УДАЛЕНИЕ: Рабочает и так
//        nestleCompany.fire(5, _12_8_practical_Company.Type.MANAGER);

        // Рабочает и сяк
//        nestleCompany.fire(nestleCompany.getStaffArray().get(6));
//        nestleCompany.fire(nestleCompany.getStaffArray().get(5));
//        System.out.println(nestleCompany);



        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());

        /* ----------------------------------------------------------------- */

        System.out.println("Задание №2");

        System.out.println(System.lineSeparator() + "---" + System.lineSeparator());
    }
}
