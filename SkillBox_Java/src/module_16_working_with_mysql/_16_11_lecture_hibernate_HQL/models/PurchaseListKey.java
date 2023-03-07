package module_16_working_with_mysql._16_11_lecture_hibernate_HQL.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@Setter
@NoArgsConstructor
public class PurchaseListKey implements Serializable {
    static final long serialVersionUID = 1L;

    @Column(name = "student_name", columnDefinition="varchar(100)" )
    private String studentName;

    @Column(name = "course_name", columnDefinition="varchar(100)" )
    private String courseName;

    PurchaseListKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

}
