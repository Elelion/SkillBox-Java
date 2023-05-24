package module_17_multithreading._17_20_lecture_ForkJoinPool_RecursiveTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask<Long> - нужно для расчета суммы дерева
 */
public class NodeValueSumCalc extends RecursiveTask<Long> {
    private Node node;

    public NodeValueSumCalc(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<NodeValueSumCalc> taskList = new ArrayList<>();

        for (Node child : node.getChildren()) {
            NodeValueSumCalc task = new NodeValueSumCalc(child);

            // ответвляем нашу задачу
            task.fork();

            taskList.add(task);
        }

        for (NodeValueSumCalc task : taskList) {
            /**
             * join дожидается выполнение КАЖДОЙ из этих задач и возвращает
             * ее обратно в поток
             */
            sum += task.join();
        }

        return sum;
    }
}
