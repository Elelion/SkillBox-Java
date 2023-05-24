package module_18_efficiency._18_18_practical_CarNumberGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class _1_MyThreads {
    private final int N = 100;
    int cores = Runtime.getRuntime().availableProcessors();

    public _1_MyThreads() {
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
        // Вариант №1
        // private PrintWriter writer = new PrintWriter(FILENAME);

        /**/

        public ForkThread(int from, int to) {
            this.from = from;
            this.to = to;
        }

        /**/

        /**
         * тут происходит запись по кол-ву потоков
         * но в каждый файл записывается одна и та же информация...
         * что не совсем верно
         */

        @Override
        protected void compute() {
            /**
             * number(100) - 0 <= 100 / cores(8) = 12.5
             * те если число будет равно = 12_500_000
             * то оно выполниться в один поток, а ЕСЛИ нет, ТО
             * будет разбиток столько раз, пока не станет равно 12_500_000
             */
            if (to - from <= N / cores ) {
                List<PrintWriter> writers = new ArrayList<>();

                /**
                 * добавляем файлы в которые будем записывать в массив
                 */
                for (int i = 0; i < cores; i++) {
                    try {
                        writers.add(new PrintWriter(FILENAME + i + ".txt"));
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }

                /**
                 * TODO: надо разбить номера на кол-во потоков
                 * 100 / 8 = 12.5
                 */
                for (int regionCode = 1; regionCode < N; regionCode++) {
                    StringBuilder builder = new StringBuilder();

                    // 1_000 - что бы файл не был огромным, урезаем до N=100
                    for (int number = 1; number < N; number++) {

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

                    // Вариант №1
                    // writer.write(builder.toString());

                    // Вариант №2
                    /**
                     * асинхронно записываем сразу в несколько файлов
                     * где 1 файл = 1 поток, всего потоков 8
                     */
                    synchronized (writers) {
                        for (PrintWriter writer : writers) {
                            writer.write(builder.toString());
                        }
                    }
                }

                // Вариант №2
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

                // Вариант №1
                // writer.flush();
                // writer.close();
            } else {
                int middle = (to + from) / 2;
                ForkThread firstHalf = new ForkThread(from, middle);
                ForkThread secondHalf = new ForkThread(middle, to);

                /**
                 * invokeAll() - это метод класса ForkJoinTask, который позволяет
                 * выполнить все задачи, переданные в виде списка, с помощью
                 * фреймворка Fork-Join. Каждая задача из списка будет выполнена
                 * асинхронно в своем потоке, а метод invokeAll() будет блокировать
                 * текущий поток до тех пор, пока все задачи не будут выполнены.
                 *
                 * Метод invokeAll() возвращает список результатов выполнения
                 * каждой задачи в порядке, в котором они были переданы в список.
                 * Если задача не возвращает результат, то в качестве результата
                 * ей будет присвоено значение null.
                 *
                 * Использование метода invokeAll() особенно полезно в тех случаях,
                 * когда нужно распараллелить выполнение большого количества задач.
                 */
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

        /**/

        // Вариант №1 - выполняется дольше
        /*
        StringBuilder sb = new StringBuilder(3);

        if (number < 10) {
            sb.append("00").append(number);
        } else if (number < 100) {
            sb.append("0").append(number);
        } else {
            sb.append(number);
        }
        return sb.toString();
         */

        /**/

        // Вариант №2 - вообще тормаз
        /**
         * %03d является спецификатором формата для форматирования чисел,
         * где 3 - это минимальное количество символов, которые должны быть
         * зарезервированы для числа, а 0 - это символ-заполнитель, который
         * будет добавлен слева, если число занимает меньше зарезервированного
         * места. Например, если число равно 5, то %03d выведет "005".
         * Это позволяет легко форматировать числа с заданным количеством
         * цифр и добавлять ведущие нули, если это необходимо.
         */
        /*
        String numberStr = String.format("%03d", number);
        return numberStr;
         */

        // Вариант №3 - хуже варианта №2
        // return new Formatter().format("%03d", number).toString();

        // Вариант №4 - цикл в базовом варианте все ровно быстрее...
        /*
        StringBuilder sb = new StringBuilder(3);

        if (number < 10) {
            sb.append("00");
        } else if (number < 100) {
            sb.append("0");
        }

        sb.append(number);
        return sb.toString();
         */
    }
}

