package module_8_numbers_and_dates;

public class _8_2_task_2_GeometryCalculator {

    private final static double PI = Math.PI;

    /**
     * расчёта площади круга по его радиусу;
     * если значение radius меньше 0, метод должен вернуть -1
     */
    public static double getCircleSquare(double radius) {
        if (radius < 0) {
            return -1;
        }

        return PI * Math.pow(radius, 2);
    }

    /**/

    /**
     * расчёта площади треугольника по длинам его сторон;
     *
     * Условие возможности построения треугольника: у треугольника сумма любых
     * двух сторон должна быть больше третьей.
     */
    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a + b < c || a + c < b || b + c < a) {
            return false;
        }

        return true;
    }

    /**
     * перед расчетом площади рекомендуется проверить возможен ли такой треугольник
     * методом isTrianglePossible, если невозможен вернуть -1.0
     */
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)) {
            double halfMeter = (a + b + c) / 2;
            double square = Math.sqrt(halfMeter * (halfMeter - a) * (halfMeter - b) * (halfMeter - c));

            return square;
        }

        return -1;
    }

    /**/

    /**
     * расчёта объёма шара по его радиусу;
     * если значение radius меньше 0, метод должен вернуть -1
     */
    public static double getSphereVolume(double radius) {
        if (radius < 0) {
            return -1;
        }

        // получаем результат
        Double result = (4 * Math.pow(radius, 3)) / 3 * PI;

        // преобразуем в строку, что бы обрезать лишнее
        String resToStr = result.toString().substring(0, 10);

        // преобразуем строку обратно в double
        return Double.parseDouble(resToStr);
    }

}
