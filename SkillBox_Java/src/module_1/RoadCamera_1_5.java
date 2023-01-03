package module_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RoadCamera_1_5 {
    public static void main(String[] args) throws IOException {

        /**
         * TODO: Задача
         * Сделать так, что бы программа не штрафовала водителя, если скорость
         * равна 60 км/ч
         *
         * Увеличить сумму штрафа с 500 до 1000
         */

        // прочие методы ввода данных
        Scanner in = new Scanner(System.in);

        System.out.print("Введите любую строку: ");
        String str = in.nextLine(); // ввести строку
        System.out.println(str);

        System.out.print("Введите любое число: ");
        int num = in.nextInt(); // ввести число
        System.out.println(num);

        // --------------------------------------------------------------------

        //Параметры программы
        int maxOncomingSpeed = 60; // km/h
        int speedFineGrade = 20; // km/h
        int finePerGrade = 1000; // RUB
        int criminalSpeed = 180; // km/h

        /**/

        System.out.println("Введите скорость автомобиля:");
        // Скорость автомобиля
        int oncomingSpeed = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());

        if (oncomingSpeed >= criminalSpeed) {
            System.out.println("Вызов полиции...");
        } else if (oncomingSpeed > maxOncomingSpeed) {
            // получаем на сколько км мы привысили скорость
            int overSpeed = oncomingSpeed - maxOncomingSpeed;

            // получаем на сколько шагов мы привысили скорость (тк число целове, остатка нет)
            int gradesCount = overSpeed / speedFineGrade;

            // умножаем полученые шаги на сумму штрафа на каждый шаг
            int fine = finePerGrade * gradesCount;
            System.out.println("Сумма штрафа: " + fine);
        } else {
            System.out.println("Скорость не превышена");
        }
    }
}
