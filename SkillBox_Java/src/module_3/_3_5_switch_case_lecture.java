package module_3;

import java.util.Scanner;

public class _3_5_switch_case_lecture {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите новое сообщение:");
            String input = new Scanner(System.in).nextLine();

            // если сообщений будет много, то код будет не красивый и путанный
            /*
            if (input.equals("Привет")) {
                System.out.println("Здравствуй...");
            } else if (input.equals("Как дела ?")) {
                System.out.println("Отлично! У тебя как ?");
            } else {
                System.out.println("Не понимаю сообщение...");
            }
            */

            // старый вариант написания switch
            /*
            switch (input) {
                case "Привет":
                    System.out.println("Здравствуй...");
                    break;

                case "Как дела ?":
                    System.out.println("Отлично! У тебя как ?");
                    break;

                default:
                    System.out.println("Не понимаю сообщение...");
            }
            */

            /**
             * новый вариант написания switch
             *
             * Нововведение в java 12 даёт нам возможность использовать лямбда
             * оператор (->), который в свою очередь гарантирует , что будет
             * выполнен только код справа от нее. Без всякого  "проваливания".
             *
             * Что бы написать несколько строк кода, нужно использовать -> {...}
             */
            switch (input) {
                case "Привет" -> System.out.println("Здравствуй...");
                case "Как дела ?" -> {
                    System.out.println("Отлично!");
                    System.out.println("У тебя как ?");
                }
                default -> System.out.println("Не понимаю сообщение...");
            }
        }
    }
}
