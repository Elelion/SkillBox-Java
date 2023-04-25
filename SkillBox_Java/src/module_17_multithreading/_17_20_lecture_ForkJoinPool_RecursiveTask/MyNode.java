package module_17_multithreading._17_20_lecture_ForkJoinPool_RecursiveTask;

import java.util.Collection;
import java.util.List;

public class MyNode implements Node {
    private long value;
    private List<Node> children;

    public MyNode(long value, List<Node> children) {
        this.value = value;
        this.children = children;
    }

    public long getValue() {
        return value;
    }

    public Collection<Node> getChildren() {
        return children;
    }
}
