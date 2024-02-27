package module_15_working_with_files_and_the_network._15_4_lecture_reading_with_files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilesClass {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_3_lecture_BufferedReader";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "text.txt";

    public FilesClass() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(line -> builder.append(line + "\n"));
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

