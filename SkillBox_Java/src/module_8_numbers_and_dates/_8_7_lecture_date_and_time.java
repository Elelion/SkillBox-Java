package module_8_numbers_and_dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class _8_7_lecture_date_and_time {
    public _8_7_lecture_date_and_time() {
        System.out.println("8.7 - 1");

        // получить текущую дату
        Date now = new Date();
        System.out.println("now: " + now);
        System.out.println("-");

        /**/

        System.out.println("8.7 - 2");

        // получить текущую дату
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);

        // получить текущее дату и время
        LocalDateTime time = LocalDateTime.now();
        System.out.println("time: " + time);

        // задать свою дату
        LocalDate birthday = LocalDate.of(1987, 4, 25);
        System.out.println("birthday: " + birthday);
        System.out.println("birthday plus: " + birthday.plusYears(15));

        // задать дату в Нью Йорке
        LocalDateTime nowNY = LocalDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(nowNY);
        System.out.println("-");

        /**/

        /**
         * задаем дату, через парсер
         * парсер проверяет дни, месяца итп есть ли они в этом году или нет
         * и если даты нет то она будет преобразована в максимальный день месяца
         * который есть в этом году
         */
        String date = "23/01/2022";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        System.out.println("localDate: " + localDate);
        System.out.println("-");

        /**/

        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now().minusDays(2); // -2 дня от текущего

        /**
         * срвнить даты мы можешь 3мя методами
         * isBefore
         * isAfter
         * isEqual
         */
        if (time1.isAfter(time2)) {
            System.out.println("time1 is after time2");
        }

        // выведет 2, тк первое число больше на 2 дня, чем вторая дата
        System.out.println(time1.compareTo(time2));

        // разница в часах
        System.out.println(time1.until(time2, ChronoUnit.HOURS));
    }
}
