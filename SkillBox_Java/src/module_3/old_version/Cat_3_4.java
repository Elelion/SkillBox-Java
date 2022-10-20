package module_3;

public class Cat_3_4
{
    /**
     * TODO: Задача 3.4
     * - создать статическую переменную count которая будет увеличиваться
     * если кошку создали и убывать если кошка взорвалась или умерла
     * - моздать статический метод getCount который будет возвращать
     * общее кол-во кошек
     */

    private String name;

    public static double totalWeight;

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedAmount;

    private static int countCat;

    /**/

    public Cat_3_4()
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

    /**/

    public void setName(String nameCat) {
        name = nameCat;
    }
}
