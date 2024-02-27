package module_17_multithreading._17_20_lecture_ForkJoinPool_RecursiveTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * RecursiveTask<Long> - нужно для расчета суммы дерева
 */
public class NodeValueSumCalc_2 extends RecursiveTask<Long> {
    private Node node;

    public NodeValueSumCalc_2(Node node) {
        this.node = node;
    }

    @Override
    protected Long compute() {
        long sum = node.getValue();
        List<NodeValueSumCalc_2> taskList = new ArrayList<>();

        for (Node child : node.getChildren()) {
            NodeValueSumCalc_2 task = new NodeValueSumCalc_2(child);

            // ответвляем нашу задачу
            task.fork();

            taskList.add(task);
        }

        for (NodeValueSumCalc_2 task : taskList) {
            /**
             * join дожидается выполнение КАЖДОЙ из этих задач и возвращает
             * ее обратно в поток
             */
            sum += task.join();
        }

        return sum;
    }
}
