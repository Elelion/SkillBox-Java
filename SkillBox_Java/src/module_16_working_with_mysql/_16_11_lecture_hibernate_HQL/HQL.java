package module_16_working_with_mysql._16_11_lecture_hibernate_HQL;

import module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models.Subscription;
import module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models.SubscriptionKey;
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

public class HQL {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure("hibernate.cfg.xml")
            .build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//         studentId = 1; courseId = 2
        Subscription subscription = session.get(
            Subscription.class,
            new SubscriptionKey(1, 2));

        System.out.println(subscription.getSubscriptionDate());
//
        /*
        для примера из ДЗ

        Subscription subscription = session.get(
            SubscriptionKey.class,
            new PK(studentId, courseId));
         */

        // обязательно!!!
        transaction.commit();
        sessionFactory.close();
    }
}
