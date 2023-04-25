package module_17_multithreading._17_20_lecture_ForkJoinPool_RecursiveTask;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyNode_2 {
    private long value;
    private List children;

    public MyNode_2(long value, List children) {
        this.value = value;
        this.children = children;
    }

    public long getValue() {
        return value;
    }

    public Collection getChildren() {
        return children;
    }
}
