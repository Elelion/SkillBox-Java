package module_17_multithreading._17_6_lecture_atomic_variables;

import java.util.concurrent.atomic.AtomicInteger;

public class ValueStorage {

    // делаем атомарную переменную
    private AtomicInteger value = new AtomicInteger();

    // у атомарных переменных есть свои методы
    public void incrementValue() {
        value.incrementAndGet();
    }

    public int getValue() {
        return value.intValue();
    }
}
