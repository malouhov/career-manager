package pet.malouhov.careermanager.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "resumes")
public class Resume {

    /*
    long id;
    User employee;
    Optional<List<Education>> educations;
    Optional<List<Experience>> experiences;
    Optional<List<Skill>> skills;
    Optional<List<Certification>> certifications;
    Optional<List<Award>> awards;
    ResumeStatus status;
    LocalDate created;
    LocalDate updated;
     */

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

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private ResumeStatus resumeStatus = ResumeStatus.RESUME_SENT;

    @Column(nullable = false)
    private LocalDate sent = LocalDate.now();

    public enum ResumeStatus {
        RESUME_SENT,
        RESUME_PENDING,
        INTERVIEW_SCHEDULED,
        RESUME_REJECTED

    }

}
