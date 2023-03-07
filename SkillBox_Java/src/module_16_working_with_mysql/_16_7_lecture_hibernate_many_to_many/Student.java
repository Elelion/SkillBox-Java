package module_16_working_with_mysql._16_7_lecture_hibernate_many_to_many;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int String;
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;


}
