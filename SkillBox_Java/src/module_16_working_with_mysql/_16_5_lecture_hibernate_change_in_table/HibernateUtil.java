package module_16_working_with_mysql._16_5_lecture_hibernate_change_in_table;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static String pathProject = "SkillBox_Java" + File.separator + "src";
    private static String pathRootDir = "module_16_working_with_mysql";
    private static String pathLectureDir = "_16_4_lecture_hibernate";
    private static String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            //load from different directory
            SessionFactory sessionFactory = new Configuration().configure(
                    DATA_FILE + "hibernate.cfg.xml")
//                    "/Applications/MAMP/htdocs/SkillBox_Java_project/SkillBox_Java/src/module_16_working_with_mysql/_16_4_lecture_hibernate/hibernate.cfg.xml")
//                    "/SkillBox_Java/src/module_16_working_with_mysql/_16_4_lecture_hibernate/hibernate.cfg.xml")
                .buildSessionFactory();

            return sessionFactory;

        } catch (Throwable ex) {
            //Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        //Close caches and connection pools
        getSessionFactory().close();
    }
}
