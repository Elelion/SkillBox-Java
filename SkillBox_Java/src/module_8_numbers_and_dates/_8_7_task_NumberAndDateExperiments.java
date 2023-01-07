package module_8_numbers_and_dates;

import java.time.LocalDate;
import java.time.Period;

public class _8_7_task_NumberAndDateExperiments {
    /**
     * TODO: 8.7 - 1
     * Создайте метод, возвращающий количество лет, месяцев и дней с даты
     * основания языка Java
     */

    LocalDate birthday = LocalDate.of(1995, 5, 23);
    // LocalDate currentDate = LocalDate.now();
    Period period = birthday.until(LocalDate.now());

    public _8_7_task_NumberAndDateExperiments() {
        LocalDate birthday = LocalDate.of(1995, 5, 23);
        LocalDate currentDate = LocalDate.now();

        System.out.println(birthday);
        System.out.println(currentDate);
        System.out.println("Прошло лет: " + getPeriodFromJavaBirthday());
    }

    public String getPeriodFromJavaBirthday() {
        // String sum = String.valueOf(birthday.until(currentDate));
        // return sum;

        return period.getYears() + " years, " +
            period.getMonths() + " months, " +
            period.getDays() + " days";
    }
}
