package module_17_multithreading._17_2_lecture_thread;

import java.io.File;

public class Threads {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_17_multithreading";
    private String pathLectureDir = "_17_2_lecture_thread";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    private int newWidth = 300;

    /**/

    public Threads() {
        String srcFolder = DATA_FILE + "src";
        String dstFolder = DATA_FILE + "dst";

        File srcDir = new File(srcFolder);
        long startTime = System.currentTimeMillis();
        File[] files = srcDir.listFiles();

        /**/

        int middle = files.length / 2;
        File[] files1 = new File[middle];

        // копируем из files в files1
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer resizer1 = new ImageResizer(
            files1,
            newWidth,
            srcFolder,
            dstFolder,
            startTime);

        //resizer1.start();
        new Thread(resizer1).start();

        File[] files2 = new File[files.length - middle];
        System.arraycopy(files, 0, files2, 0, files2.length);
        ImageResizer resizer2 = new ImageResizer(
            files2,
            newWidth,
            srcFolder,
            dstFolder,
            startTime);

        //resizer2.start();
        new Thread(resizer2).start();

        // запускаем параллельный поток
        new Thread(() -> {
            for (int i = 0; i < 59_000; i++) {
                System.out.println(i);
            }
        }).start();
    }
}
