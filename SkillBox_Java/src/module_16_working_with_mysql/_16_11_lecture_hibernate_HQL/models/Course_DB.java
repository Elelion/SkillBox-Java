package module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Courses")
public class Course_DB {

    private enum CourseType_DB {
        DESIGN,
        PROGRAMMING,
        MARKETING,
        MANAGEMENT,
        BUSINESS
    }

    /**/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition="enum('DESIGN','PROGRAMMING', 'MARKETING', 'MANAGEMENT', 'BUSINESS')")
    private CourseType_DB type;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher_DB teacher;

    @Column(name = "students_count", nullable = true)
    private Integer studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "Subscriptions",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student_DB> students;
}
