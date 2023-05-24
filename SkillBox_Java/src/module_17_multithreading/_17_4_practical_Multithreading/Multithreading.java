package module_17_multithreading._17_4_practical_Multithreading;

import module_17_multithreading._17_2_lecture_thread.ImageResizer;

import java.io.File;


public class Multithreading {
    /**
     * TODO:
     *
     * Напишите программу уменьшения изображений на основе проекта
     * ImageResizer. Она должна запускать число потоков, равное количеству
     * ядер процессора вашего компьютера.
     */

    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_17_multithreading";
    private String pathLectureDir = "_17_4_practical_Multithreading";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    private int newWidth = 300;

    public Multithreading() {
        String srcFolder = DATA_FILE + "src";
        String dstFolder = DATA_FILE + "dst";

        File srcDir = new File(srcFolder);
        long startTime = System.currentTimeMillis();

        int coresCPU = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер процессора: " + coresCPU);

        File[] files = srcDir.listFiles();
        System.out.println("Файлов: " + files.length);

        int middle = files.length / coresCPU;
        System.out.println("middle кол-во: " + middle);

        /**/

        // new Thread() - оставляем для примера, все что будет в нутри - поток
//        new Thread(() -> {
            if (coresCPU == 1) {
                System.out.println("-> if (...)");

                File[] files1 = new File[middle];
                takeThread(files, files1, srcFolder, dstFolder, startTime);

            } else {
                System.out.println("-> else (...)");

                for (int i = 0; i < coresCPU; i++) {
                    File[] filesArr = new File[files.length - middle];
                    takeThread(files, filesArr, srcFolder, dstFolder, startTime);
                }
            }
//        }).start();

    }

    private void takeThread(
        File[] files,
        File[] filesParts,
        String srcFolder,
        String dstFolder,
        long startTime
    ) {
        System.arraycopy(
            files,
            0,
            filesParts,
            0,
            filesParts.length);

        /**
         * Важно!!!
         * 
         * после запуска на объекте потока нужно делать join, потому что иначе
         * главный поток просто завершит работу, не дав закончить
         * остальным потокам
         */
        new Thread(
            new ImageResizer(
                filesParts,
                newWidth,
                srcFolder,
                dstFolder,
                startTime)
        ).start();
    }
}
