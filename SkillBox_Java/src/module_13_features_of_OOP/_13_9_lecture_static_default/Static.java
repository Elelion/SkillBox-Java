package module_13_features_of_OOP._13_9_lecture_static_default;

import java.util.stream.Stream;

public class Static implements Figure2D {

    /**
     * Default методы можно реализовать в interface's
     * и так же их можно переопределять в классах наследниках
     */
    @Override
    public Double getSquare() {
        return Figure2D.super.getSquare();
    }

    // createFigure - переорпделить уже нельзя, тк он статический

    /**/

    /**
     * можно создавать Stream не создавая ни каких объектов
     * те создаем сразу некоторый поток данных
     */
    public Static() {
        System.out.println(Stream.of(1, 2, 3, 4, 5).count());
    }
}
