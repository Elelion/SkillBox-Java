package core.module_2;

public class Camera {
    public static Car getNextCar() {
        // .substring(2, 5) - обрезаем число со 2го символа включительно и до
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        int randomHeight = (int) (1000 + 3500 * Math.random());
        double randomWeight = 600 + 10000 * Math.random();

        // запихиваем в Car св-ва наши рандомные значения
        Car car = new Car();
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;

        /**
         * эти два параметра будут равны true, если случаеное число выпадет
         * больше или меньше 0.15
         *
         * Math.random() - возращает случаенные числа от 0 до 1
         */
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}
