package module_8_numbers_and_dates;

public class _8_4_lecture_RemoteControl {
    private final double START_TEMPERATURE = 32.0;
    private double temperature;

    public _8_4_lecture_RemoteControl() {
        temperature = START_TEMPERATURE;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }
}
