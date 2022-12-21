package module_3;

public class Loader_3_5
{
    public static void main(String[] args)
    {
        /**
         * TODO: Задача 3.5
         * - создать для кошки константы - кол-во глаз, мин/мах вес
         * - enum - с окрасами кошек
         */

        /**
         * для того что бы воспользоваться статической переменной
         * нам создавать объект НЕ нужно, мы на прямую можем обратиться к
         * переменным или методам , без создания объектов
         */


        System.out.println(Cat_3_6.LEGS_COUNT);

        Cat_3_6 cat = new Cat_3_6("Мурка", 2500.0);
        cat.setCatColor(CatColor_enum_3_5.BLACK);
        System.out.println("Кол-во глаз: " + cat.getEyes());
        System.out.println("Имя: " + cat.getName());
    }
}
