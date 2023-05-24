package module_15_working_with_files_and_the_network._15_10_lecture_configuration_files;

import java.io.*;
import java.util.Properties;

public class ConfigurationFiles {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_15_working_with_files_and_the_network";
    private String pathLectureDir = "_15_10_lecture_configuration_files";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    public ConfigurationFiles() {
        /**
         * Конфигурационные файлы всегда состоят из ключей и значений
         * а работать с ними нужно через utils класс Properties
         */
        Properties properties = new Properties();

        // задаем значения
        properties.setProperty("timeout", "3600");
        properties.setProperty("cacheSize", "10000");

        // сохраняем в файл
        try {
            properties.store(
                new FileOutputStream(DATA_FILE + "data/config.proporties"),
                "test config"
            );
            System.out.println("config saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /**/

        // читаем данные из нашего записанного файла
        try {
            properties.load(
                new FileInputStream(DATA_FILE + "data/config.proporties")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(properties.get("cacheSize"));

        /**
         * существует еще один популярный формат данных - .yml, пример его
         * написания см в папке /data
         */
    }
}
