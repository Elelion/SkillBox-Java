package module_17_multithreading._17_20_lecture_ForkJoinPool_RecursiveTask;

import java.util.Collection;

public interface Node {
    /**
     * Есть некое дерево состоящие из узлов.
     * Есть корневой узел и есть дети
     * У каждого узла может быть задано значение
     *
     * нужно посчитать сумму значений во всем дереве
     */
    Collection<Node> getChildren();

    long getValue();
}
