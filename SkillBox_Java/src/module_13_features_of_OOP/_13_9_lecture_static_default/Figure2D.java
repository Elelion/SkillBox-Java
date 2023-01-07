package module_13_features_of_OOP._13_9_lecture_static_default;
public interface Figure2D {
    static Figure2D createFigure(Object data) {
        return null;
    }

    default Double getSquare() {
        return 0.0;
    }
}
