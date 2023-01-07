package module_4_objects_and_classes_Part_1;

public class _4_10_1_practical_Arithmetic {
    /**
     * TODO: Задача 4.10 - 1
     * - Создайте класс Arithmetic с двумя переменными — числами типа int.
     *
     * - Создайте в этом классе конструктор, принимающий два параметра — тоже
     * числа типа int. В конструкторе сохраняйте переданные параметры в переменных
     * класса.
     *
     * - В созданном классе реализуйте методы, вычисляющие различные
     * величины (значения) на основе переменных класса, а именно:
     * • сумму чисел;
     * • произведения чисел;
     * • максимальное из двух чисел;
     * • минимальное из двух чисел.
     *
     * - Имена методов придумайте самостоятельно.
     */

    private int a = 0;
    private int b = 0;

    public _4_10_1_practical_Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;

        System.out.println("Сумма: " + sum(this.a, this.b));
        System.out.println("Умножение: " + multiplication(this.a, this.b));
        System.out.println("max: " + max(this.a, this.b));
        System.out.println("min: " + min(this.a, this.b));
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int max(int a, int b) {
        return Math.max(a, b);
    }

    public int min(int a, int b) {
        return Math.min(a, b);
    }
}
