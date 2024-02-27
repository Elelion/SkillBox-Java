package module_17_multithreading._17_2_lecture_thread;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

//public class ImageResizer extends Thread {
public class ImageResizer implements Runnable {
    private File[] files;
    private int newWidth;
    private String dstFolder;
    private String srcFolder;
    private long startTime;

    public ImageResizer(File[] files, int newWidth, String srcFolder, String dstFolder, long startTime) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.srcFolder = srcFolder;
        this.startTime = startTime;
    }

    /**/

    /**
     * создаем поток!!!
     *
     * переопределяем run() и описываем в нем то, что мы хотим что бы
     * выполнялось в отдельном потоке
     *
     * для запуска потока надо в классе где мы вызываем ImageResizer
     * пишем imageResizer.start();
     */
    @Override
    public void run() {
        File srcDir = new File(srcFolder);

        /**
         * BufferedImage - подкласс описывает Image с доступным буфером
         * данных изображения. Те это класс в Java, предоставляющий простой
         * интерфейс для работы с изображениями в памяти. Он позволяет
         * создавать, изменять и работать с изображениями в памяти, не
         * используя дисковое пространство.
         *
         * ImageIO.read - этот пакет помогает читать и писать файлы изображений.
         * Те он является статическим методом класса ImageIO в Java, который
         * используется для чтения изображения из потока ввода. Этот метод
         * принимает поток ввода, и возвращает изображение, загруженное из
         * потока ввода.
         *
         * TYPE_INT_BGR - Представляет изображение с 8-битными компонентами
         * цвета RGB,соответствующее цветовой модели BGR в стиле Windows или
         * Solaris,с цветами Blue,Green и Red,упакованными в целочисленные
         * пиксели.
         *
         * .getRGB(...) - Возвращает целочисленный пиксель в стандартной цветовой
         * модели RGB (TYPE_INT_ARGB) и цветовом пространстве sRGB по умолчанию.
         */
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);

                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = new BufferedImage(
                    newWidth, newHeight, BufferedImage.TYPE_INT_BGR
                );

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for (int x = 0; x < newWidth; x++) {
                    for (int y = 0; y < newHeight; y++) {
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - startTime) + " мс");
    }
}
