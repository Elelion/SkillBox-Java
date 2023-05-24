package module_3;

public class Loader_3_2
{
    public static void main(String[] args)
    {
        /**
         * TODO: Задача 3.2
         * - создать несколько кошек
         * - посмотреть вес
         * - узнать вес итп
         * - перекормить кошку что бы она взорволась
         * - замяукать кошку досмерти
         */
        Cat_3_3 murka = new Cat_3_3();

        System.out.println("murka:");
        System.out.println("status: " + murka.getStatus());
        System.out.println("weight: " + murka.getWeight());
        murka.feed(20.2);
        System.out.println("weight: " + murka.getWeight());

        // замяукать до смерти
        for (int i = 0; i < murka.getWeight() + 500; i++) {
            murka.meow();
        }

        System.out.println("weight: " + murka.getWeight());
        System.out.println(murka.getStatus());

        /**/

        Cat_3_3 vasya = new Cat_3_3();
        System.out.println("---");
        System.out.println("vasya:");
        System.out.println("weight: " + vasya.getWeight());

        for (int i = 0; i < 10; i++) {
            vasya.feed(920.2);
            vasya.drink(10.1);
        }

        System.out.println("feedAmount: " + vasya.getFeedAmount());
        System.out.println("weight: " + vasya.getWeight());
        vasya.goToTheToilet();
        System.out.println("weight: " + vasya.getWeight());
        System.out.println(vasya.getStatus());
    }
}