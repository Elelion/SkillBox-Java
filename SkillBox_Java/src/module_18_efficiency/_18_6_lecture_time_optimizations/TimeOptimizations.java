package module_18_efficiency._18_6_lecture_time_optimizations;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TimeOptimizations {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_18_efficiency";
    private String pathLectureDir = "_18_5_lecture_buffering";
    private final String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "numbers.txt";

    public TimeOptimizations() throws IOException {
        long start = System.currentTimeMillis();
        PrintWriter writer = new PrintWriter(FILENAME);
        char[] letters = {'Y', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};

        /**
         * Самыми долгими операциями является создание объектов и запись на диск
         * Конкретно в нашем случае.
         *
         * Так же долгим является и запись данных в БД
         */
        for (int regionCode = 1; regionCode < 100; regionCode++) {
            StringBuilder builder = new StringBuilder();

            for (int number = 1; number < 1_000; number++) {
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

            writer.write(builder.toString());
        }

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
