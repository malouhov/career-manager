package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "resumes")
public class Resume {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @Column(nullable = false)
    private String company;

    @NonNull
    @Column(nullable = false)
    private String vacancy;

    @NonNull
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Status status = Status.RESUME_SENT;

    @Column(nullable = false)
    private LocalDate sent = LocalDate.now();

    public enum Status {
        RESUME_SENT,
        RESUME_PENDING,
        INTERVIEW_SCHEDULED,
        RESUME_REJECTED

    }


    public static void main(String[] args) {


        Resume resume = new Resume("Cber",
                "Java Developer",
                "Middle Java Dev.");

        System.out.println(resume);

        /*
             Student student = new Student();
     entityManager.persist(student);
     ...
     Student s = entityManager.find(Student.class, student.getStudentId());
     System.out.println(s)
     ...
         */
    }


}
