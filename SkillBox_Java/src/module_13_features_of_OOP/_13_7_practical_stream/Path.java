package module_13_features_of_OOP._13_7_practical_stream;

public class Path {
    private final String path = this.getClass().getResource("").getPath();

    public String getPath() {
        return path;
    }
}
