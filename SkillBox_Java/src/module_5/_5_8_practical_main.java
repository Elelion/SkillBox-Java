package module_5;

import java.util.Scanner;

public class _5_8_practical_main {
    public static void main(String[] args) {

        // Задание №1
        _5_8_1_practical_Elevator elevator = new _5_8_1_practical_Elevator(-3, 26);

        while (true) {
            System.out.print("Введите номер этажа (999 для выхода): ");

            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);

            if (floor == 999) {
                break;
            }
        }

        System.out.println("---");


        /**/


        // Задание №2
        _5_8_2_practical_Dimensions dimensions = new _5_8_2_practical_Dimensions(
            100, 200, "address",
            true, "219922FFF", false
        );

        System.out.println(dimensions);
        System.out.println("...");
        System.out.println(dimensions.setAddress("->[ new addr ]<-"));
        System.out.println("...");
        System.out.println(dimensions);
    }
}
