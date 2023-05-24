package module_18_efficiency._18_18_practical_CarNumberGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

public class CarNumberGenerator {

    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_18_efficiency";
    private String pathLectureDir = "_18_18_practical_CarNumberGenerator";
    private final String FILENAME =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "numbers";

    /**/

    public CarNumberGenerator() throws FileNotFoundException {

        // 3 000 - в один файл
        // 1 000 - в 8 файлов
        new MyThreads();
//        new _MyThreads();

        for (int i = 0; i < 8; i++) {
            System.out.println(FILENAME + i + ": ");
            getWordCount(FILENAME + i + ".txt");
        }
    }

    /**/

    private static void getWordCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        int words = 0;
        int lines = 0;

        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
            lines++;
        }

        System.out.println("Number of words: " + convertFormatNumber(words));
        System.out.println("Number of lines: " + convertFormatNumber(lines));
        scanner.close();
    }

    private static String convertFormatNumber(int amount) {
        NumberFormat formatNum = NumberFormat.getInstance();
        return formatNum.format(amount);
    }
}

