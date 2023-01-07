package module_15_working_with_files_and_the_network._15_3_lecture_BufferedReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class BufferedReaderClass {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_3_lecture_BufferedReader";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "text.txt";

    public BufferedReaderClass() {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(DATA_FILE));

            for (;;) {
                String line = br.readLine();

                if (line == null) {
                    break;
                }

                builder.append(line + "\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(builder);
    }

    private void consoleColorLog(String str) {
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RESET = "\u001B[0m";

        System.out.println(ANSI_GREEN + str + ANSI_RESET);
    }
}
