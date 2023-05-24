package module_16_working_with_mysql._16_5_lecture_hibernate_change_in_table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;

public class HibernateDB {
    private String pathProject = "SkillBox_Java" + File.separator + "src";
    private String pathRootDir = "module_16_working_with_mysql";
    private String pathLectureDir = "_16_4_lecture_hibernate";
    private String DATA_FILE =
        System.getProperty("user.dir") + File.separator
            + pathProject + File.separator
            + pathRootDir + File.separator
            + pathLectureDir + File.separator;

    /**
     * рекомендуется sessionFactory делать один раз на все приложение
     * те раз сделал а потом только получаешь данные
     */
    public HibernateDB() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        // получаем товар из таблици good с id = 1
//        Good good = session.get(Good.class, 1);
//        System.out.println(good.getName());

        Transaction transaction = session.beginTransaction();

        // сохранить новую запись
        /*
        Good good = new Good();
        good.setName("Новая вещь");
        good.setPrice(200);
        good.setCategoryId(3);
        good.setCount(50);
        */

        // изменить имеющуюся
        Good good = session.get(Good.class, 1059);
        good.setName("Измененная вещь");

        // сохраняем наши данные в БД
        session.save(good);

        // обязательно!!!
        transaction.commit();
        sessionFactory.close();
    }
}
