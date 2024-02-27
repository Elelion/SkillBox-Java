package module_10_arrays;

import java.util.Random;

public class _10_1_lecture_creating_arrays {
    public _10_1_lecture_creating_arrays() {
        System.out.println("10.1 - 1 - создаем обычные массивы");

        // создаем массив, нумерация с 0, максимум содержит 6 значений
        int[] roomCounts = new int[6];

        // в данном случае, массив автоматически будет иметь нужный размер
        int[] roomHotelCounts = {1, 8, 6};

        for (int i = 0; i < roomCounts.length; i++) {
            roomCounts[i] = new Random().nextInt(75);
            System.out.println(roomCounts[i]);
        }

        System.out.println("roomHotelCounts: " + roomHotelCounts[2]);
        System.out.println("-");

        /**/

        System.out.println("10.1 - 2 - создаем массив объектов");

        String[] colors = {"red", "orange", "yellow"};

        for (int i = 0; i < colors.length; i++) {
            System.out.println(colors[i]);
        }
        System.out.println(System.lineSeparator());

        // ,? - занпятая может быть или не быть
        String text = "Каждый охотник желает знать, где синий фазан";
        String[] fazan = text.split(",?\\s");
        for (int i = 0; i < fazan.length; i++) {
            System.out.println(fazan[i]);
        }
    }
}
