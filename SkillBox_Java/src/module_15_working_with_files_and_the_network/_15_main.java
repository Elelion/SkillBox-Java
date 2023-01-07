package module_15_working_with_files_and_the_network;

import module_15_working_with_files_and_the_network._15_2_lecture_FileInputStream.FileInputStreamClass;
import module_15_working_with_files_and_the_network._15_3_lecture_BufferedReader.BufferedReaderClass;
import module_15_working_with_files_and_the_network._15_4_lecture_reading_with_files.FilesClass;
import module_15_working_with_files_and_the_network._15_4_practical_FolderSizeMeter.FolderSizeMeter;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class _15_main {
    public static void main(String[] args) {
        System.out.println("Лекция 15.1");
//        FileClass lecture1 = new FileClass();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 15.2");
//        FileInputStreamClass lecture2 = new FileInputStreamClass();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 15.3");
//        BufferedReaderClass lecture3 = new BufferedReaderClass();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("---");

        /* ----------------------------------------------------------------- */

        System.out.println("Лекция 15.4");
//        FilesClass lecture4 = new FilesClass();
        System.out.println(System.lineSeparator() + "-" + System.lineSeparator());
        System.out.println("-");

        System.out.println("Лекция 15.4 - практика");
        FolderSizeMeter practical4_1 = new FolderSizeMeter();

        String pathProject = "SkillBox_Java" + File.separator + "src";
        String pathRootDir = "module_15_working_with_files_and_the_network";
        String pathLectureDir = "_15_4_practical_FolderSizeMeter";
        String DATA_FILE = System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator
            + "text.txt";

        // while (true) {
            System.out.println("Введите путь к папке или файлу: ");
            // String path = new Scanner(System.in).nextLine();
            File folder = new File(DATA_FILE);
            Date folderDate = new Date(folder.lastModified());
            System.out.println("Hrs: " + folderDate.getHours());

            // янв - 0, дек - 11
            System.out.println("Month: " + folderDate.getMonth());

            /**
             * 0 - Sunday
             * 1 - Monday
             * 2 - Tuesday
             * 3 - Wednesday
             * 4 - Thursday
             * 5 - Friday
             * 6 - Saturday
             */
            System.out.println("Day: " + folderDate.getDay());

            // текущее число (месяца)
            System.out.println("Date: " + folderDate.getDate());

            // full date and time
            // String size = practical4_1.getHumanReadableSize(practical4_1.getFolderSize(folder));
            String size = practical4_1.getHumanReadableSize(practical4_1.getFolderSize(folder));
            System.out.println("Размер папки / файла: " + size);
        // }


        System.out.println("---");

        /* ----------------------------------------------------------------- */


    }
}
