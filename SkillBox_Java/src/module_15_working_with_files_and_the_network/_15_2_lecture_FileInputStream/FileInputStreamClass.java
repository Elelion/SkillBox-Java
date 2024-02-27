package module_15_working_with_files_and_the_network._15_2_lecture_FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileInputStreamClass {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_2_lecture_FileInputStream";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "text.txt";

    public FileInputStreamClass() {
        StringBuilder builder = new StringBuilder();
        String words = "";

        /**
         * FileInputStream - получает входные байты из файла в файловой системе
         * работает с помощью stream
         *
         * .read - читаем символ в файле и возвращает его код
         *
         * с низу обязательные catch, без которых is.read НЕ будет работать
         * два Exception нужны для того, если файл НЕ найден
         */
        try {
            // указываем файл из которого мы будем тянуть данные
            FileInputStream is = new FileInputStream(DATA_FILE);

            for (;;) {
                int code = is.read();

                if (code < 0) {
                    break;
                }

                char ch = (char) code;
                builder.append(ch);
                words += ch;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n-\n");
        consoleColorLog("Выводим builder");
        System.out.println(builder);

        /**/

        /**
         * разбиваем builder и выводим его как массив
         */
        System.out.println("\n-\n");
        consoleColorLog("Выводим wordsSplit");

        String[] wordsSplit = words.split(";");
        for (String s : wordsSplit) {
            System.out.println(s);
        }
    }

    private void consoleColorLog(String str) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
}
