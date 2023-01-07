package module_3;

public class Cat_3_3
{
    /**
     * TODO: Задача 3.3
     * - создать в классе Cat метод который будет возвращать массу съеденной еды
     * - метод сходить в туалет, который будет уменьшать вес кошки и что нибудь печатать
     */
    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;
    private double feedAmount;

    public Cat_3_3()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

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

    public Double getFeedAmount() {
        return feedAmount;
    }

    // Double - тип возвращаемого значения
    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if (weight < minWeight) {
            return "Dead";
        }

        else if (weight > maxWeight) {
            return "Exploded";
        }

        else if (weight > originWeight) {
            return "Sleeping";
        }

        else {
            return "Playing";
        }
    }

    // так не работает
    public String toString() {
        return "-[ Проверяем просто toString() ]-";
    }
}
