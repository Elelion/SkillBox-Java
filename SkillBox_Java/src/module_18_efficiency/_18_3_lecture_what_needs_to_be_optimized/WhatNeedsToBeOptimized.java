package module_18_efficiency._18_3_lecture_what_needs_to_be_optimized;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Данная программа отрабатывает за 5 - 6 сек
 * ее можно оптимизировать
 *
 * для начала можно оптимизировать метод записи на HDD
 * записывать НЕ по байтам, с разу весь поток данных
 *
 * но как это делать - см в сл разделах
 */
public class WhatNeedsToBeOptimized {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_18_efficiency";
    private String pathLectureDir = "_18_3_lecture_what_needs_to_be_optimized";
    private final String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "numbers.txt";

    public WhatNeedsToBeOptimized() throws IOException {
        long start = System.currentTimeMillis();

        FileOutputStream writer = new FileOutputStream(FILENAME);
        char[] letters = {'Y', 'K', 'E', 'H', 'X', 'B', 'A', 'P', 'O', 'C', 'M', 'T'};

        for (int number = 1; number < 1_000; number++) {
            int regionCode = 199;

            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        String charNumber = firstLetter + padNumber(number) +
                            secondLetter + thirdLetter + padNumber(regionCode);

                        writer.write(charNumber.getBytes());
                        writer.write('\n');
                    }
                }
            }
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
