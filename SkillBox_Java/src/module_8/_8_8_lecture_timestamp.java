package module_8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class _8_8_lecture_timestamp {
    public _8_8_lecture_timestamp() {
        // возвращает текущее кол-во миллесекунд
        long start = System.currentTimeMillis();

        String line = "";
        for (int i = 0; i < 100_000; i++) {
            line += Math.random();
        }

        System.out.println("Код выполнялся: " +
            (System.currentTimeMillis() - start) / 1000 + " сек");
        System.out.println("-");

        /**/

        // передаем в секундах, 0 , задаем часовой регион (+3 МСК)
        LocalDateTime now = LocalDateTime.ofEpochSecond(
            System.currentTimeMillis() / 1000,
            0,
            ZoneOffset.ofHours(3));
        System.out.println(now);
        System.out.println("-");

        /**/

        // выводим текущее время в МС
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now.toEpochSecond(ZoneOffset.ofHours(3)));
    }
}
