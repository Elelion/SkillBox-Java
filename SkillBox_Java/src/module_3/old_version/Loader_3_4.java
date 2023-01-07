package module_3;

public class Loader_3_4
{
    public static void main(String[] args)
    {
        /**
         * для того что бы воспользоваться статической переменной
         * нам создавать объект НЕ нужно, мы на прямую можем обратиться к
         * переменным или методам , без создания объектов
         */
        Cat_3_4.totalWeight = 10000;
        System.out.println(Cat_3_4.getTotalWeight());

        Cat_3_4 vasya = new Cat_3_4();
        vasya.setName("Вася");
        System.out.println(vasya.getName());
        System.out.println("Создано котов: " + vasya.getCountCat());

        Cat_3_4 murka = new Cat_3_4();
        Cat_3_4 barsik = new Cat_3_4();
        System.out.println("Создано котов: " + Cat_3_4.getCountCat());
        for (int i = 0; i < 100; i++) {
            barsik.feed(500.0);
        }
        System.out.println(barsik.getStatus());

        System.out.println("Создано котов: " + Cat_3_4.getCountCat());
    }
}
