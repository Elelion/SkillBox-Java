package module_18_efficiency._18_18_practical_CarNumberGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class _2_MyThreads {
    private final int N = 100;
    int cores = Runtime.getRuntime().availableProcessors();

    public _2_MyThreads() {
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

        /**
         * Тут происходит запись по кол-ву номеров
         * те будет создано 100 файлов
         */
        @Override
        protected void compute() {
            if (to - from <= N / cores ) {
                int numbersPerFile = N / cores;
                int fromNumber = from * numbersPerFile + 1;
                int toNumber = to * numbersPerFile;

                for (int i = from; i < to; i++) {
                    int regionCode = i + 1;
                    StringBuilder builder = new StringBuilder();

                    for (int number = fromNumber; number <= toNumber; number++) {
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

                    try (PrintWriter writer = new PrintWriter(FILENAME + i + ".txt")) {
                        writer.write(builder.toString());
                        writer.flush();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
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
        // Вариант №Базовый - ТОП по быстроте
        String numberStr = Integer.toString(number);
        int padSize = 3 - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }
}

