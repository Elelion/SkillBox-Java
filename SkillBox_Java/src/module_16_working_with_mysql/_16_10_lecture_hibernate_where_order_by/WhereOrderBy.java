package module_16_working_with_mysql._16_10_lecture_hibernate_where_order_by;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WhereOrderBy {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);

        /**
         * дописываем запрос тут
         *
         * builder - возвращает Expression (те позволяет выбрать запрос)
         * greaterThan - аналогично WHERE price > 100_000
         */
        query.select(root)
            .where(builder.greaterThan(root.get("price"), 100_000))
            .orderBy(builder.desc(root.get("price")));

        List<Course> courseList = session.createQuery(query).getResultList();

        for (Course course : courseList) {
            System.out.println(course.getName() + " - " + course.getPrice());
        }

        // обязательно!!!
        transaction.commit();
        sessionFactory.close();
    }
}
