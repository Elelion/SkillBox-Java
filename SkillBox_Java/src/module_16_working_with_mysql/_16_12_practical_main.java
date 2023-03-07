package module_16_working_with_mysql;

import module_16_working_with_mysql._16_12_practical_SQLAndHibernate.SQLAndHibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class _16_12_practical_main {
    private static String pathProject = "SkillBox_Java" + File.separator + "src";
    private static String pathRootDir = "module_16_working_with_mysql";
    private static String pathLectureDir = "_16_12_practical_SQLAndHibernate";
    private static String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    /**/

    public static void main(String[] args) throws FileNotFoundException {
        Properties properties = new Properties();

        try {
            properties.load(
                new FileInputStream(DATA_FILE + "data/config.proporties")
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SQLAndHibernate sqlAndHibernate = new SQLAndHibernate(
            properties.get("url").toString(),
            properties.get("user").toString(),
            properties.get("pass").toString()
        );
    }
}
