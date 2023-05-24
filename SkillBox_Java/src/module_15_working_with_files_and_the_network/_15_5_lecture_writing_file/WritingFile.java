package module_15_working_with_files_and_the_network._15_5_lecture_writing_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WritingFile {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_5_lecture_writing_file";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "file.txt";

    public WritingFile() {
        consoleColorLog("1 - PrintWriter");

        try {
            PrintWriter writer = new PrintWriter(DATA_FILE);
            writer.write("Hello world");

            /**
             * flush - сбрасывает буффер, буффер нужен для записи, он запоминает
             * некоторое кол-во символов, и потом сразу одним потоком записывает
             * данные на диск. Если записывать каждый байт отдельно а не потоком
             * то это будет слишком накладно для ресурсов.
             *
             * close - закрыть файл
             */
            writer.flush();
            writer.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        /**/

        consoleColorLog("2 - Files");

        try {
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                strings.add(Integer.toString(i));
            }

            Files.write(Paths.get(DATA_FILE), strings);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void consoleColorLog(String str) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
}
