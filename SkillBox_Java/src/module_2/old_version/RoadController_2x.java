package module_2;

// импортировать ВСЕ используемые модули из...
//import core.module_2.*;

// те запись выше аналогично этим двум:
//import core.module_1.Camera;
//import core.module_1.Car;

import java.util.Scanner;

public class RoadController_2x {
    /**
     * TODO: Задача 2.3
     * обозначить комментариями все места где объявляются переменные
     */

    /**
     * TODO: Задача 2.6
     * - уменьшить высоту КПП до 3.5 метров
     * - исправить в коде ошибку, тк не верно выставляется цена за
     * грузовые - легковые авто
     */

    // private static - это все переменные
    private static double passengerCarMaxWeight = 3500.0; // kg, double
    private static int passengerCarMaxHeight = 2000; // mm, int
    private static int controllerMaxHeight = 3500; // mm, int

    // Цена на пассажирский автомобиль
    private static int passengerCarPrice = 100; // RUB, int
    private static int cargoCarPrice = 250; // RUB, int

    // Дополнительная цена транспортного средства
    private static int vehicleAdditionalPrice = 200; // RUB, int

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in);

        // int
        int carsCount = scanner.nextInt();

        // генерируем заданное кол-во автомобилей
        for (int i = 0; i < carsCount; i++) {
            // Car car = Camera.getNextCar();
            // System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            // if (car.isSpecial) {
            //    openWay();

                /**
                 * работает в циклах, и дает команду VM Java не выполнять
                 * код дальше, а идти в начало и выполнять код снова
                 */
                // continue;
            // }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            // int price = calculatePrice(car); // int

            // если цена не назначена - то возвращаемся в начало кода, иначе идем дальше
            // if (price == -1) {
                // continue;
            // }

            // System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(core.module_2.Car car) {
        // int
        int carHeight = car.height;
        int price = 0;

        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            double weight = car.weight;

            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}
