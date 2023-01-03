package module_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat_1_6 {
    public static void main(String[] args) {
        /**
         * TODO: Задача
         * сделать что бы время выводилось в РФ формате типа 23:55
         */

        /**
         * парметры формата:
         * a/p - am / pm
         * 4 цифры для года (yyyy);
         * 2 цифры для месяца (ММ);
         * 2 цифры для дня (dd);
         * 2 цифры для часов в 24-часовом формате (HH);
         * 2 цифры для минут (mm);
         * 2 цифры для секунд (ss).
         */
        DateFormat format = new SimpleDateFormat("HH:mm a MM/dd/yyyy");

        // объявляем переменную содержащую текущую дату
        Date date = new Date();

        // выводим
        System.out.println(format.format(date));
    }
}
