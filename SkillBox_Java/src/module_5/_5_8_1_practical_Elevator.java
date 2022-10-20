package module_5;

public class _5_8_1_practical_Elevator {
    /**
     * TODO: Задание 5.8 - 1
     * Папка в репозитории не содержит готового проекта, вам необходимо
     * создать проект с нуля. Создайте новый проект Encapsulation и в нём
     * класс Elevator, эмулирующий работу пассажирского лифта. В классе создайте:
     *
     * - Переменные currentFloor (текущий этаж), minFloor и maxFloor (минимальный
     * и максимальный этажи). Тип переменных — int.
     *
     * - Конструктор с двумя параметрами minFloor и maxFloor, сохраняющий
     * эти параметры в соответствующих переменных класса.
     *
     * - Значение переменной currentFloor изначально должно быть равно 1.
     *
     * - Метод getCurrentFloor, возвращающий текущий этаж, на котором находится лифт.
     *
     * - Метод moveDown, перемещающий лифт на один этаж вниз (уменьшающий
     * значение переменной currentFloor на единицу).
     *
     * - Метод moveUp, перемещающий лифт на один этаж вверх.
     *
     * - Метод move(int floor), перемещающий лифт на заданный в параметре этаж,
     * если он задан верно. Если параметр у метода задан неверно, ничего не
     * делать и выводить в консоль сообщение об ошибке. Этот метод может
     * перемещать лифт только последовательно, по одному этажу, с помощью
     * циклов и методов moveUp и moveDown, и он должен выводить в консоль
     * текущий этаж после каждого перемещения между этажами.
     */

    private int currentFloor = 1;
    private final int minFloor;
    private final int maxFloor;

    public _5_8_1_practical_Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    /**/

    private int getCurrentFloor() {
        return currentFloor;
    }

    private void showCurrentFloor() {
        if (currentFloor != 0) {
            System.out.println("Текущий этаж: " + getCurrentFloor());
        }
    }

    /**/

    private void moveDown() {
        if (currentFloor > minFloor) {
            currentFloor--;
        }
    }

    private void moveUp() {
        if (currentFloor < maxFloor) {
            currentFloor++;
        }
    }

    /**/

    private void moveUpStep(int current, int floor) {
        for (int i = current; i < floor; i++) {
            moveUp();
            showCurrentFloor();
        }
    }

    private void moveDownStep(int current, int floor) {
        for (int i = current; i > floor; i--) {
            moveDown();
            showCurrentFloor();
        }
    }

    /**/

    public void move(int floor) {
        int current = getCurrentFloor();

        // Вариант №1 - код показался слишком сложным, решил упростить
        /*
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Введен не корректный этаж");
        } else if (currentFloor < floor) {
            for (int i = current; i < floor; i++) {
                moveUp();
                showCurrentFloor();
            }
        } else if (currentFloor > floor) {
            for (int i = current; i > floor; i--) {
                moveDown();
                showCurrentFloor();
            }
        }
        */

        // Вариант №2
        if (floor < minFloor || floor > maxFloor) {
            System.out.println("Введен не корректный этаж");
        } else if (currentFloor < floor) {
            moveUpStep(current, floor);
        } else if (currentFloor > floor) {
            moveDownStep(current, floor);
        }

        System.out.println("Вы приехали на " + currentFloor + " этаж");
    }
}
