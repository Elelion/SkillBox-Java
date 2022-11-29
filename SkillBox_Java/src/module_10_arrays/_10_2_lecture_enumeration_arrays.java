package module_10_arrays;

import java.util.Random;

public class _10_2_lecture_enumeration_arrays {
    public _10_2_lecture_enumeration_arrays() {
        System.out.println("10.2 - 1 - перебираем массив");

        // так можно писать но не принято в Java
        int ticketNumbers[] = new int[1000];

        // каждый 100ый билет будет выиграшным, в Java массивы принято создавать так
        int[] winTickets = new int[10];

        // заполняем наши билеты
        for (int i = 0; i < ticketNumbers.length; i++) {
            int value = 1_000_000 + (int) Math.round(1_000_000 * Math.random());
            // ticketNumbers[i] = value;

            // каждое 100е значение, из 1000 это будет 10
            if (i % 100 == 0) {
                winTickets[i / 100] = value;
            }

            // System.out.println(value);
        }

        /**
         * позволяет последовательно от 0 до конца получить все елементы
         * указанного массива. Те это аналогично стандартному for (i = 0...)
         * только без индекса i.
         */
        for (int winTicketNumber : winTickets) {
            System.out.println(winTicketNumber);
        }

        System.out.println("-");
    }
}
