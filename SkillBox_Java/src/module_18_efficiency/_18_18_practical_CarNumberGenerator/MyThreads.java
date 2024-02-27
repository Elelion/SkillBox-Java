package module_18_efficiency._18_18_practical_CarNumberGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MyThreads {
    private final int N = 100;
    int cores = Runtime.getRuntime().availableProcessors();

    public MyThreads() {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new ForkThread(0, N)));

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    /**/

    public class ForkThread extends RecursiveAction {
        private String pathProject = "SkillBox_Java" + File.separator + "src";
        private String pathRootDir = "module_18_efficiency";
        private String pathLectureDir = "_18_18_practical_CarNumberGenerator";
        private final String FILENAME =
            System.getProperty("user.dir") + File.separator
                + pathProject + File.separator
                + pathRootDir + File.separator
                + pathLectureDir + File.separator
                + "numbers";

        private int from;
        private int to; // N
        private char[] letters = {'Y', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};

        /**/

        public ForkThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        /**/

        @Override
        protected void compute() {
            if (to - from <= N / cores ) {
                /**
                 * сюда пихаем наши файлы которые будут созданы ниже
                 */
                List<PrintWriter> writers = new ArrayList<>(cores);

                /**
                 * number(100) - 0 <= 100 / cores(8) = 12.5
                 * те если число будет равно = 12.5 (будет округлено до 12)
                 * то оно выполниться в один поток, а ЕСЛИ нет, ТО
                 * будет разбиток столько раз, пока не станет равно 12
                 */
                for (int i = 0; i < cores; i++) {
                    try {
                        writers.add(new PrintWriter(FILENAME + i + ".txt"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                /**/

                for (int regionCode = 1; regionCode < N; regionCode++) {
                    StringBuilder builder = new StringBuilder();

                    // 1_000 - что бы файл не был огромным, урезаем до N=100
                    for (int number = from + 1; number <= to; number++) {

                        // 12 / 12 / 12
                        for (char firstLetter : letters) {
                            for (char secondLetter : letters) {
                                for (char thirdLetter : letters) {
                                    builder.append(firstLetter);
                                    builder.append(padNumber(number));
                                    builder.append(secondLetter);
                                    builder.append(thirdLetter);
                                    builder.append(padNumber(regionCode));
                                    builder.append("\n");
                                }
                            }
                        }
                    }

                    /**
                     * асинхронно записываем сразу в несколько файлов
                     * где 1 файл = 1 поток, всего потоков 8
                     *
                     * Потом считаем индекс, который будет использоваться для
                     * записи ТЕКУЩЕЙ порции номеров в файл. Индекс вычисляется
                     * как (regionCode - 1) % cores,
                     *
                     * Таким образом, порции номеров будут равномерно распределены
                     * между всеми записями в файлы
                     *
                     * Полученная запись затем используется для записи текущей
                     * порции номеров в файл...
                     *
                     * те
                     * int writerIndex = (regionCode - 1) % cores;
                     * дает индекс, по которому мы потом определяем файл куда будем
                     * записывать данные
                     */
                    synchronized (writers) {
                        int writerIndex = (regionCode - 1) % cores;
                        PrintWriter writer = writers.get(writerIndex);

                        writer.write(builder.toString());
                    }
                }

                /**
                 * далее мы завершаем запись для каждого нашего файла
                 * в который мы записывали данные (см выше в synchronized())
                 */
                synchronized (writers) {
                    for (PrintWriter writer : writers) {
                        writer.flush();
                        writer.close();
                    }
                }
            } else {
                int middle = (to + from) / 2;
                ForkThread firstHalf = new ForkThread(from, middle);
                ForkThread secondHalf = new ForkThread(middle, to);

                invokeAll(firstHalf, secondHalf);
            }
        }
    }

    /**
     * Вычитаем 3 - длинна строки int padSize = 3 - numberStr.length();
     * для того, что бы, при передаче например 3 цифр - не чего не
     * расчитывалось, тк уже и так есть 3 цифры в номере
     *
     * при передачи длинны в 2, будет 3 - 2 = 1 те одну цифру мы генерируем
     * и дописываем итд...
     */
    private String padNumber(int number) {
        String numberStr = Integer.toString(number);
        int padSize = 3 - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }
}

