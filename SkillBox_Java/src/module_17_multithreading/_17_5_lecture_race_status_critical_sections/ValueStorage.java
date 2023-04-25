package module_17_multithreading._17_5_lecture_race_status_critical_sections;

public class ValueStorage {
    private int value;

    public void incrementValue() {
        value = value + 1;
    }

    public int getValue() {
        return value;
    }
}
