package module_15_working_with_files_and_the_network._15_1_lecture_class_File;

import java.io.File;

public class FileClass {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_1_lecture_class_File";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
        + pathProject + File.separator
        + pathRootDir + File.separator
        + pathLectureDir + File.separator
        + "text.txt";

    public FileClass() {
        // относительный путь
        // File file = new File("SkillBox_Java/src/module_15_working_with_files_and_the_network/_15_1_lecture_class_File/text.txt");

        // абсолютный путь
        File file = new File(DATA_FILE);
        System.out.println(file);
        System.out.println(file.length());
        System.out.println(file.lastModified());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        System.out.println("-");

        File folder = new File("SkillBox_Java/src/module_15_working_with_files_and_the_network/_15_1_lecture_class_File");
        File[] files = folder.listFiles();

        for (File fileInFolder : files) {
            System.out.println(fileInFolder);
        }

        System.out.println("-");

        // указываем какая папка и где будет создана
        File createFolder = new File("SkillBox_Java/src/module_15_working_with_files_and_the_network/_15_1_lecture_class_File/new");

        // создаем
        createFolder.mkdir();

        // удаляем
        createFolder.delete();
    }
}
