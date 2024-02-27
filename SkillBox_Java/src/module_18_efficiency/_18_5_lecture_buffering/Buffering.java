package module_18_efficiency._18_5_lecture_buffering;

import java.io.*;

public class Buffering {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_18_efficiency";
    private String pathLectureDir = "_18_5_lecture_buffering";
    private final String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "numbers.txt";

    public Buffering() throws IOException {
        long start = System.currentTimeMillis();

        /**
         * можем использовать так же PrintWriter за место FileOutputStream
         * тк PrintWriter - автоматически записывает файл тогда, когда
         * он сам считает что размер достиг предельного значения и его
         * нужно записать
         *
         * Ниже мы убираем блок if где сбрасывали в ручную StringBuilder
         * и производили запись
         */
        // FileOutputStream writer = new FileOutputStream(FILENAME);
        PrintWriter writer = new PrintWriter(FILENAME);

        char[] letters = {'Y', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};

        /**
         * int regionCode = 199; - выносим на ружу, что бы каждую итерацию не
         * пересоздавать переменную в ОЗУ
         *
         * далее мы добавляем еще один цикл и убираем int regionCode = 199;
         * и прогоняем регионы, что бы усложнить наши вычисления
         *
         * теперь когда мы начали использовать PrintWriter - то мы можем снова
         * перенести наш StringBuilder обратно в цикл
         */
        // int regionCode = 199;
        // StringBuilder builder = new StringBuilder();

        for (int regionCode = 1; regionCode < 100; regionCode++) {

            /**
             * те для каждого региона будет создаваться новый StringBuilder
             */
            StringBuilder builder = new StringBuilder();

            for (int number = 1; number < 1_000; number++) {
                /**
                 * помещаем именно сюда, что бы при каждой итерации родительского
                 * for наш StringBuilder пересоздавался. Если бы мы разместили
                 * StringBuilder выше родительского for, то в StringBuilder
                 * добавлялись бы вообще все номера учитывая и родительскую
                 * итерацию, а это увеличивает время работы программы, тк
                 * StringBuilder был бы не вероятно раздутым и в конечном
                 * итоге мы бы получили ошибку - OutOfMemoryError - говорящую
                 * о том, что мы переполнили память у StringBuilder
                 *
                 * соответственно мы производим и запись в файл
                 *
                 * теперь мы вынесем наш StringBuilder на верх, что бы он не был
                 * в циклах, а сбрасывать мы его будем в цикле... это позволит еще
                 * больше оптимизировать расход памяти
                 */
                // StringBuilder builder = new StringBuilder();

                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {
                            builder.append(firstLetter);
                            builder.append(padNumber(number));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode));
                            builder.append("\n");

                        /*
                        String charNumber = firstLetter + padNumber(number) +
                            secondLetter + thirdLetter + padNumber(regionCode);
                        writer.write(charNumber.getBytes());
                        writer.write('\n');
                        */

                            /**
                             * 1024 = 1kb
                             *
                             * но ту мы начали использовать PrintWriter, то
                             * переписываем наш блок if
                             *
                             * В отличии от FileOutputStream, наш PrintWriter
                             * сам проверяет переполненность записи
                             */
                            /*
                            if (builder.length() > 1024) {
                                writer.write(builder.toString().getBytes());

                                // очищаем наш StringBuilder
                                builder = new StringBuilder();
                            }
                            */

                            // выносим его на уровень StringBuilder
                            // writer.write(builder.toString());
                        }
                    }
                }

                /**
                 * убираем от сюда, запись будет теперь при достижении
                 * лимита StringBuilder. См выше в цикле
                 */
                // writer.write(builder.toString().getBytes());
            }

            writer.write(builder.toString());
        }

        /**
         * flush - скидывает из буффера все оставшиеся данные нашего файла
         * тк PrintWriter - реализует работу через буффер
         * те он накапливает данные, и когда они достигнут максимального размера
         * в буффере - то PrintWriter сбрасывает их и начинает копить по новой
         */
        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private String padNumber(int number) {
        String numberStr = Integer.toString(number);
        int padSize = 3 - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }

        return numberStr;
    }
}
