package module_16_working_with_mysql._16_4_lecture_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class Hibernate {
    /*
    Hibernate - библиотека предназначенная для работы с БД. Позволяет
    «соединить» программные сущности и соответствующие записи в базе (те
    объект = бд). Те идея в том, что бы - создать «виртуальную» базу
    данных из программных объектов и работать с ней как с реальной базой.

    соединение нужно создавать одно на каждое приложение
    а не по каждому соединению на каждый класс

    соединение в конце ВСЕГДА нужно закрывать!!!

    - Если соединение не закрывать, и каждый раз создавать дальше, то их может
    набраться определенное кол-во, и после этого новое соединение нельзя будет
    уже создать. Кол-во мы задаем тут:
    <property name="connection.pool_size">10</property>

    - что бы в консоль печатались SQL запросы, мы пишем это:
    <property name="show_sql">true</property>

    - сверяет структуру БД со структурой классов
    использовать только validate / update,
    осторожно использовать, и только для разработки create / create drop
    create - создает БД удаляя предыдущие данные (те только при запуске удаляет)
    create-drop - после завершения приложения удаляет полностью БД
    <property name="hbm2ddl.auto">validate</property>

    - что бы класс подцепился в наш Hibernate мы должны указать его
    <mapping class="className"></mapping>
     */

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
    public Hibernate() {
        /**
         * но так работать НЕ будет
         * для hibernate нужен новый Maven проект с нужными зависимости
         * и что бы конфиг лежал обязательно по пути
         * src/main/resources/hibernate.cfg.xml
         */
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//            .configure(DATA_FILE + "hibernate.cfg.xml")
//            .build();

//        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//        Session session = sessionFactory.openSession();
        Session session = HibernateUtil.getSessionFactory().openSession();

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
//        sessionFactory.close();
        HibernateUtil.shutdown();
    }
}
