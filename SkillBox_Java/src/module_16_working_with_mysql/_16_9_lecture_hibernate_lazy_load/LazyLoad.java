package module_16_working_with_mysql._16_9_lecture_hibernate_lazy_load;

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

public class LazyLoad {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /**
         * Интерфейс CriteriaBuilder - Используемый, чтобы создать запросы
         * критериев, соедините выборы, выражения, предикаты, упорядочивания.
         *
         * CriteriaQuery - Базовая семантика запроса Criteria состоит из
         * предложений SELECT, FROM и необязательного WHERE, аналогичных
         * запросу JPQL
         *
         * Root - не знаю, так надо...
         */
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Course> query = builder.createQuery(Course.class);
        Root<Course> root = query.from(Course.class);
        query.select(root);
        List<Course> courseList = session.createQuery(query).getResultList();

        for (Course course : courseList) {
            System.out.println(course.getName());
        }

        // LazyLoad - см в Course.java

        // обязательно!!!
        transaction.commit();
        sessionFactory.close();
    }
}
