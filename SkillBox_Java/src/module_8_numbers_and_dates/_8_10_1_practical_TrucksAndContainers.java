package module_8_numbers_and_dates;

import java.util.Scanner;

public class _8_10_1_practical_TrucksAndContainers {
    /**
     * TODO: Задание 8.10 - 1
     * - Представьте, что вы доставляете груз в ящиках одинакового размера. У вас
     * есть грузовики и контейнеры. В каждый грузовик помещается максимум 12
     * контейнеров. В каждый контейнер — не более 27 ящиков. Ящики, контейнеры
     * и грузовики пронумерованы.
     *
     * - Выполняйте задание в репозитории “java_NumbersAndDates”.
     *
     * - Напишите в классе src/main/java/practice/TrucksAndContainers.java
     * программу, которая распределит ящики по контейнерам и грузовикам в
     * зависимости от их количества.
     *
     * - Программа должна также выводить необходимое для этого число грузовиков
     * и контейнеров исходя из количества ящиков, введённого пользователем после
     * запуска программы.
     *
     * - Пример вывода программы для двух ящиков:
     * • Грузовик: 1
     * •     Контейнер: 1
     * •         Ящик: 1
     * •         Ящик: 2
     *
     * Необходимо:

     * грузовиков - 1 шт.
     * контейнеров - 1 шт.
     *
     * - Запустите в проекте тесты и убедитесь в том, что они выполняются успешно.
     * Если всё получилось, поздравляем! Теперь вы умеете пользоваться как
     * простыми математическими операторами, так и специальными функциями в
     * языке Java!
     *
     * - Если тесты не выполняются и выдают информацию об ошибках, постарайтесь
     * самостоятельно исправить эти ошибки и добиться успешного выполнения тестов.
     *
     *
     * Советы и рекомендации:
     * - Для добавления отступа слева используйте символ табуляции \t.
     * - Для переноса строк используйте строку, возвращаемую методом
     * System.lineSeparator(). Этот метод возвращает системный перенос строки
     * той операционной системы, на которой запущено приложение, так как в
     * MacOS, Windows и Linux используются разные символы переноса строк:
     * для Windows это \r\n, а для MacOS и Linux — \n.
     * - Используйте для вычислений арифметическую операцию «остаток от деления»:
     * System.out.println(45 % 10); // вывод будет 5.
     */

    private final static int MAX_BOXES_IN_CONTAINER = 27;
    private final static int MAX_CONTAINERS_IN_TRUCK = 12;

    int boxes = 0;
    int userContainer = 0;
    int userTruck = 0;

    public _8_10_1_practical_TrucksAndContainers() {
        // while(true) {
            inputBoxes();

            /**/

            userContainer = calc(boxes, MAX_BOXES_IN_CONTAINER);
            userTruck = calc(userContainer, MAX_CONTAINERS_IN_TRUCK);

            printGeneralDetails();
            printDetails();
        // }
    }

    /**/

    private void inputBoxes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите кол-во коробок: ");
        this.boxes = scanner.nextInt();
    }

    private int calc(int current, int max) {
        if (current <= max) {
            return 1;
        }

        if (current % max != 0) {
            return Math.floorDiv(current, max) + 1;
        }

        return Math.floorDiv(current, max);
    }

    private void printGeneralDetails() {
        System.out.println("Необходимо:");
        System.out.println("Нужно контейнеров: " + userContainer);
        System.out.println("Нужно грузовиков: " + userTruck + System.lineSeparator());
        System.out.println("-");
    }

    private void printDetails() {
        for (int i = 1; i <= userTruck; i++) {
            System.out.println("\uD83D\uDE9B Грузовик: " + i);

            for (int j = 1; j <= MAX_CONTAINERS_IN_TRUCK; j++) {
                if (userContainer > 0) {
                    System.out.println("\t \uD83D\uDDC4 Контейнер: " + j);
                    userContainer--;
                }

                for (int l = 1; l <= MAX_BOXES_IN_CONTAINER; l++) {
                    if (boxes > 0) {
                        System.out.println("\t\t \uD83D\uDCE6 Ящик: " + l);
                        boxes--;
                    }
                }
            }
        }
    }
}
