package module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Аннотация @EmbeddedId говорит, что этот параметр
 * является составным ключом.
 *
 * Если поля ключа использовать и в основном классе @Entity, то необходимо
 * запретить использование полей для вставки и обновления данных
 * дополнительными параметрами insertable и updatable в
 * аннотации @Column. Для вставки значений ключа используйте
 * поля объекта SubscriptionKey id.
 *
 * @Getter - создаст сама getters
 * @Setter - создаст сама setters
 * @Data - создаст сама getters + setters
 */
@Entity
@Data
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "subscription_date")
    private LocalDateTime subscriptionDate;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    /* ----------------------------------------------------------------- */

//    public Subscription(Course_DB course, Student_DB student) {
//     public Subscription(int courseId, int studentId) {
//         this.courseId = courseId;
//         this.studentId = studentId;

//        this.course = course;
//        this.student = student;
//    }

    /* ----------------------------------------------------------------- */

    /*
    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
     */

    /* ----------------------------------------------------------------- */

    // в верху
//    @Column(name = "student_id", insertable = false, updatable = false)
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @ManyToOne
//    @JoinColumn (name="student_id")
//    private int studentId;
//    private Student_DB student;

//    @Column(name = "course_id", insertable = false, updatable = false)
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @ManyToOne
//    @JoinColumn (name="course_id")
//     private int courseId;
//    private Course_DB course;
}
