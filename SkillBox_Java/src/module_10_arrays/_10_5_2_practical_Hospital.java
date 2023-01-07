package module_10_arrays;

import java.text.DecimalFormat;
import java.util.Random;

public class _10_5_2_practical_Hospital {
    public _10_5_2_practical_Hospital() {
        /**
         * TODO: Задание 10.5 - 2
         * - Напишите код метода generatePatientsTemperatures(), который должен
         * сгенерировать массив float, содержащий значения температур пациентов
         * от 32 до 40 градусов.
         * - В методе getReport()вам требуется составить строку с отчётом по
         * значениям температур в массиве с пациентами:
         *  • Соберите в строку список температур пациентов.
         *  • Рассчитайте среднее арифметическое значение температуры.
         *  • Посчитайте количество здоровых пациентов с температурой от 36,2 до 36,9 градусов.
         */

        float[] patientsTemperatures = generatePatientsTemperatures(50);
        for (int i = 0; i < patientsTemperatures.length; i++) {
            //System.out.println("Температура № " + i + " - " + patientsTemperatures[i]);
        }
        System.out.println("...");

        System.out.println(getReport(patientsTemperatures));
    }

    /**/

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];

        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = randomizeTemperature();
        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        String temperaturesList = "";
        int healthyPatients = 0;

        for (float temp : temperatureData) {
            if (temp >= 36.2 && temp <= 36.9) {
                temperaturesList += temp + ", ";
                healthyPatients++;
            }
        }

        /**/

        String[] averageTemperatureString = temperaturesList.split(", ");
        float sum = 0.0f;
        float averageTemperature = 0;

        for (String s : averageTemperatureString) {
            sum += Float.parseFloat(s);
        }

        averageTemperature = Math.round( (sum / averageTemperatureString.length) * 100 ) / 100.0f;

        /**/

        if (temperaturesList.isEmpty()) {
            temperaturesList = "0";
        }

        // String temperaturesListTrim = temperaturesList.substring(0, temperaturesList.length() - 1);

        return "Температуры пациентов: " + temperaturesList + System.lineSeparator() +
            "Средняя температура: " + trimRemainder(averageTemperature, 2) + System.lineSeparator() +
            "Количество здоровых: " + healthyPatients;
    }

    /**/

    private static float randomizeTemperature() {
        double temperature = new Random().nextFloat(40);

        while (temperature < 32.0) {
            temperature = new Random().nextFloat(40);
        }

        return trimRemainder(temperature, 1);
    }

    private static float trimRemainder(double temperature, int length) {
        String pattern = (length == 1) ? "#0.0" : "#0.00";

        String tempString = new DecimalFormat(pattern).format(temperature);
        return Float.parseFloat(tempString.replace(',', '.'));
    }
}
