package module_3;

import java.util.Scanner;

public class _3_8_3_practical_SwimmingPool {
    public static void main(String[] args) {
        /**
         * TODO: Задача 3.8 - 3
         * - Создайте новый проект и назовите его SwimmingPool.
         *
         * - Создайте переменную int volume, в которой будет храниться объём
         * бассейна, и установите её равной 1200.
         *
         * - Представьте, что система наполняет бассейн со скоростью 30 литров
         * в минуту, но у бассейна не отключён слив, и через него каждую минуту
         * выливается 10 литров. Создайте ещё две переменные, в которых будут
         * храниться эти значения:
         * int fillingSpeed = 30; //30 litres per minute
         * int devastationSpeed = 10; //10 litres per minute
         *
         * - Напишите программу с использованием цикла while, которая рассчитает
         * и выведет в консоль время наполнения бассейна с учётом скоростей
         * наполнения и опустошения.
         *
         * - Рекомендации по выполнению
         * Создайте переменную, в которой будет храниться текущий объём бассейна,
         * и каждую итерацию цикла добавляйте к нему fillingSpeed и вычитайте из
         * него devastationSpeed. Как только текущий объём бассейна станет равен
         * значению переменной volume, выполните команду break. В процессе
         * выполнения цикла считайте количество итераций — это и будет время
         * наполнения бассейна.
         */

        final int volumeSwimmingPool = 1200;
        final int fillingSpeedPerMinute = 30;
        final int devastationSpeedPerMinute = 10;

        int currentVolumeSwimmingPool = 0;
        int countMinutes = 0;

        /**/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текущий объем воды в бассейне (в литрах)");
        currentVolumeSwimmingPool = scanner.nextInt();

        int requiredLiters = volumeSwimmingPool - currentVolumeSwimmingPool;

        /**/

        if (currentVolumeSwimmingPool <= volumeSwimmingPool) {

            while (currentVolumeSwimmingPool <= volumeSwimmingPool) {
                currentVolumeSwimmingPool += fillingSpeedPerMinute - devastationSpeedPerMinute;
                countMinutes++;

                if (currentVolumeSwimmingPool >= volumeSwimmingPool) {
                    break;
                }
            }

            System.out.println("Бассеин заполнен.");
            System.out.print("Для заполнения " + requiredLiters + " литров");
            System.out.print(", потребуется " + countMinutes + " минут");

        } else {
            System.out.println("Превышен допустимый объем бассеина, все пропало...");
        }
    }
}
