package module_2;

public class _2_11_1_Practical_work {
    public static void main(String[] args) {
        /**
         * TODO: Задача 2.11 - 1
         * - Откройте проект Booleans (скачайте прикреплённый архив с проектом).
         *
         * - Ознакомьтесь с кодом, который написан в классе Main. В нём заданы
         * шесть переменных с количествами разных ингредиентов, а затем показан
         * пример проверки — хватает ли яблок для приготовления яблочного сока.
         *
         * - Допишите в коде проекта условные операторы if так, чтобы они
         * проверяли количество ингредиентов для каждого рецепта. Если
         * ингредиентов достаточно для приготовления конкретного блюда, в
         * консоль должно выводиться название этого блюда.
         *
         * - Запустите программу и убедитесь, что печатаются названия блюд,
         * которые можно приготовить из заданного количества ингредиентов.
         *
         * - Попробуйте изменить количество ингредиентов (значения переменных)
         * так, чтобы выдавались разные блюда. Перед отправкой на проверку
         * убедитесь, что ваш код работает верно.
         */

        int milkAmount = 300; // ml
        int powderAmount = 500; // g
        int eggsCount = 5; // items
        int sugarAmount = 5; // g
        int oilAmount = 30; // ml
        int appleCount = 8; // items

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        boolean isIngredientsForPancakes = powderAmount >= 400
            && sugarAmount >= 10 && milkAmount >= 1 && oilAmount >= 30;

        //milk - 300 ml, powder - 5 g, eggs - 5
        boolean isIngredientsForOmelette = milkAmount >= 300
            && powderAmount >= 5 && eggsCount >= 5;

        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        boolean isIngredientsForApplePie = appleCount >= 3
            && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4;

        /**/

        if (isIngredientsForPancakes) {
            System.out.println("Pancakes");
        }

        if (isIngredientsForOmelette) {
            System.out.println("Omelette");
        }

        if (isIngredientsForApplePie) {
            System.out.println("Apple pie");
        }
    }
}
