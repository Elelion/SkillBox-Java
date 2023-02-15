package module_16_working_with_mysql;

import module_16_working_with_mysql._16_2_lecture_JBDC.JDBC;
import module_16_working_with_mysql._16_3_lecture_without_ResultSet.WithoutResultSet;
import module_16_working_with_mysql._16_4_lecture_hibernate.Hibernate;

public class _16_main {
    public static void main(String[] args) {
        System.out.println("Лекция 16.2");
//        JDBC JDBC = new JDBC();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 16.3");
//        WithoutResultSet withoutResultSet = new WithoutResultSet();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("-");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 16.4");
        Hibernate hibernate = new Hibernate();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("-");
    }
}
