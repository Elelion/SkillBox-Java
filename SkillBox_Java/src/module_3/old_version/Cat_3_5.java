package module_3;

public class Cat_3_5
{
    /**
     * TODO: Задача 3.5
     * -
     */

    // задаем константу - изменить НЕ возможно, она постоянна!!!
    public static final int LEGS_COUNT = 4;
    private static final int EYES = 2;

    private String name;

    public static double totalWeight;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedAmount;

    private static int countCat;

    /**/

    public Cat_3_5()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

        countCatAdd();
    }

    /**/

    public void meow()
    {
        // уменьшаем вес при каждом мяу. типа сжигаем ккалории
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        feedAmount = amount;
        weight = weight + amount;
    }

    // void - не возвращает не чего
    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public void goToTheToilet() {
        System.out.println("Какаем...");
        weight -= 1200 * Math.random();
    }

    public void countCatAdd() {
        countCat++;
    }

    public void countCatReduce() {
        if (countCat >= 1) {
            countCat--;
        }
    }

    /**/

    public Double getFeedAmount() {
        return feedAmount;
    }

    // Double - тип возвращаемого значения
    public Double getWeight()
    {
        return weight;
    }

    public static Double getTotalWeight() { return totalWeight; }

    public String getStatus()
    {
        if (weight < minWeight) {
            countCatReduce();
            return "Dead";
        }

        else if (weight > maxWeight) {
            countCatReduce();
            return "Exploded";
        }

        else if (weight > originWeight) {
            return "Sleeping";
        }

        else {
            return "Playing";
        }
    }

    public String getName() {
        return name;
    }

    public static int getCountCat() {
        return countCat;
    }

    public int getEyes() {
        return EYES;
    }

    /**/

    public void setName(String nameCat) {
        name = nameCat;
    }

    public void setCatColor(CatColor_enum_3_5 color) {
        switch (color) {
            case GREY: {
                System.out.println("сервый");
                break;
            }

            case BROWN: {
                System.out.println("коричневый");
                break;
            }

            case BLACK: {
                System.out.println("черный");
                break;
            }

            case WHITE: {
                System.out.println("белый");
                break;
            }

            case YELLOW: {
                System.out.println("желтый");
                break;
            }
        }
    }
}
